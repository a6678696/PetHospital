package com.ledao.controller;

import com.ledao.entity.Vaccine;
import com.ledao.entity.Customer;
import com.ledao.entity.Pet;
import com.ledao.service.VaccineService;
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
 * 前台疫苗注射记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 19:21
 */
@Controller
@RequestMapping("/vaccine")
public class VaccineController {

    @Resource
    private VaccineService vaccineService;

    @Resource
    private PetService petService;

    /**
     * 我的疫苗注射记录
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myVaccine/list/{id}")
    public ModelAndView myVaccine(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerName", StringUtil.formatLike(currentCustomer.getContact()));
        List<Vaccine> vaccineList = vaccineService.list(map);
        for (Vaccine vaccine : vaccineList) {
            Pet pet = petService.findByName(vaccine.getPetName());
            vaccine.setPet(pet);
        }
        Long total = vaccineService.getCount(map);
        mav.addObject("vaccineList", vaccineList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/vaccine/myVaccine/list", total, page, pageSize));
        mav.addObject("title", "我的疫苗注射记录");
        mav.addObject("mainPage", "page/vaccine/myVaccine");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看疫苗注射记录详情
     *
     * @param vaccineId
     * @return
     */
    @RequestMapping("/vaccineDetails")
    public ModelAndView vaccineDetails(Integer vaccineId) {
        Vaccine vaccine = vaccineService.findById(vaccineId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("vaccine", vaccine);
        mav.addObject("title", "查看疫苗注射记录详情");
        mav.addObject("mainPage", "page/vaccine/vaccineDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
