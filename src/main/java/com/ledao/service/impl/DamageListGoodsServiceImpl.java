package com.ledao.service.impl;

import com.ledao.entity.DamageListGoods;
import com.ledao.mapper.DamageListGoodsMapper;
import com.ledao.service.DamageListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品报损单商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:44
 */
@Service("damageListGoodsService")
public class DamageListGoodsServiceImpl implements DamageListGoodsService {

    @Resource
    private DamageListGoodsMapper damageListGoodsMapper;

    @Override
    public List<DamageListGoods> listByDamageListId(Integer damageListId) {
        return damageListGoodsMapper.listByDamageListId(damageListId);
    }

    @Override
    public Integer deleteByDamageListId(Integer damageListId) {
        return damageListGoodsMapper.deleteByDamageListId(damageListId);
    }

    @Override
    public Integer add(DamageListGoods damageListGoods) {
        return damageListGoodsMapper.add(damageListGoods);
    }
}
