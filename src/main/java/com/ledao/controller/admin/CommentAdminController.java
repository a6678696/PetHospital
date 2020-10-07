package com.ledao.controller.admin;

import com.ledao.entity.Comment;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.entity.SaleListGoods;
import com.ledao.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**后台管理客户评价Controller层
 * @author LeDao
 * @company
 * @create 2020-05-29 11:10
 */
@RestController
@RequestMapping("/admin/comment")
public class CommentAdminController {

    @Resource
    private CommentService commentService;

    @Resource
    private LogService logService;

    @Resource
    private CustomerService customerService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    @RequiresPermissions(value = "客户评价管理")
    public Map<String, Object> list(Comment comment, @RequestParam(value = "page",required = false)Integer page,@RequestParam(value = "rows",required = false)Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String,Object> resultMap=new HashMap<>(16);
        Map<String,Object> map=new HashMap<>(16);
        map.put("customerId", comment.getCustomerId());
        map.put("bSaleDate", comment.getbSaleDate());
        map.put("eSaleDate", comment.geteSaleDate());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Comment> commentList = commentService.list(map);
        for (Comment comment1 : commentList) {
            comment1.setCustomer(customerService.findById(comment1.getCustomerId()));
            comment1.setGoods(goodsService.findById(comment1.getGoodsId()));
            comment1.setSaleListGoods(saleListGoodsService.findById(comment1.getSaleListGoodsId()));
            comment1.setSaleList(comment1.getSaleListGoods().getSaleList());
        }
        Long total = commentService.getCount(map);
        resultMap.put("rows", commentList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询客户评价"));
        return resultMap;
    }
}
