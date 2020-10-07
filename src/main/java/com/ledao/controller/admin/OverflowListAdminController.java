package com.ledao.controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ledao.entity.OverflowList;
import com.ledao.entity.OverflowListGoods;
import com.ledao.entity.Goods;
import com.ledao.entity.Log;
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
 * 后台管理报溢单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:51
 */
@RestController
@RequestMapping("/admin/overflowList")
public class OverflowListAdminController {

    @Resource
    private OverflowListService overflowListService;

    @Resource
    private OverflowListGoodsService overflowListGoodsService;

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
     * 获取报溢单号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @RequiresPermissions(value = "商品报溢")
    public String genCode() throws Exception {
        StringBuffer code = new StringBuffer("BY");
        code.append(DateUtil.getCurrentDateStr());
        String overflowNumber = overflowListService.getTodayMaxOverflowNumber();
        if (overflowNumber != null) {
            code.append(StringUtil.formatCode(overflowNumber));
        } else {
            code.append("0001");
        }
        return code.toString();
    }

    /**
     * 添加报溢单 以及所有报溢单商品
     *
     * @param overflowList
     * @param goodsJson
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "商品报溢")
    public Map<String, Object> save(OverflowList overflowList, String goodsJson){
        Map<String, Object> resultMap = new HashMap<>(16);
        // 设置操作用户
        overflowList.setUser(userService.findByUserName((String) SecurityUtils.getSubject().getPrincipal()));
        Gson gson = new Gson();
        List<OverflowListGoods> overflowListGoodsList = gson.fromJson(goodsJson, new TypeToken<List<OverflowListGoods>>() {
        }.getType());
        overflowListService.add(overflowList);
        for (OverflowListGoods overflowListGoods : overflowListGoodsList) {
            // 设置类别
            overflowListGoods.setType(goodsTypeService.findById(overflowListGoods.getTypeId()));
            //设置报溢单
            overflowListGoods.setOverflowList(overflowListService.findByOverflowNumber(overflowList.getOverflowNumber()));
            overflowListGoodsService.add(overflowListGoods);

            //修改商品库存
            Goods goods = goodsService.findById(overflowListGoods.getGoodsId());
            //新的库存数量
            goods.setInventoryQuantity(goods.getInventoryQuantity() + overflowListGoods.getNum());
            //设置新的上次进价
            goods.setState(2);
            goodsService.update(goods);
        }
        logService.add(new Log(Log.ADD_ACTION, "添加报溢单"+overflowList));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据条件查询所有报溢单信息
     *
     * @param overflowList
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"报损报溢查询"}, logical = Logical.OR)
    public Map<String, Object> list(OverflowList overflowList) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("overflowNumber", StringUtil.formatLike(overflowList.getOverflowNumber()));
        map.put("bOverflowDate", overflowList.getbOverflowDate());
        map.put("eOverflowDate", overflowList.geteOverflowDate());
        List<OverflowList> overflowListList = overflowListService.list(map);
        resultMap.put("rows", overflowListList);
        logService.add(new Log(Log.SEARCH_ACTION, "报溢单查询"));
        return resultMap;
    }

    /**
     * 根据报溢单id查询所有报溢单商品
     *
     * @param overflowListId
     * @return
     */
    @RequestMapping("/listGoods")
    @RequiresPermissions(value = "报损报溢查询")
    public Map<String, Object> listGoods(Integer overflowListId) {
        if (overflowListId == null) {
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", overflowListGoodsService.listByOverflowListId(overflowListId));
        logService.add(new Log(Log.SEARCH_ACTION, "报溢单商品查询"));
        return resultMap;
    }
}
