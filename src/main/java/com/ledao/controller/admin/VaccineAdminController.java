package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.PetService;
import com.ledao.service.VaccineService;
import com.ledao.service.LogService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理疫苗注射记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 12:42
 */
@RestController
@RequestMapping("/admin/vaccine")
public class VaccineAdminController {

    @Resource
    private VaccineService vaccineService;

    @Resource
    private CustomerService customerService;

    @Resource
    private PetService petService;

    @Resource
    private LogService logService;

    /**
     * 分页分条件查询疫苗注射记录
     *
     * @param vaccine
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "疫苗注射记录管理")
    public Map<String, Object> list(Vaccine vaccine, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("customerName", StringUtil.formatLike(vaccine.getCustomerName()));
        map.put("petName", StringUtil.formatLike(vaccine.getPetName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", vaccineService.list(map));
        resultMap.put("total", vaccineService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询疫苗注射记录"));
        return resultMap;
    }

    /**
     * 添加或修改疫苗注射记录
     *
     * @param vaccine
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "疫苗注射记录管理")
    public Map<String, Object> save(Vaccine vaccine) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Customer customer = customerService.findByContact(vaccine.getCustomerName());
        Pet pet = petService.findByName(vaccine.getPetName());
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
        if (vaccine.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加疫苗注射记录" + vaccine));
            key = vaccineService.add(vaccine);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改疫苗注射记录" + vaccine));
            key = vaccineService.update(vaccine);
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
    @RequiresPermissions(value = "疫苗注射记录管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            logService.add(new Log(Log.DELETE_ACTION, "删除文章类型" + vaccineService.findById(Integer.parseInt(idsStr[i]))));
            vaccineService.delete(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
