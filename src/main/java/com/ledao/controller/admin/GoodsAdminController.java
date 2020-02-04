package com.ledao.controller.admin;

import com.ledao.entity.Goods;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.service.CustomerReturnListGoodsService;
import com.ledao.service.GoodsService;
import com.ledao.service.LogService;
import com.ledao.service.SaleListGoodsService;
import com.ledao.util.DateUtil;
import com.ledao.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理商品Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 11:27
 */
@RestController
@RequestMapping("/admin/goods")
public class GoodsAdminController {

    @Value("${goodsImageFilePath}")
    private String goodsImageFilePath;

    @Resource
    private GoodsService goodsService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private CustomerReturnListGoodsService customerReturnListGoodsService;

    @Resource
    private LogService logService;

    /**
     * 分页查询商品信息
     *
     * @param searchGoods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"商品管理", "进货入库", "退货出库", "销售出库", "客户退货", "商品报损", "商品报溢"}, logical = Logical.OR)
    public Map<String, Object> list(Goods searchGoods, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("name", StringUtil.formatLike(searchGoods.getName()));
        if (searchGoods.getType() != null && searchGoods.getType().getId() != null && searchGoods.getType().getId() != 1) {
            map.put("typeId", searchGoods.getType().getId());
        }
        map.put("codeOrName", searchGoods.getCodeOrName());
        resultMap.put("rows", goodsService.list(map));
        resultMap.put("total", goodsService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询商品库存信息"));
        return resultMap;
    }

    /**
     * 查询库存报警商品
     *
     * @return
     */
    @RequestMapping("/listAlarm")
    @RequiresPermissions(value = "库存报警")
    public Map<String, Object> listAlarm() {
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", goodsService.listAlarm());
        logService.add(new Log(Log.SEARCH_ACTION, "查询库存报警商品信息"));
        return resultMap;
    }

    /**
     * 根据条件分页查询商品库存信息
     *
     * @param searchGoods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listInventory")
    @RequiresPermissions(value = "当前库存查询")
    public Map<String, Object> listInventory(Goods searchGoods, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (searchGoods.getType() != null && searchGoods.getType().getId() != null && searchGoods.getType().getId() != 1) {
            map.put("typeId", searchGoods.getType().getId());
        }
        map.put("codeOrName", searchGoods.getCodeOrName());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Goods> goodsList = goodsService.listInventory(map);
        Long total = goodsService.getCountInventory(map);
        for (Goods goods : goodsList) {
            long saleNum;
            long returnNum;
            if (saleListGoodsService.getTotalByGoodsId(goods.getId()) == null) {
                saleNum = 0;
            } else {
                saleNum = saleListGoodsService.getTotalByGoodsId(goods.getId());
            }
            if (customerReturnListGoodsService.getTotalByGoodsId(goods.getId()) == null) {
                returnNum = 0;
            } else {
                returnNum = customerReturnListGoodsService.getTotalByGoodsId(goods.getId());
            }
            goods.setSaleTotal(saleNum - returnNum);
        }
        resultMap.put("rows", goodsList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询商品信息"));
        return resultMap;
    }

    /**
     * 根据条件分页查询没有库存的商品信息
     *
     * @param codeOrName
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/listNoInventoryQuantity")
    @RequiresPermissions(value = "期初库存")
    public Map<String, Object> listNoInventoryQuantity(@RequestParam(value = "codeOrName", required = false) String codeOrName, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("codeOrName", codeOrName);
        resultMap.put("rows", goodsService.listNoInventoryQuantityByCodeOrName(map));
        resultMap.put("total", goodsService.getCountNoInventoryQuantityByCodeOrName(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询商品信息(无库存)"));
        return resultMap;
    }

    /**
     * 根据条件分页查询有库存的商品信息
     *
     * @param codeOrName
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/listHasInventoryQuantity")
    @RequiresPermissions(value = "期初库存")
    public Map<String, Object> listHasInventoryQuantity(@RequestParam(value = "codeOrName", required = false) String codeOrName, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("codeOrName", codeOrName);
        resultMap.put("rows", goodsService.listHasInventoryQuantityByCodeOrName(map));
        resultMap.put("total", goodsService.getCountHasInventoryQuantityByCodeOrName(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询商品信息(无库存)"));
        return resultMap;
    }

    /**
     * 生成商品编码
     *
     * @return
     */
    @RequestMapping("/genGoodsCode")
    @RequiresPermissions(value = "商品管理")
    public String genGoodsCode() {
        String maxGoodsCode = goodsService.getMaxGoodsCode();
        if (StringUtil.isNotEmpty(maxGoodsCode)) {
            Integer code = Integer.parseInt(maxGoodsCode) + 1;
            StringBuilder codes = new StringBuilder(code + "");
            int length = codes.length();
            for (int i = 4; i > length; i--) {
                codes.insert(0, "0");
            }
            return codes.toString();
        } else {
            return "0001";
        }
    }

    /**
     * 添加或者修改商品信息
     *
     * @param goods
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品管理")
    public Map<String, Object> save(Goods goods, @RequestParam("goodsImage")MultipartFile file)throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (!file.isEmpty()) {
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(goodsImageFilePath + newFileName));
            if (goods.getId() != null) {
                FileUtils.deleteQuietly(new File(goodsImageFilePath + goodsService.findById(goods.getId()).getImageName()));
            }
            goods.setImageName(newFileName);
        }
        int key;
        if (goods.getId() != null) {
            //获取更新前的商品信息
            Goods goods1 = goodsService.findById(goods.getId());
            goods.setInventoryQuantity(goods1.getInventoryQuantity());
            goods.setState(goods1.getState());
            goods.setLastPurchasingPrice(goods1.getLastPurchasingPrice());
            logService.add(new Log(Log.UPDATE_ACTION, "更新商品信息" + goods));
            key = goodsService.update(goods);
        } else {
            logService.add(new Log(Log.ADD_ACTION, "添加商品信息" + goods));
            // 设置上次进价为当前价格
            goods.setIsNew(1);
            goods.setLastPurchasingPrice(goods.getPurchasingPrice());
            key = goodsService.add(goods);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "商品管理")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Goods goods = goodsService.findById(id);
        if (goods.getState() == 1) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该商品已经期初入库，不能删除");
        } else if (goods.getState() == 2) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该商品已经发生单据，不能删除");
        } else {
            logService.add(new Log(Log.DELETE_ACTION, "删除商品信息" + goods));
            if (goodsService.findById(id).getImageName() != null) {
                FileUtils.deleteQuietly(new File(goodsImageFilePath + goodsService.findById(goodsService.findById(id).getId()).getImageName()));
            }
            goodsService.delete(id);
            resultMap.put("success", true);
        }
        return resultMap;
    }

    /**
     * 添加商品到仓库 修改库存以及价格信息
     *
     * @param id
     * @param num
     * @param price
     * @return
     */
    @RequestMapping("/saveStore")
    @RequiresPermissions(value = "期初库存")
    public Map<String, Object> saveStore(Integer id, Integer num, Float price) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Goods goods = goodsService.findById(id);
        goods.setInventoryQuantity(num);
        goods.setPurchasingPrice(price);
        goods.setLastPurchasingPrice(price);
        goods.setState(1);
        goodsService.update(goods);
        logService.add(new Log(Log.UPDATE_ACTION, "修改商品信息:" + goods + ",价格=" + price + ",库存=" + num));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除库存，吧商品的库存设置为0
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteStock")
    @RequiresPermissions(value = "期初库存")
    public Map<String, Object> deleteStock(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Goods goods = goodsService.findById(id);
        if (goods.getState() == 2) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该商品已经发生单据，不能删除");
        } else {
            goods.setInventoryQuantity(0);
            goodsService.update(goods);
            logService.add(new Log(Log.UPDATE_ACTION, "修改商品信息" + goods));
            resultMap.put("success", true);
        }
        return resultMap;
    }
}
