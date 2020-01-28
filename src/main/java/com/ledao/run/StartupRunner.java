package com.ledao.run;

import com.ledao.entity.ArticleType;
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

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }

    /**
     * 加载数据到applicaton缓存中
     */
    public void loadData() {

        Map<String,Object> map=new HashMap<>(16);
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
        //获取医院公告信息
        map.put("typeId", 1);
        map.put("start", 0);
        map.put("size", 5);
        application.setAttribute("announcementArticleList",articleService.list(map));
        //获取医院新闻信息
        map.put("typeId", 2);
        application.setAttribute("newsArticleList", articleService.list(map));
        //获取宠物大全信息
        map.put("typeId", 3);
        application.setAttribute("petArticleList", articleService.list(map));
        //获取用药常识信息
        map.put("typeId", 4);
        application.setAttribute("drugArticleList", articleService.list(map));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
