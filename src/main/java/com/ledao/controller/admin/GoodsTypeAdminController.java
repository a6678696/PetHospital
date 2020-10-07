package com.ledao.controller.admin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ledao.entity.GoodsType;
import com.ledao.entity.Log;
import com.ledao.service.GoodsService;
import com.ledao.service.GoodsTypeService;
import com.ledao.service.LogService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理商品类别Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 10:57
 */
@RestController
@RequestMapping("/admin/goodsType")
public class GoodsTypeAdminController {

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private LogService logService;

    @RequestMapping("/save")
    @RequiresPermissions(value = {"商品管理", "进货入库", "退货出库", "销售出库", "客户退货", "商品报损", "商品报溢"}, logical = Logical.OR)
    public Map<String, Object> save(String name, Integer parentId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        GoodsType goodsType = new GoodsType();
        goodsType.setName(name);
        goodsType.setpId(parentId);
        goodsType.setIcon("icon-folder");
        goodsType.setState(0);
        goodsTypeService.add(goodsType);

        GoodsType parentGoodsType = goodsTypeService.findById(parentId);
        parentGoodsType.setState(1);
        goodsTypeService.update(parentGoodsType);

        logService.add(new Log(Log.ADD_ACTION, "添加商品类别" + goodsType));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 商品类别删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = {"商品管理", "进货入库", "退货出库", "销售出库", "客户退货", "商品报损", "商品报溢"}, logical = Logical.OR)
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (goodsService.findByTypeId(id).size() == 0) {
            GoodsType goodsType = goodsTypeService.findById(id);
            if (goodsTypeService.findByParentId(goodsType.getpId()).size() == 1) {
                GoodsType parentGoodsType = goodsTypeService.findById(goodsType.getpId());
                parentGoodsType.setState(0);
                goodsTypeService.update(parentGoodsType);
            }
            logService.add(new Log(Log.DELETE_ACTION, "删除商品类别信息" + goodsType));
            goodsTypeService.delete(id);
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该类别下含有商品,不能删除!");
        }
        return resultMap;
    }

    /**
     * 根据父节点获取所有复选框权限菜单
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadTreeInfo")
    @RequiresPermissions(value = {"商品管理", "进货入库", "退货出库", "销售出库", "客户退货", "当前库存查询", "商品报损", "商品报溢", "商品采购统计", "商品销售统计"}, logical = Logical.OR)
    public String loadTreeInfo() {
        logService.add(new Log(Log.SEARCH_ACTION, "查询所有商品类别信息"));
        return getAllByParentId(-1).toString();
    }

    /**
     * 根据父节点id和权限菜单id集合获取所有复选框菜单集合
     *
     * @param parentId
     * @return
     */
    private JsonArray getAllByParentId(Integer parentId) {
        JsonArray jsonArray = this.getByParentId(parentId);
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").getAsString())) {
                continue;
            } else {
                jsonObject.add("children", getAllByParentId(jsonObject.get("id").getAsInt()));
            }
        }
        return jsonArray;
    }

    /**
     * 根据父节点查询所有子节点
     *
     * @param parentId
     * @return
     */
    private JsonArray getByParentId(Integer parentId) {
        List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(parentId);
        JsonArray jsonArray = new JsonArray();
        for (GoodsType goodsType : goodsTypeList) {
            JsonObject jsonObject = new JsonObject();
            // 节点Id
            jsonObject.addProperty("id", goodsType.getId());
            // 节点名称
            jsonObject.addProperty("text", goodsType.getName());
            if (goodsType.getState() == 1) {
                // 根节点
                jsonObject.addProperty("state", "closed");
            } else {
                // 叶子节点
                jsonObject.addProperty("state", "open");
            }
            // 节点图标
            jsonObject.addProperty("iconCls", goodsType.getIcon());
            // 扩展属性
            JsonObject attributeObject = new JsonObject();
            // 节点状态
            attributeObject.addProperty("state", goodsType.getState());
            jsonObject.add("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
