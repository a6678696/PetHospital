package com.ledao.controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ledao.entity.Goods;
import com.ledao.entity.Log;
import com.ledao.entity.ReturnList;
import com.ledao.entity.ReturnListGoods;
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
 * 后台管理退货单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/returnList")
public class ReturnListAdminController {

    @Resource
    private ReturnListService returnListService;

    @Resource
    private ReturnListGoodsService returnListGoodsService;

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
     * 获取退货单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "退货出库")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("TH");
        code.append(DateUtil.getCurrentDateStr());
        String returnNumber = returnListService.getTodayMaxReturnNumber();
        if (returnNumber != null) {
            code.append(StringUtil.formatCode(returnNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加退货单 以及所有退货单商品
     *
     * @param returnList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "退货出库")
    public Map<String, Object> save(ReturnList returnList, String goodsJson) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        returnList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<ReturnListGoods> returnListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<ReturnListGoods>>() {
        }.getType());
        returnListService.add(returnList);
        for (ReturnListGoods returnListGoods : returnListGoodsList) {
            // 设置类别
            returnListGoods.setType(goodsTypeService.findById(returnListGoods.getTypeId()));
            //设置退货单
            returnListGoods.setReturnList(returnListService.findByReturnNumber(returnList.getReturnNumber()));
            returnListGoodsService.add(returnListGoods);

            //修改商品库存 成本均价 以及上次进价
            Goods goods = goodsService.findById(returnListGoods.getGoodsId());
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() - returnListGoods.getNum());
            //设置新的上次进价
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加退货单"+returnList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有退货单信息
     *
     * @param returnList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"退货单据查询", "供应商统计"}, logical = Logical.OR)
    public Map<String, Object> list(ReturnList returnList) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("returnNumber", StringUtil.formatLike(returnList.getReturnNumber()));
        map.put("supplier", returnList.getSupplier());
        map.put("state", returnList.getState());
        map.put("bReturnDate", returnList.getbReturnDate());
        map.put("eReturnDate", returnList.geteReturnDate());
        List<ReturnList> returnListList = returnListService.list(map);
        resultMap.put("rows", returnListList);
        logService.add(new Log(Log.SEARCH_ACTION, "退货单查询"));
        return resultMap;
    }

    /**
     * 根据条件获取商品采购信息
     *
     * @param returnList
     * @param returnListGoods
     * @return
     */
    @RequestMapping("/listCount")
    @RequiresPermissions(value = "商品采购统计")
    public Map<String, Object> listCount(ReturnList returnList, ReturnListGoods returnListGoods) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("bReturnDate", returnList.getbReturnDate());
        map.put("eReturnDate", returnList.geteReturnDate());
        List<ReturnList> returnListList = returnListService.list(map);
        for (ReturnList pl : returnListList) {
            Map<String, Object> map2 = new HashMap<>(16);
            map2.put("returnListId", pl.getId());
            map2.put("type", returnListGoods.getType());
            map2.put("codeOrName", returnListGoods.getCodeOrName());
            List<ReturnListGoods> returnListGoodsList = returnListGoodsService.list(map2);
            pl.setReturnListGoodsList(returnListGoodsList);
        }
        resultMap.put("rows", returnListList);
        logService.add(new Log(Log.SEARCH_ACTION, "商品采购统计查询"));
        return resultMap;
    }

    /**
     * 根据退货单id查询所有退货单商品
     *
     * @param returnListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "退货单据查询")
    public Map<String, Object> listGoods(Integer returnListId) {
        if (returnListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", returnListGoodsService.listByReturnListId(returnListId));
        logService.add(new Log(Log.SEARCH_ACTION, "退货单商品查询"));
        return resultMap;
    }

    /**
     * 删除退货单 以及退货单里的商品
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "退货单据查询")
    public Map<String, Object> delete(Integer id) throws Exception {
        logService.add(new Log(Log.DELETE_ACTION, "删除退货单信息：" + returnListService.findById(id)));
        Map<String, Object> resultMap = new HashMap<>(16);
        returnListGoodsService.deleteByReturnListId(id);
        returnListService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 修改退货单的支付状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions(value = "供应商统计")
    public Map<String, Object> update(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        ReturnList returnList = returnListService.findById(id);
        returnList.setState(1);
        returnListService.update(returnList);
        resultMap.put("success", true);
        return resultMap;
    }
}
