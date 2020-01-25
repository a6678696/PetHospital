package com.ledao.service.impl;

import com.ledao.entity.PurchaseListGoods;
import com.ledao.mapper.PurchaseListGoodsMapper;
import com.ledao.service.PurchaseListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 进货单商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 14:40
 */
@Service("purchaseListGoodsService")
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Resource
    private PurchaseListGoodsMapper purchaseListGoodsMapper;

    @Override
    public List<PurchaseListGoods> listByPurchaseListId(Integer purchaseListId) {
        return purchaseListGoodsMapper.listByPurchaseListId(purchaseListId);
    }

    @Override
    public Integer deleteByPurchaseListId(Integer purchaseListId) {
        return purchaseListGoodsMapper.deleteByPurchaseListId(purchaseListId);
    }

    @Override
    public List<PurchaseListGoods> list(Map<String, Object> map) {
        return purchaseListGoodsMapper.list(map);
    }

    @Override
    public Integer add(PurchaseListGoods purchaseListGoods) {
        return purchaseListGoodsMapper.add(purchaseListGoods);
    }
}
