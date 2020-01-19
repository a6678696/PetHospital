package com.ledao.controller.admin;

import com.ledao.entity.GoodsUnit;
import com.ledao.entity.Log;
import com.ledao.service.GoodsUnitService;
import com.ledao.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理商品单位Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 11:22
 */
@RestController
@RequestMapping("/admin/goodsUnit")
public class GoodsUnitAdminController {

    @Resource
    private GoodsUnitService goodsUnitService;

    @Resource
    private LogService logService;

    /**
     * 返回所有商品单位 下拉框用到
     *
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = "商品管理")
    public List<GoodsUnit> comboList() {
        return goodsUnitService.listAll();
    }

    /**
     * 查询所有商品单位信息
     *
     * @return
     */
    @RequestMapping("/listAll")
    @RequiresPermissions(value = "商品管理")
    public Map<String, Object> listAll() {
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", goodsUnitService.listAll());
        logService.add(new Log(Log.SEARCH_ACTION, "查询商品单位信息"));
        return resultMap;
    }

    /**
     * 添加商品单位
     *
     * @param goodsUnit
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品管理")
    public Map<String, Object> save(GoodsUnit goodsUnit) {
        Map<String, Object> resultMap = new HashMap<>(16);
        goodsUnitService.add(goodsUnit);
        logService.add(new Log(Log.ADD_ACTION, "添加商品单位信息"));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 商品单位删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "商品管理")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        logService.add(new Log(Log.DELETE_ACTION, "删除商品单位信息：" + goodsUnitService.findById(id)));
        goodsUnitService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }
}
