package com.ledao.controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ledao.entity.Goods;
import com.ledao.entity.Log;
import com.ledao.entity.DamageList;
import com.ledao.entity.DamageListGoods;
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
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理报损单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/damageList")
public class DamageListAdminController {

    @Resource
    private DamageListService damageListService;

    @Resource
    private DamageListGoodsService damageListGoodsService;

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
     * 获取报损单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "商品报损")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("BX");
        code.append(DateUtil.getCurrentDateStr());
        String damageNumber = damageListService.getTodayMaxDamageNumber();
        if (damageNumber != null) {
            code.append(StringUtil.formatCode(damageNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加报损单 以及所有报损单商品
     *
     * @param damageList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品报损")
    public Map<String, Object> save(DamageList damageList, String goodsJson){
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        damageList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<DamageListGoods> damageListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<DamageListGoods>>() {
        }.getType());
        damageListService.add(damageList);
        for (DamageListGoods damageListGoods : damageListGoodsList) {
            // 设置类别
            damageListGoods.setType(goodsTypeService.findById(damageListGoods.getTypeId()));
            //设置报损单
            damageListGoods.setDamageList(damageListService.findByDamageNumber(damageList.getDamageNumber()));
            damageListGoodsService.add(damageListGoods);

            //修改商品库存 成本均价 以及上次进价
            Goods goods = goodsService.findById(damageListGoods.getGoodsId());
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() - damageListGoods.getNum());
            //设置新的上次进价
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加报损单"+damageList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有报损单信息
     *
     * @param damageList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"报损报溢查询"}, logical = Logical.OR)
    public Map<String, Object> list(DamageList damageList) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("damageNumber", StringUtil.formatLike(damageList.getDamageNumber()));
        map.put("bDamageDate", damageList.getbDamageDate());
        map.put("eDamageDate", damageList.geteDamageDate());
        List<DamageList> damageListList = damageListService.list(map);
        resultMap.put("rows", damageListList);
        logService.add(new Log(Log.SEARCH_ACTION, "报损单查询"));
        return resultMap;
    }

    /**
     * 根据报损单id查询所有报损单商品
     *
     * @param damageListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String, Object> listGoods(Integer damageListId) {
        if (damageListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", damageListGoodsService.listByDamageListId(damageListId));
        logService.add(new Log(Log.SEARCH_ACTION, "报损单商品查询"));
        return resultMap;
    }
}
