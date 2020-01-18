package com.ledao.controller.admin;

import com.ledao.entity.Customer;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
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
 * 后台管理客户Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 19:09
 */
@RestController
@RequestMapping("/admin/customer")
public class CustomerAdminController {

    @Resource
    private CustomerService customerService;

    @Resource
    private LogService logService;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = {"销售出库", "客户退货", "销售单据查询", "客户退货查询", "客户统计"}, logical = Logical.OR)
    public List<Customer> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return customerService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页查询客户信息
     *
     * @param searchCustomer
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "客户管理")
    public Map<String, Object> list(Customer searchCustomer, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(searchCustomer.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", customerService.list(map));
        resultMap.put("total", customerService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询客户信息"));
        return resultMap;
    }

    /**
     * 添加或者修改客户信息
     *
     * @param customer
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户管理")
    public Map<String, Object> save(Customer customer) {
        int key;
        Map<String, Object> resultMap = new HashMap<>(16);
        if (customer.getId() == null) {
            key = customerService.add(customer);
            logService.add(new Log(Log.ADD_ACTION, "添加客户信息" + customer));
        } else {
            key = customerService.update(customer);
            logService.add(new Log(Log.UPDATE_ACTION, "修改客户信息" + customer));
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除客户信息" + customerService.findById(id)));
            customerService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
