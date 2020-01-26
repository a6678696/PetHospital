package com.ledao.run;

import com.ledao.service.CarouselService;
import com.ledao.service.EquipmentTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
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

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }

    /**
     * 加载数据到applicaton缓存中
     */
    public void loadData() {

        //获取第一个轮播图信息
        Map<String,Object> map=new HashMap<>(16);
        map.put("type", 1);
        application.setAttribute("firstCarouselList",carouselService.list(map));
        //获取第二个轮播图信息
        map.put("type", 2);
        application.setAttribute("secondCarouselList",carouselService.list(map));
        application.setAttribute("equipmentTypeList",equipmentTypeService.list(null));

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
