package com.ledao.controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ledao.entity.*;
import com.ledao.service.*;
import com.ledao.util.DateUtil;
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
 * 后台管理客户退货单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/customerReturnList")
public class CustomerReturnListAdminController {

    @Resource
    private CustomerReturnListService customerReturnListService;

    @Resource
    private CustomerReturnListGoodsService customerReturnListGoodsService;

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
     * 获取客户退货单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "客户退货")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("XT");
        code.append(DateUtil.getCurrentDateStr());
        String customerReturnNumber = customerReturnListService.getTodayMaxCustomerReturnNumber();
        if (customerReturnNumber != null) {
            code.append(StringUtil.formatCode(customerReturnNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加客户退货单 以及所有客户退货单商品
     *
     * @param customerReturnList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户退货")
    public Map<String, Object> save(CustomerReturnList customerReturnList, String goodsJson) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        customerReturnList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<CustomerReturnListGoods> customerReturnListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<CustomerReturnListGoods>>() {
        }.getType());
        customerReturnListService.add(customerReturnList);
        for (CustomerReturnListGoods customerReturnListGoods : customerReturnListGoodsList) {
            // 设置类别
            customerReturnListGoods.setType(goodsTypeService.findById(customerReturnListGoods.getTypeId()));
            //设置客户退货单
            customerReturnListGoods.setCustomerReturnList(customerReturnListService.findByCustomerReturnNumber(customerReturnList.getCustomerReturnNumber()));
            customerReturnListGoodsService.add(customerReturnListGoods);

            //修改商品库存 成本均价 以及上次进价
            Goods goods = goodsService.findById(customerReturnListGoods.getGoodsId());
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() + customerReturnListGoods.getNum());
            //设置新的上次进价
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加客户退货单"+customerReturnList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有客户退货单信息
     *
     * @param customerReturnList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"客户退货查询", "供应商统计"}, logical = Logical.OR)
    public Map<String, Object> list(CustomerReturnList customerReturnList) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("customerReturnNumber", StringUtil.formatLike(customerReturnList.getCustomerReturnNumber()));
        map.put("customer", customerReturnList.getCustomer());
        map.put("state", customerReturnList.getState());
        map.put("bCustomerReturnDate", customerReturnList.getbCustomerReturnDate());
        map.put("eCustomerReturnDate", customerReturnList.geteCustomerReturnDate());
        List<CustomerReturnList> customerReturnListList = customerReturnListService.list(map);
        resultMap.put("rows", customerReturnListList);
        logService.add(new Log(Log.SEARCH_ACTION, "客户退货单查询"));
        return resultMap;
    }

    /**
     * 根据条件获取商品采购信息
     *
     * @param customerReturnList
     * @param customerReturnListGoods
     * @return
     */
    @RequestMapping("/listCount")
    @RequiresPermissions(value = "商品采购统计")
    public Map<String, Object> listCount(CustomerReturnList customerReturnList, CustomerReturnListGoods customerReturnListGoods) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("customerReturnNumber", StringUtil.formatLike(customerReturnList.getCustomerReturnNumber()));
        map.put("customer", customerReturnList.getCustomer());
        map.put("state", customerReturnList.getState());
        map.put("bCustomerReturnDate", customerReturnList.getbCustomerReturnDate());
        map.put("eCustomerReturnDate", customerReturnList.geteCustomerReturnDate());
        List<CustomerReturnList> customerReturnListList = customerReturnListService.list(map);
        for (CustomerReturnList pl : customerReturnListList) {
            Map<String, Object> map2 = new HashMap<>(16);
            map2.put("customerReturnListId", pl.getId());
            map2.put("typeId", customerReturnListGoods.getType().getId());
            map2.put("codeOrName", customerReturnListGoods.getCodeOrName());
            List<CustomerReturnListGoods> customerListGoodsList = customerReturnListGoodsService.list(map2);
            pl.setCustomerReturnListGoodsList(customerListGoodsList);
        }
        resultMap.put("rows", customerReturnListList);
        logService.add(new Log(Log.SEARCH_ACTION, "商品采购统计查询"));
        return resultMap;
    }

    /**
     * 根据客户退货单id查询所有客户退货单商品
     *
     * @param customerReturnListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "客户退货查询")
    public Map<String, Object> listGoods(Integer customerReturnListId) {
        if (customerReturnListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", customerReturnListGoodsService.listByCustomerReturnListId(customerReturnListId));
        logService.add(new Log(Log.SEARCH_ACTION, "客户退货单商品查询"));
        return resultMap;
    }

    /**
     * 删除客户退货单 以及客户退货单里的商品
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户退货查询")
    public Map<String, Object> delete(Integer id) throws Exception {
        logService.add(new Log(Log.DELETE_ACTION, "删除客户退货单信息：" + customerReturnListService.findById(id)));
        Map<String, Object> resultMap = new HashMap<>(16);
        customerReturnListGoodsService.deleteByCustomerReturnListId(id);
        customerReturnListService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 修改客户退货单的支付状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions(value = "供应商统计")
    public Map<String, Object> update(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        CustomerReturnList customerReturnList = customerReturnListService.findById(id);
        customerReturnList.setState(1);
        customerReturnListService.update(customerReturnList);
        resultMap.put("success", true);
        return resultMap;
    }
}
