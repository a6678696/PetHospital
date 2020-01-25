package com.ledao.service.impl;

import com.ledao.entity.OverflowListGoods;
import com.ledao.mapper.OverflowListGoodsMapper;
import com.ledao.service.OverflowListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品报溢单商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:22
 */
@Service("overflowListGoodsService")
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService {

    @Resource
    private OverflowListGoodsMapper overflowListGoodsMapper;

    @Override
    public List<OverflowListGoods> listByOverflowListId(Integer overflowListId) {
        return overflowListGoodsMapper.listByOverflowListId(overflowListId);
    }

    @Override
    public Integer deleteByOverflowListId(Integer overflowListId) {
        return overflowListGoodsMapper.deleteByOverflowListId(overflowListId);
    }

    @Override
    public Integer add(OverflowListGoods overflowListGoods) {
        return overflowListGoodsMapper.add(overflowListGoods);
    }
}
