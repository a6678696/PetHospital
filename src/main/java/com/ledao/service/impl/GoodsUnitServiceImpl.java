package com.ledao.service.impl;

import com.ledao.entity.GoodsUnit;
import com.ledao.mapper.GoodsUnitMapper;
import com.ledao.service.GoodsUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品单位Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:59
 */
@Service("goodsUnitService")
public class GoodsUnitServiceImpl implements GoodsUnitService {

    @Resource
    private GoodsUnitMapper goodsUnitMapper;

    @Override
    public List<GoodsUnit> listAll() {
        return goodsUnitMapper.listAll();
    }

    @Override
    public Integer add(GoodsUnit goodsUnit) {
        return goodsUnitMapper.add(goodsUnit);
    }

    @Override
    public Integer update(GoodsUnit goodsUnit) {
        return goodsUnitMapper.update(goodsUnit);
    }

    @Override
    public Integer delete(Integer id) {
        return goodsUnitMapper.delete(id);
    }

    @Override
    public GoodsUnit findById(Integer id) {
        return goodsUnitMapper.findById(id);
    }
}
