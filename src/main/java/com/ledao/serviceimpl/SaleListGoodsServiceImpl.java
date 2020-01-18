package com.ledao.serviceimpl;

import com.ledao.mapper.SaleListGoodsMapper;
import com.ledao.service.SaleListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 销售单商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 16:44
 */
@Service("saleListGoodsService")
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Resource
    private SaleListGoodsMapper saleListGoodsMapper;
}
