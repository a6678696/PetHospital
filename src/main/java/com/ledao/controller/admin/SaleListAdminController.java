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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 后台管理销售单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/saleList")
public class SaleListAdminController {

    @Resource
    private SaleListService saleListService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private UserService userService;

    @Resource
    private CustomerService customerService;

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
     * 获取销售单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "销售出库")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("XS");
        code.append(DateUtil.getCurrentDateStr());
        String saleNumber = saleListService.getTodayMaxSaleNumber();
        if (saleNumber != null) {
            code.append(StringUtil.formatCode(saleNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加销售单 以及所有销售单商品
     *
     * @param saleList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "销售出库")
    public Map<String, Object> save(SaleList saleList, String goodsJson) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        saleList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<SaleListGoods> saleListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<SaleListGoods>>() {
        }.getType());
        saleListService.add(saleList);
        for (SaleListGoods saleListGoods : saleListGoodsList) {
            // 设置类别
            saleListGoods.setType(goodsTypeService.findById(saleListGoods.getTypeId()));
            //设置销售单
            saleListGoods.setSaleList(saleListService.findBySaleNumber(saleList.getSaleNumber()));
            saleListGoodsService.add(saleListGoods);

            //修改商品库存 成本均价 以及上次进价
            Goods goods = goodsService.findById(saleListGoods.getGoodsId());
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() - saleListGoods.getNum());
            //设置新的上次进价
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加销售单" + saleList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有销售单信息
     *
     * @param saleList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"销售单据查询", "供应商统计"}, logical = Logical.OR)
    public Map<String, Object> list(SaleList saleList, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("saleNumber", StringUtil.formatLike(saleList.getSaleNumber()));
        map.put("customer", customerService.findById(saleList.getCustomerId()));
        map.put("state", saleList.getState());
        map.put("bSaleDate", saleList.getbSaleDate());
        map.put("eSaleDate", saleList.geteSaleDate());
        if (page != null) {
            PageBean pageBean = new PageBean(page, rows);
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        List<SaleList> saleListList = saleListService.list(map);
        Long total = saleListService.getCount(map);
        resultMap.put("rows", saleListList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "销售单查询"));
        return resultMap;
    }

    /**
     * 根据条件获取商品采购信息
     *
     * @param saleList
     * @param saleListGoods
     * @return
     */
    @RequestMapping("/listCount")
    @RequiresPermissions(value = "商品采购统计")
    public Map<String, Object> listCount(SaleList saleList, SaleListGoods saleListGoods) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("bSaleDate", saleList.getbSaleDate());
        map.put("eSaleDate", saleList.geteSaleDate());
        List<SaleList> saleListList = saleListService.list(map);
        for (SaleList pl : saleListList) {
            Map<String, Object> map2 = new HashMap<>(16);
            map2.put("saleListId", pl.getId());
            map2.put("type", saleListGoods.getType());
            map2.put("codeOrName", saleListGoods.getCodeOrName());
            List<SaleListGoods> saleListGoodsList = saleListGoodsService.list(map2);
            pl.setSaleListGoodsList(saleListGoodsList);
        }
        resultMap.put("rows", saleListList);
        logService.add(new Log(Log.SEARCH_ACTION, "商品采购统计查询"));
        return resultMap;
    }

    /**
     * 根据销售单id查询所有销售单商品
     *
     * @param saleListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "销售单据查询")
    public Map<String, Object> listGoods(Integer saleListId) {
        if (saleListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", saleListGoodsService.listBySaleListId(saleListId));
        logService.add(new Log(Log.SEARCH_ACTION, "销售单商品查询"));
        return resultMap;
    }

    /**
     * 删除销售单 以及销售单里的商品
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "销售单据查询")
    public Map<String, Object> delete(Integer id) throws Exception {
        logService.add(new Log(Log.DELETE_ACTION, "删除销售单信息：" + saleListService.findById(id)));
        Map<String, Object> resultMap = new HashMap<>(16);
        saleListGoodsService.deleteBySaleListId(id);
        saleListService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 修改销售单的支付状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions(value = "客户统计")
    public Map<String, Object> update(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        SaleList saleList = saleListService.findById(id);
        saleList.setState(1);
        saleListService.update(saleList);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 按日统计分析
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/countSaleByDay")
    @RequiresPermissions(value = "按日统计分析")
    public Map<String, Object> countSaleByDay(String begin, String end) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<SaleCount> saleCountList = new ArrayList<>();
        //要显示的天数
        List<String> dates = DateUtil.getRangeDates(begin, end);
        //有数据的天数
        List<SaleCount> objectList = saleListService.countSaleByDay(begin, end);
        for (SaleCount saleCount : objectList) {
            saleCount.setAmountProfit(saleCount.getAmountSale() - saleCount.getAmountCost());
        }
        for (String date : dates) {
            SaleCount saleCount = new SaleCount();
            saleCount.setDate(date);
            boolean flag = false;
            for (SaleCount count : objectList) {
                if (count.getDate().equals(date)) {
                    // 成本总金额
                    saleCount.setAmountCost(MathUtil.format2Bit(Float.parseFloat(String.valueOf(count.getAmountCost()))));
                    // 销售总金额
                    saleCount.setAmountSale(MathUtil.format2Bit(Float.parseFloat(String.valueOf(count.getAmountSale()))));
                    // 销售利润
                    saleCount.setAmountProfit(MathUtil.format2Bit(count.getAmountProfit()));
                    flag = true;
                }
            }
            if (!flag) {
                saleCount.setAmountCost(0);
                saleCount.setAmountSale(0);
                saleCount.setAmountProfit(0);
            }
            saleCountList.add(saleCount);
        }
        resultMap.put("rows", saleCountList);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 按月统计分析
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/countSaleByMonth")
    @RequiresPermissions(value = "按月统计分析")
    public Map<String, Object> countSaleByMonth(String begin, String end) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        List<SaleCount> saleCountList = new ArrayList<>();
        //要显示的月数
        List<String> dates = DateUtil.getRangeMonths(begin, end);
        //有数据的月数
        List<SaleCount> objectList = saleListService.countSaleByMonth(begin, end);
        for (SaleCount saleCount : objectList) {
            saleCount.setAmountProfit(saleCount.getAmountSale() - saleCount.getAmountCost());
        }
        for (String date : dates) {
            SaleCount saleCount = new SaleCount();
            saleCount.setDate(date);
            boolean flag = false;
            for (SaleCount count : objectList) {
                if (count.getDate().equals(date)) {
                    // 成本总金额
                    saleCount.setAmountCost(MathUtil.format2Bit(Float.parseFloat(String.valueOf(count.getAmountCost()))));
                    // 销售总金额
                    saleCount.setAmountSale(MathUtil.format2Bit(Float.parseFloat(String.valueOf(count.getAmountSale()))));
                    // 销售利润
                    saleCount.setAmountProfit(MathUtil.format2Bit(count.getAmountProfit()));
                    flag = true;
                }
            }
            if (!flag) {
                saleCount.setAmountCost(0);
                saleCount.setAmountSale(0);
                saleCount.setAmountProfit(0);
            }
            saleCountList.add(saleCount);
        }
        resultMap.put("rows", saleCountList);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 修改订单的状态,如果是取消订单会将订单商品的数量释放到库存中
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/handleOrder")
    public Map<String, Object> handleOrder(Integer id, Integer status) {
        Map<String, Object> resultMap = new HashMap<>(16);
        SaleList saleList = saleListService.findById(id);
        //3代表的是已发货状态
        int shipStatus = 3;
        if (saleList.getState() >= shipStatus) {
            if (saleList.getState()==6) {
                resultMap.put("errorInfo", "该订单已被取消,不能操作!");
                return resultMap;
            }
            if (status==6) {
                resultMap.put("errorInfo", "该订单已发货,不能取消!");
                return resultMap;
            }
        }
        saleList.setState(status);
        if (status==6) {
            List<SaleListGoods> saleListGoodsList = saleList.getSaleListGoodsList();
            for (SaleListGoods saleListGoods : saleListGoodsList) {
                Goods goods = goodsService.findById(saleListGoods.getGoodsId());
                goods.setInventoryQuantity(goods.getInventoryQuantity() + saleListGoods.getNum());
                goodsService.update(goods);
            }
        }
        saleListService.update(saleList);
        resultMap.put("success", true);
        return resultMap;
    }
}
