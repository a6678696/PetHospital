package com.ledao.controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ledao.entity.*;
import com.ledao.service.*;
import com.ledao.util.DateUtil;
import com.ledao.util.MathUtil;
import com.ledao.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理进货单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/purchaseList")
public class PurchaseListAdminController {

    @Resource
    private PurchaseListService purchaseListService;

    @Resource
    private PurchaseListGoodsService purchaseListGoodsService;

    @Resource
    private UserService userService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private LogService logService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 获取进货单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "进货入库")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("JH");
        code.append(DateUtil.getCurrentDateStr());
        String purchaseNumber = purchaseListService.getTodayMaxPurchaseNumber();
        if (purchaseNumber != null) {
            code.append(StringUtil.formatCode(purchaseNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加进货单 以及所有进货单商品
     *
     * @param purchaseList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "进货入库")
    public Map<String, Object> save(PurchaseList purchaseList, String goodsJson) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        purchaseList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<PurchaseListGoods> purchaseListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<PurchaseListGoods>>() {
        }.getType());
        purchaseListService.add(purchaseList);
        for (PurchaseListGoods purchaseListGoods : purchaseListGoodsList) {
            // 设置类别
            purchaseListGoods.setType(goodsTypeService.findById(purchaseListGoods.getTypeId()));
            //设置进货单
            purchaseListGoods.setPurchaseList(purchaseListService.findByPurchaseNumber(purchaseList.getPurchaseNumber()));
            purchaseListGoodsService.add(purchaseListGoods);

            //修改商品库存 成本均价 以及上次进价
            Goods goods = goodsService.findById(purchaseListGoods.getGoodsId());
            //成本均价
            float svePurchasePrice = (goods.getPurchasingPrice() * goods.getInventoryQuantity() + purchaseListGoods.getPrice() * purchaseListGoods.getNum()) / (goods.getInventoryQuantity() + purchaseListGoods.getNum());
            goods.setPurchasingPrice(MathUtil.format2Bit(svePurchasePrice));
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() + purchaseListGoods.getNum());
            //设置新的上次进价
            goods.setLastPurchasingPrice(purchaseListGoods.getPrice());
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加进货单" + purchaseList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有进货单信息
     *
     * @param purchaseList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"进货单据查询", "供应商统计"}, logical = Logical.OR)
    public Map<String, Object> list(PurchaseList purchaseList) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("purchaseNumber", StringUtil.formatLike(purchaseList.getPurchaseNumber()));
        map.put("supplier", purchaseList.getSupplier());
        map.put("state", purchaseList.getState());
        map.put("bPurchaseDate", purchaseList.getbPurchaseDate());
        map.put("ePurchaseDate", purchaseList.getePurchaseDate());
        List<PurchaseList> purchaseListList = purchaseListService.list(map);
        resultMap.put("rows", purchaseListList);
        logService.add(new Log(Log.SEARCH_ACTION, "进货单查询"));
        return resultMap;
    }

    /**
     * 根据条件获取商品采购信息
     *
     * @param purchaseList
     * @param purchaseListGoods
     * @return
     */
    @RequestMapping("/listCount")
    @RequiresPermissions(value = "商品采购统计")
    public Map<String, Object> listCount(PurchaseList purchaseList, PurchaseListGoods purchaseListGoods) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("bPurchaseDate", purchaseList.getbPurchaseDate());
        map.put("ePurchaseDate", purchaseList.getePurchaseDate());
        List<PurchaseList> purchaseListList = purchaseListService.list(map);
        for (PurchaseList pl : purchaseListList) {
            Map<String, Object> map2 = new HashMap<>(16);
            map2.put("purchaseListId", pl.getId());
            map2.put("type", purchaseListGoods.getType());
            map2.put("codeOrName", purchaseListGoods.getCodeOrName());
            List<PurchaseListGoods> purchaseListGoodsList = purchaseListGoodsService.list(map2);
            pl.setPurchaseListGoodsList(purchaseListGoodsList);
        }
        resultMap.put("rows", purchaseListList);
        logService.add(new Log(Log.SEARCH_ACTION, "商品采购统计查询"));
        return resultMap;
    }

    /**
     * 根据进货单id查询所有进货单商品
     *
     * @param purchaseListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "进货单据查询")
    public Map<String, Object> listGoods(Integer purchaseListId) {
        if (purchaseListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", purchaseListGoodsService.listByPurchaseListId(purchaseListId));
        logService.add(new Log(Log.SEARCH_ACTION, "进货单商品查询"));
        return resultMap;
    }

    /**
     * 删除进货单 以及进货单里的商品
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "进货单据查询")
    public Map<String, Object> delete(Integer id) throws Exception {
        logService.add(new Log(Log.DELETE_ACTION, "删除进货单信息：" + purchaseListService.findById(id)));
        Map<String, Object> resultMap = new HashMap<>(16);
        purchaseListGoodsService.deleteByPurchaseListId(id);
        purchaseListService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 修改进货单的支付状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions(value = "供应商统计")
    public Map<String, Object> update(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        PurchaseList purchaseList = purchaseListService.findById(id);
        purchaseList.setState(1);
        purchaseListService.update(purchaseList);
        resultMap.put("success", true);
        return resultMap;
    }
}
