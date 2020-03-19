package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Assay;
import com.ledao.entity.Pet;
import com.ledao.service.AssayService;
import com.ledao.service.PetService;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台化验记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 19:21
 */
@Controller
@RequestMapping("/assay")
public class AssayController {

    @Resource
    private AssayService assayService;

    @Resource
    private PetService petService;

    /**
     * 我的化验记录
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myAssay/list/{id}")
    public ModelAndView myAssay(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerName", StringUtil.formatLike(currentCustomer.getContact()));
        List<Assay> assayList = assayService.list(map);
        for (Assay assay : assayList) {
            Pet pet = petService.findByName(assay.getPetName());
            assay.setPet(pet);
        }
        Long total = assayService.getCount(map);
        mav.addObject("assayList", assayList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/assay/myAssay/list", total, page, pageSize));
        mav.addObject("title", "我的化验记录");
        mav.addObject("mainPage", "page/assay/myAssay");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看化验记录详情
     *
     * @param assayId
     * @return
     */
    @RequestMapping("/assayDetails")
    public ModelAndView assayDetails(Integer assayId) {
        Assay assay = assayService.findById(assayId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("assay", assay);
        mav.addObject("title", "查看化验记录详情");
        mav.addObject("mainPage", "page/assay/assayDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
