package com.ledao.controller;

import com.ledao.entity.ArticleType;
import com.ledao.entity.GoodsType;
import com.ledao.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:10
 */
@Controller
public class IndexController implements CommandLineRunner, ServletContextListener {

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private ServletContext application = null;

    @Resource
    private CarouselService carouselService;

    @Resource
    private EquipmentTypeService equipmentTypeService;

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleTypeService articleTypeService;

    @Resource
    private UserService userService;

    @Resource
    private GoodsTypeService goodsTypeService;

    /**
     * 首页地址
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView();
        this.loadSomeData();
        mav.addObject("title", "首页");
        mav.addObject("mainPage", "page/indexFirst");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户注册地址
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "用户注册");
        mav.addObject("mainPage", "page/register");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "用户登录");
        mav.addObject("mainPage", "page/login");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户购物车
     *
     * @return
     */
    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "我的购物车");
        mav.addObject("mainPage", "page/goods/shoppingCart");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 跳转到联系我们
     *
     * @return
     */
    @RequestMapping("/contact")
    public ModelAndView contact() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "联系我们");
        mav.addObject("mainPage", "page/contact");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    public void loadSomeData() {
        Map<String,Object> map=new HashMap<>(16);
        //获取文章类别以及该类别下的文章集合
        List<ArticleType> articleTypeList1 = articleTypeService.list(map);
        for (ArticleType articleType : articleTypeList1) {
            articleType.setArticleList(articleService.findByTypeId(articleType.getId()));
        }
        application.setAttribute("articleTypeList1", articleTypeList1);
        //获取文章类型信息
        List<ArticleType> articleTypeList=articleTypeService.list(map);
        application.setAttribute("articleTypeList", articleTypeList);
        //获取第一个轮播图信息
        map.put("type", 1);
        application.setAttribute("firstCarouselList",carouselService.list(map));
        //获取第二个轮播图信息
        map.put("type", 2);
        application.setAttribute("secondCarouselList",carouselService.list(map));
        application.setAttribute("equipmentTypeList",equipmentTypeService.list(null));
        //获取医生信息
        map.put("type", 2);
        application.setAttribute("doctorList",userService.list(map));
        //获取商品分类
        List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(1);
        for (GoodsType goodsType : goodsTypeList) {
            goodsType.setSmallGoodsTypeList(goodsTypeService.findByParentId(goodsType.getId()));
        }
        application.setAttribute("goodsTypeList", goodsTypeList);
    }
}
