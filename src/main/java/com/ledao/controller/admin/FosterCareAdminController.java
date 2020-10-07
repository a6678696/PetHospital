package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.FosterCareService;
import com.ledao.service.LogService;
import com.ledao.service.PetService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理寄养记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 12:42
 */
@RestController
@RequestMapping("/admin/fosterCare")
public class FosterCareAdminController {

    @Resource
    private FosterCareService fosterCareService;

    @Resource
    private CustomerService customerService;

    @Resource
    private PetService petService;

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
     * 分页分条件查询寄养记录
     *
     * @param fosterCare
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "寄养记录管理")
    public Map<String, Object> list(FosterCare fosterCare, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtil.isNotEmpty(fosterCare.getCustomerName())) {
            Customer customer = customerService.findByContact(fosterCare.getCustomerName());
            fosterCare.setCustomer(customer);
            if (fosterCare.getCustomer() == null) {
                map.put("customerId", -1);
            } else {
                map.put("customerId", fosterCare.getCustomer().getId());
            }
        }
        if (StringUtil.isNotEmpty(fosterCare.getPetName())) {
            fosterCare.setPet(petService.findByName(fosterCare.getPetName()));
            if (fosterCare.getPet() == null) {
                map.put("petId", -1);
            } else {
                map.put("petId", fosterCare.getPet().getId());
            }
        }
        map.put("status", fosterCare.getStatus());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<FosterCare> fosterCareList = fosterCareService.list(map);
        for (FosterCare care : fosterCareList) {
            care.setCustomerName(care.getCustomer().getContact());
            care.setPetName(care.getPet().getName());
        }
        resultMap.put("rows", fosterCareList);
        resultMap.put("total", fosterCareService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询寄养记录"));
        return resultMap;
    }

    /**
     * 添加或修改寄养记录
     *
     * @param fosterCare
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "寄养记录管理")
    public Map<String, Object> save(FosterCare fosterCare) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Customer customer = customerService.findByContact(fosterCare.getCustomerName());
        Pet pet = petService.findByName(fosterCare.getPetName());
        if (customer == null) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该客户不存在,请核实!!");
            return resultMap;
        }
        if (pet == null) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该宠物不存在,请核实!!");
            return resultMap;
        } else {
            Map<String,Object> map=new HashMap<>(16);
            map.put("customer", customer);
            List<Pet> petList = petService.list(map);
            boolean flag=false;
            for (Pet pet1 : petList) {
                if (pet1.getName().equals(pet.getName())) {
                    flag = true;
                    break;
                }
            }
            if (flag==false) {
                resultMap.put("success", false);
                resultMap.put("errorInfo", "该客户没有这个宠物,请核实!!");
                return resultMap;
            }
        }
        int key;
        if (fosterCare.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加寄养记录" + fosterCare));
            fosterCare.setCustomer(customer);
            fosterCare.setPet(pet);
            key = fosterCareService.add(fosterCare);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改寄养记录" + fosterCare));
            fosterCare.setCustomer(customer);
            fosterCare.setPet(pet);
            key = fosterCareService.update(fosterCare);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除病例单(可批量删除)
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "寄养记录管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            logService.add(new Log(Log.DELETE_ACTION, "删除文章类型" + fosterCareService.findById(Integer.parseInt(idsStr[i]))));
            fosterCareService.delete(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);
        return resultMap;
    }

    @RequestMapping("/payFosterCare")
    @RequiresPermissions(value = "寄养记录管理")
    public Map<String, Object> payFosterCare(String id) {
        Map<String,Object> resultMap=new HashMap<>(16);
        FosterCare fosterCare = fosterCareService.findById(Integer.parseInt(id));
        fosterCare.setStatus(1);
        fosterCareService.update(fosterCare);
        logService.add(new Log(Log.UPDATE_ACTION, "支付结算" + fosterCare));
        resultMap.put("success", true);
        return resultMap;
    }
}
