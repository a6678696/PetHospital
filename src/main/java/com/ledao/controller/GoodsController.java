package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.entity.Goods;
import com.ledao.service.*;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * @author LeDao
 * @company
 * @create 2020-01-29 14:18
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private FavoriteService favoriteService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private ReturnListGoodsService returnListGoodsService;

    /**
     * 搜索商品
     *
     * @param searchGoods
     * @param bindingResult
     * @return
     */
    @RequestMapping("/search")
    public ModelAndView search(@Valid Goods searchGoods, BindingResult bindingResult,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title", "首页");
            mav.addObject("mainPage", "page/indexFirst");
            mav.addObject("mainPageKey", "#b");
        } else {
            Map<String, Object> map = new HashMap<>(16);
            map.put("name", StringUtil.formatLike(searchGoods.getName()));
            List<Goods> goodsList = goodsService.list(map);
            List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(1);
            for (GoodsType goodsType : goodsTypeList) {
                goodsType.setSmallGoodsTypeList(goodsTypeService.findByParentId(goodsType.getId()));
            }
            this.setGoodsFavorite(goodsList,session);
            mav.addObject("goodsList", goodsList);
            mav.addObject("goodsTypeList", goodsTypeList);
            mav.addObject("title", "关于(" + searchGoods.getName() + ")的商品");
            mav.addObject("mainPage", "page/goods/goodsResult");
            mav.addObject("mainPageKey", "#b");
            mav.addObject("searchGoods", searchGoods);
            mav.addObject("total", goodsList.size());
        }
        mav.setViewName("index");
        return mav;
    }

    /**
     * 分页分类查询商品信息
     *
     * @param page
     * @param typeId
     * @return
     */
    @RequestMapping("/list/{id}")
    public ModelAndView list(@PathVariable(value = "id", required = false) Integer page, @RequestParam(value = "typeId", required = false) Integer typeId,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        map.put("typeId", typeId);
        //每页商品数量
        int pageSize = 6;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        if (goodsTypeService.findById(typeId).getState() == 1) {
            //根据商品大类分类
            List<Goods> goodsList = goodsService.listByBigTypeId(map);
            Long total = goodsService.getCountByBigTypeId(map);
            this.setGoodsFavorite(goodsList,session);
            mav.addObject("goodsList", goodsList);
            mav.addObject("total", total);
            mav.addObject("pageCode", PageUtil.genPagination("/goods/list", total, page, pageSize, typeId));
        } else {
            //根据商品小类分类
            List<Goods> goodsList = goodsService.list(map);
            Long total = goodsService.getCount(map);
            this.setGoodsFavorite(goodsList,session);
            mav.addObject("goodsList", goodsList);
            mav.addObject("total", total);
            mav.addObject("pageCode", PageUtil.genPagination("/goods/list", total, page, pageSize, typeId));
        }
        //获取商品分类
        List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(1);
        for (GoodsType goodsType : goodsTypeList) {
            goodsType.setSmallGoodsTypeList(goodsTypeService.findByParentId(goodsType.getId()));
        }
        mav.addObject("bigTypeName", goodsTypeService.findById(goodsTypeService.findById(typeId).getpId()).getName());
        mav.addObject("bigTypeId", goodsTypeService.findById(goodsTypeService.findById(typeId).getpId()).getId());
        mav.addObject("typeName", goodsTypeService.findById(typeId).getName());
        mav.addObject("title", "商品列表(" + goodsTypeService.findById(typeId).getName() + ")");
        mav.addObject("goodsTypeList", goodsTypeList);
        mav.addObject("mainPage", "page/goods/goodsList");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 给商品设置是否已收藏标签(0否,1是)
     *
     * @param goodsList
     */
    private void setGoodsFavorite(List<Goods> goodsList,HttpSession session) {
        Map<String,Object> map=new HashMap<>(16);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Favorite> favoriteList = favoriteService.list(map);
        for (Favorite favorite : favoriteList) {
            for (Goods goods : goodsList) {
                if (goods.getId().equals(favorite.getGoods().getId())) {
                    goods.setIsFavorite(1);
                }
            }
        }
    }

    /**
     * 查看商品详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable(value = "id", required = false) Integer id, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Goods goods = goodsService.findById(id);
        List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(1);
        for (GoodsType goodsType : goodsTypeList) {
            goodsType.setSmallGoodsTypeList(goodsTypeService.findByParentId(goodsType.getId()));
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("typeId", goods.getType().getId());
        List<Goods> goodsList = goodsService.list(map);
        Collections.shuffle(goodsList);
        goodsList.remove(goods);
        this.saveCurrentBrowseGoods(goods, session);
        List<Goods> goodsList1 = new ArrayList<>();
        goodsList1.add(goods);
        this.setGoodsFavorite(goodsList1,session);
        mav.addObject("allSaleTotal", saleListGoodsService.getSaleCount(goods.getId()) - returnListGoodsService.getReturnCount(goods.getId()));
        mav.addObject("bigTypeName", goodsTypeService.findById(goodsTypeService.findById(goods.getType().getId()).getpId()).getName());
        mav.addObject("bigTypeId", goodsTypeService.findById(goodsTypeService.findById(goods.getType().getId()).getpId()).getId());
        mav.addObject("goods", goods);
        mav.addObject("recommendGoodsList", goodsList);
        mav.addObject("goodsTypeList", goodsTypeList);
        mav.addObject("title", goods.getName());
        mav.addObject("mainPage", "page/goods/goodsView");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 保存最近浏览的商品
     *
     * @param goods
     * @param session
     */
    private void saveCurrentBrowseGoods(Goods goods, HttpSession session) {
        List<Goods> currentBrowseGoods = (List<Goods>) session.getAttribute("currentBrowse");
        if (currentBrowseGoods == null) {
            currentBrowseGoods = new LinkedList<>();
        }

        boolean flag = true;
        for (Goods currentBrowseGood : currentBrowseGoods) {
            if (currentBrowseGood.getId().equals(goods.getId())) {
                flag = false;
                break;
            }
        }

        if (flag) {
            currentBrowseGoods.add(0, goods);
        }

        int maxSize = 3;
        if (currentBrowseGoods.size() > maxSize) {
            currentBrowseGoods.remove(3);
        }

        session.setAttribute("currentBrowse", currentBrowseGoods);
    }

    /**
     * 添加商品到我的收藏
     *
     * @param goodsId
     * @param session
     */
    @RequestMapping("/addFavorite")
    public String addFavorite(Integer goodsId, String str, HttpSession session) {
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        Favorite favorite = new Favorite();
        favorite.setCustomer(currentCustomer);
        favorite.setGoods(goodsService.findById(goodsId));
        favoriteService.add(favorite);
        String url = "redirect:/goods/list/1?typeId=" + goodsService.findById(goodsId).getType().getId().toString() + "::" + str;
        return url;
    }

    /**
     * 从我的收藏中删除商品
     *
     * @param goodsId
     * @param session
     */
    @RequestMapping("/deleteFavorite")
    public String deleteFavorite(Integer goodsId, String str, HttpSession session) {
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        favoriteService.delete(currentCustomer.getId(), goodsId);
        String url = "redirect:/goods/list/1?typeId=" + goodsService.findById(goodsId).getType().getId().toString() + "::" + str;
        return url;
    }

    /**
     * 我的收藏
     *
     * @return
     */
    @RequestMapping("/myFavorite/list/{id}")
    public ModelAndView myFavorite(@PathVariable(value = "id",required = false)Integer page,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String,Object> map=new HashMap<>(16);
        int pageSize = 6;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        map.put("customer", session.getAttribute("currentCustomer"));
        Long total = favoriteService.getCount(map);
        List<Favorite> favoriteList = favoriteService.list(map);
        List<Goods> goodsList = new ArrayList<>();
        for (Favorite favorite : favoriteList) {
            goodsList.add(favorite.getGoods());
        }
        this.setGoodsFavorite(goodsList,session);
        mav.addObject("favoriteList", favoriteList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/goods/myFavorite/list", total, page, pageSize));
        mav.addObject("title", "我的收藏");
        mav.addObject("mainPage", "page/goods/myFavorite");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
