package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Pet;
import com.ledao.entity.Reservation;
import com.ledao.service.PetService;
import com.ledao.service.ReservationService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户预约单Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 21:07
 */
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Resource
    private ReservationService reservationService;

    @Resource
    private PetService petService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 添加或修改预约单
     *
     * @param reservation
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(Reservation reservation,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (reservation.getId() == null) {
            reservation.setCustomer((Customer) session.getAttribute("currentCustomer"));
            reservation.setPet(petService.findById(reservation.getPetId()));
            reservationService.add(reservation);
        } else {
            reservationService.update(reservation);
        }
        mav.setViewName("index");
        return mav;
    }

    /**
     * 预约医生
     *
     * @return
     */
    @RequestMapping("/addDoctorReservation")
    public ModelAndView addDoctorReservation(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String,Object> map=new HashMap<>(16);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Pet> petList = petService.list(map);
        mav.addObject("petList", petList);
        mav.addObject("title", "预约医生");
        mav.addObject("mainPage", "page/reservation/addDoctorReservation");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 预约美容师
     *
     * @return
     */
    @RequestMapping("/addBeauticianReservation")
    public ModelAndView addBeauticianReservation() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "预约美容师");
        mav.addObject("mainPage", "page/reservation/addBeauticianReservation");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
