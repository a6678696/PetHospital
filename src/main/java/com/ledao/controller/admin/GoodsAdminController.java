package com.ledao.controller.admin;

import com.ledao.entity.Goods;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.service.CustomerReturnListGoodsService;
import com.ledao.service.GoodsService;
import com.ledao.service.LogService;
import com.ledao.service.SaleListGoodsService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
        /*if(searchGoods.getType()!=null && searchGoods.getType().getId()!=null && searchGoods.getType().getId()!=1){
            map.put("typeId", searchGoods.getType().getId());
        }*/
        map.put("typeId", searchGoods.getType().getId());
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
        map.put("typeId", searchGoods.getType().getId());
        map.put("codeOrName", searchGoods.getCodeOrName());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Goods> goodsList = goodsService.list(map);
        Long total = goodsService.getCount(map);
        for (Goods goods : goodsList) {
            // 设置销售总量
            goods.setSaleTotal((int) (saleListGoodsService.getTotalByGoodsId(goods.getId()) - customerReturnListGoodsService.getTotalByGoodsId(goods.getId())));
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
}
