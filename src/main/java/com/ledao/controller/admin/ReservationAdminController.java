package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.service.PetService;
import com.ledao.service.ReservationService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理预约单Controller
 *
 * @author LeDao
 * @company
 * @create 2020-02-05 18:34
 */
@RestController
@RequestMapping("/admin/reservation")
public class ReservationAdminController {

    @Resource
    private ReservationService reservationService;

    @Resource
    private CustomerService customerService;

    @Resource
    private PetService petService;

    @Resource
    private LogService logService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 查看未处理的医生预约单
     *
     * @param reservation
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listNotHandleDoctor")
    @RequiresPermissions(value = "我的未预约单(医生)")
    public Map<String, Object> listNotHandleDoctor(Reservation reservation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows, HttpSession session) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 0);
        map.put("type", "预约医生");
        map.put("key", 1);
        map.put("bSaleDate", reservation.getbSaleDate());
        map.put("eSaleDate", reservation.geteSaleDate());
        User currentUser = (User) session.getAttribute("currentUser");
        map.put("userId", currentUser.getId());
        if (reservation.getCustomer() != null) {
            if (!StringUtil.isEmpty(reservation.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(reservation.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        if (reservation.getPet() != null) {
            if (!StringUtil.isEmpty(reservation.getPet().getName())) {
                Pet pet = petService.findByName(reservation.getPet().getName());
                if (pet != null) {
                    int petId = pet.getId();
                    map.put("petId", petId);
                } else {
                    map.put("petId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Reservation> reservationList = reservationService.list(map);
        resultMap.put("rows", reservationList);
        resultMap.put("total", reservationService.getCount(map));
        return resultMap;
    }

    /**
     * 查看未处理的美容师预约单
     *
     * @param reservation
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listNotHandleBeautician")
    @RequiresPermissions(value = "我的未预约单(美容师)")
    public Map<String, Object> listNotHandleBeautician(Reservation reservation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows,HttpSession session) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 0);
        map.put("type", "预约美容师");
        map.put("key", 1);
        map.put("bSaleDate", reservation.getbSaleDate());
        map.put("eSaleDate", reservation.geteSaleDate());
        User currentUser = (User) session.getAttribute("currentUser");
        map.put("userId", currentUser.getId());
        if (reservation.getCustomer() != null) {
            if (!StringUtil.isEmpty(reservation.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(reservation.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        if (reservation.getPet() != null) {
            if (!StringUtil.isEmpty(reservation.getPet().getName())) {
                Pet pet = petService.findByName(reservation.getPet().getName());
                if (pet != null) {
                    int petId = pet.getId();
                    map.put("petId", petId);
                } else {
                    map.put("petId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Reservation> reservationList = reservationService.list(map);
        resultMap.put("rows", reservationList);
        resultMap.put("total", reservationService.getCount(map));
        return resultMap;
    }

    /**
     * 处理客户预约单
     *
     * @param status
     * @param reservationId
     * @return
     */
    @RequestMapping("/dealReservation")
    @RequiresPermissions(value = {"我的未预约单(医生)", "我的未预约单(美容师)", "我的已预约单", "预约单管理"}, logical = Logical.OR)
    public Map<String, Object> dealReservation(Integer status, Integer reservationId, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Reservation reservation = reservationService.findById(reservationId);
        reservation.setStatus(status);
        if (status == 0) {
            reservation.setIsCancel(1);
        } else if (status == 1) {
            User user = (User) session.getAttribute("currentUser");
            if (user == null) {
                resultMap.put("errorInfo", "登录状态已过期,请重新登录!");
                return resultMap;
            }
            reservation.setUser(user);
        }
        reservationService.update(reservation);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 后台获取我的已预约单
     *
     * @param reservation
     * @param page
     * @param rows
     * @param session
     * @return
     */
    @RequestMapping("/listMyReservation")
    @RequiresPermissions(value = "我的已预约单")
    public Map<String, Object> listMyReservation(Reservation reservation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows, HttpSession session) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        User user = (User) session.getAttribute("currentUser");
        map.put("key", 1);
        map.put("userId", user.getId());
        map.put("status", 1);
        if (reservation.getCustomer() != null) {
            if (!StringUtil.isEmpty(reservation.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(reservation.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        if (reservation.getPet() != null) {
            if (!StringUtil.isEmpty(reservation.getPet().getName())) {
                Pet pet = petService.findByName(reservation.getPet().getName());
                if (pet != null) {
                    int petId = pet.getId();
                    map.put("petId", petId);
                } else {
                    map.put("petId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Reservation> reservationList = reservationService.list(map);
        resultMap.put("rows", reservationList);
        resultMap.put("total", reservationService.getCount(map));
        return resultMap;
    }

    /**
     * 后台获取我的已结束预约单
     *
     * @param reservation
     * @param page
     * @param rows
     * @param session
     * @return
     */
    @RequestMapping("/listMyFinishReservation")
    @RequiresPermissions(value = "我的已结束预约单")
    public Map<String, Object> listMyFinishReservation(Reservation reservation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows, HttpSession session) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        User user = (User) session.getAttribute("currentUser");
        map.put("key", 1);
        map.put("userId", user.getId());
        map.put("status", 3);
        if (reservation.getCustomer() != null) {
            if (!StringUtil.isEmpty(reservation.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(reservation.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        if (reservation.getPet() != null) {
            if (!StringUtil.isEmpty(reservation.getPet().getName())) {
                Pet pet = petService.findByName(reservation.getPet().getName());
                if (pet != null) {
                    int petId = pet.getId();
                    map.put("petId", petId);
                } else {
                    map.put("petId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Reservation> reservationList = reservationService.list(map);
        resultMap.put("rows", reservationList);
        resultMap.put("total", reservationService.getCount(map));
        return resultMap;
    }

    /**
     * 查看全部预约单
     *
     * @param reservation
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "预约单管理")
    public Map<String, Object> list(Reservation reservation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (reservation.getUser() != null) {
            if (reservation.getUser().getId()!=null) {
                User user = reservation.getUser();
                if (user != null) {
                    int userId = user.getId();
                    map.put("userId", userId);
                } else {
                    map.put("userId", -1);
                }
            }
        }
        if (reservation.getCustomer() != null) {
            if (reservation.getCustomer().getId()!=null) {
                Customer customer = reservation.getCustomer();
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        if (reservation.getPet() != null) {
            if (!StringUtil.isEmpty(reservation.getPet().getName())) {
                Pet pet = petService.findByName(reservation.getPet().getName());
                if (pet != null) {
                    int petId = pet.getId();
                    map.put("petId", petId);
                } else {
                    map.put("petId", -1);
                }
            }
        }
        map.put("type", reservation.getType());
        map.put("status", reservation.getStatus());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", reservationService.list(map));
        resultMap.put("total", reservationService.getCount(map));
        return resultMap;
    }

    /**
     * 删除客户未处理的预约单
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "预约单管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            Reservation reservation = reservationService.findById(id);
            if (reservation.getStatus() == 0) {
                logService.add(new Log(Log.DELETE_ACTION, "删除预约单" + reservation));
                reservationService.delete(id);
            } else {
                resultMap.put("errorInfo", "您要删除的预约单已处理,不能删除!");
                return resultMap;
            }
        }
        resultMap.put("success", true);
        return resultMap;
    }
}