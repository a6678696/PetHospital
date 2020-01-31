package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Goods;
import com.ledao.entity.ShoppingCart;
import com.ledao.entity.ShoppingCartItem;
import com.ledao.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户购物操作Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-01-31 13:44
 */
@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/buy")
    public String buy(HttpSession session, Integer goodsId) {
        checkShoppingCart(session, goodsId);
        return "redirect:/shoppingCart";
    }

    /**
     * 往购物车中添加商品
     *
     * @param session
     * @param goodsId
     * @return
     */
    @ResponseBody
    @RequestMapping("/addShoppingCartItem")
    public Map<String, Object> addShoppingCartItem(HttpSession session, Integer goodsId) {
        checkShoppingCart(session, goodsId);
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除购物车中的商品
     *
     * @param session
     * @param goodsId
     * @return
     */
    @RequestMapping("/removeShoppingCartItem")
    public String removeShoppingCartItem(HttpSession session, Integer goodsId) {
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        List<ShoppingCartItem> shoppingCartItemList = shoppingCart.getShoppingCartItems();
        for (int i = 0; i < shoppingCartItemList.size(); i++) {
            if (goodsId.equals(shoppingCartItemList.get(i).getGoods().getId())) {
                shoppingCartItemList.remove(i);
                break;
            }
        }
        shoppingCart.setShoppingCartItems(shoppingCartItemList);
        session.setAttribute("shoppingCart", shoppingCart);
        return "redirect:/shoppingCart";
    }

    /**
     * 添加商品到购物车
     *
     * @param session
     * @param goodsId
     */
    private void checkShoppingCart(HttpSession session, Integer goodsId) {
        Goods goods = goodsService.findById(goodsId);
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        //如果购物车不存在
        if (shoppingCart == null) {
            //创建新的购物车
            shoppingCart = new ShoppingCart();
            Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
            //将当前客户的id传给购物车
            shoppingCart.setCustomerId(currentCustomer.getId());
        }
        List<ShoppingCartItem> shoppingCartItemList = shoppingCart.getShoppingCartItems();
        boolean flag = true;
        //当购物车中已经存在要加入购物车的商品,就让该商品的数量+1
        for (ShoppingCartItem shoppingCartItem : shoppingCartItemList) {
            if (shoppingCartItem.getGoods().getId().equals(goods.getId())) {
                shoppingCartItem.setCount(shoppingCartItem.getCount() + 1);
                flag = false;
                break;
            }
        }
        //在购物车内加入一个不存在的商品
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        if (flag) {
            shoppingCartItem.setGoods(goods);
            shoppingCartItem.setCount(1);
            shoppingCartItemList.add(shoppingCartItem);
        }
        //将购物车放入session中
        session.setAttribute("shoppingCart", shoppingCart);
    }

}
