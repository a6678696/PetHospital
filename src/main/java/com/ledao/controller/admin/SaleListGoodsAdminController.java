package com.ledao.controller.admin;

import com.ledao.entity.Goods;
import com.ledao.entity.PageBean;
import com.ledao.entity.SaleListGoods;
import com.ledao.service.GoodsService;
import com.ledao.service.SaleListGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理订单商品Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-08 11:14
 */
@RestController
@RequestMapping("/admin/saleListGoods")
public class SaleListGoodsAdminController {

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/list")
    public Map<String, Object> list(SaleListGoods saleListGoods, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String,Object> resultMap=new HashMap<>(16);
        Map<String,Object> map=new HashMap<>(16);
        map.put("saleListId", saleListGoods.getSaleListId());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<SaleListGoods> saleListGoodsList = saleListGoodsService.list(map);
        for (SaleListGoods listGoods : saleListGoodsList) {
            Goods goods = goodsService.findById(listGoods.getGoodsId());
            listGoods.setGoods(goods);
        }
        resultMap.put("rows", saleListGoodsList);
        resultMap.put("total", saleListGoodsService.getCount(map));
        return resultMap;
    }
}
