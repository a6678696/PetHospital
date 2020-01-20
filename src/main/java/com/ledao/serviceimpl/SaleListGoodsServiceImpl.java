package com.ledao.serviceimpl;

import com.ledao.entity.SaleListGoods;
import com.ledao.mapper.SaleListGoodsMapper;
import com.ledao.service.SaleListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<SaleListGoods> listBySaleListId(Integer saleListId) {
        return saleListGoodsMapper.listBySaleListId(saleListId);
    }

    @Override
    public Integer deleteBySaleListId(Integer saleListId) {
        return saleListGoodsMapper.deleteBySaleListId(saleListId);
    }

    @Override
    public Long getTotalByGoodsId(Integer goodsId) {
        return saleListGoodsMapper.getTotalByGoodsId(goodsId);
    }

    @Override
    public List<SaleListGoods> list(Map<String, Object> map) {
        return saleListGoodsMapper.list(map);
    }
}
