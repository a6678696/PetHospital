package com.ledao.controller.admin;

import com.ledao.entity.Article;
import com.ledao.entity.Carousel;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.run.StartupRunner;
import com.ledao.service.CarouselService;
import com.ledao.service.LogService;
import com.ledao.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台管理轮播图Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 15:01
 */
@RestController
@RequestMapping("/admin/carousel")
public class CarouselAdminController {

    @Value("${carouselImageFilePath}")
    private String carouselImageFilePath;

    @Resource
    private CarouselService carouselService;

    @Resource
    private LogService logService;

    @Resource
    private StartupRunner startupRunner;

    /**
     * 分页查询轮播图信息
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "轮播图管理")
    public Map<String, Object> list(Carousel carousel,@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("type", carousel.getType());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", carouselService.list(map));
        resultMap.put("total", carouselService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询轮播图信息"));
        return resultMap;
    }

    /**
     * 添加或修改轮播图信息
     *
     * @param carousel
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "轮播图管理")
    public Map<String, Object> save(Carousel carousel, @RequestParam("carouselImage") MultipartFile file) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (!file.isEmpty()) {
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(carouselImageFilePath + newFileName));
            if (carousel.getId() != null) {
                FileUtils.deleteQuietly(new File(carouselImageFilePath + carouselService.findById(carousel.getId()).getImageName()));
            }
            carousel.setImageName(newFileName);
        }
        int key;
        if (carousel.getId() == null) {
            key = carouselService.add(carousel);
            logService.add(new Log(Log.ADD_ACTION, "添加轮播图信息" + carousel));
        } else {
            key = carouselService.update(carousel);
            logService.add(new Log(Log.UPDATE_ACTION, "修改轮播图信息" + carousel));
        }
        if (key > 0) {
            resultMap.put("success", true);
            startupRunner.loadData();
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除轮播图信息
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "轮播图管理")
    public Map<String, Object> delete(String ids){
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除轮播图信息" + carouselService.findById(id)));
            if (carouselService.findById(id).getImageName() != null) {
                FileUtils.deleteQuietly(new File(carouselImageFilePath + carouselService.findById(carouselService.findById(id).getId()).getImageName()));
            }
            carouselService.delete(id);
        }
        startupRunner.loadData();
        resultMap.put("success", true);
        return resultMap;
    }
}
