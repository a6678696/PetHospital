package com.ledao.controller.admin;

import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.entity.Tackle;
import com.ledao.service.LogService;
import com.ledao.service.TackleService;
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
 * 后台管理医院用品Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-04-08 10:52
 */
@RestController
@RequestMapping("/admin/tackle")
public class TackleAdminController {

    @Resource
    private TackleService tackleService;

    @Resource
    private LogService logService;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = "设备使用记录管理")
    public List<Tackle> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return tackleService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页分条件查询医院用品
     *
     * @param tackle
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "医院用品管理")
    public Map<String, Object> list(Tackle tackle, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(tackle.getName()));
        map.put("status", tackle.getStatus());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", tackleService.list(map));
        resultMap.put("total", tackleService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询医院用品"));
        return resultMap;
    }

    /**
     * 添加或修改医院用品
     *
     * @param tackle
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "医院用品管理")
    public Map<String, Object> save(Tackle tackle) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (tackle.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加医院用品" + tackle));
            tackle.setStatus(0);
            key = tackleService.add(tackle);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改医院用品" + tackle));
            key = tackleService.update(tackle);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除医院用品(可批量删除)
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "医院用品管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除医院用品" + tackleService.findById(id)));
            tackleService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 分页分条件查询在库中的医院用品信息
     *
     * @param tackle
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listNoOut")
    @RequiresPermissions(value = "医院用品出入库管理")
    public Map<String, Object> listNoOut(Tackle tackle, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 0);
        map.put("name", StringUtil.formatLike(tackle.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", tackleService.list(map));
        resultMap.put("total", tackleService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查看在库中的医院用品信息"));
        return resultMap;
    }

    /**
     * 分页分条件查询已出库的医院用品信息
     *
     * @param tackle
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listIsOut")
    @RequiresPermissions(value = "医院用品出入库管理")
    public Map<String, Object> listIsOut(Tackle tackle, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 1);
        map.put("name", StringUtil.formatLike(tackle.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", tackleService.list(map));
        resultMap.put("total", tackleService.getCount(map));
        logService.add(new Log(Log.ADD_ACTION, "查看已出库的医院用品信息"));
        return resultMap;
    }
}
