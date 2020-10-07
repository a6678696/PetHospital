package com.ledao.run;

import com.ledao.entity.ArticleType;
import com.ledao.entity.GoodsType;
import com.ledao.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页数据预缓存
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 19:41
 */
@Component
public class StartupRunner implements CommandLineRunner, ServletContextListener {

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

    @Override
    public void run(String... args) throws Exception {

    }

    /**
     * 加载数据到application缓存中
     */
    public void loadData() {

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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
