package com.ledao.serviceimpl;

import com.ledao.entity.Goods;
import com.ledao.mapper.GoodsMapper;
import com.ledao.service.GoodsService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 22:06
 */
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findByTypeId(Integer typeId) {
        return goodsMapper.findByTypeId(typeId);
    }

    @Override
    public String getMaxGoodsCode() {
        return goodsMapper.getMaxGoodsCode();
    }

    @Override
    public List<Goods> listAlarm() {
        return goodsMapper.listAlarm();
    }

    @Override
    public List<Goods> list(Map<String, Object> map) {
        return goodsMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return goodsMapper.getCount(map);
    }

    @Override
    public List<Goods> listNoInventoryQuantityByCodeOrName(String codeOrName) {
        return goodsMapper.listNoInventoryQuantityByCodeOrName(codeOrName);
    }

    @Override
    public Long getCountNoInventoryQuantityByCodeOrName(String codeOrName) {
        return goodsMapper.getCountNoInventoryQuantityByCodeOrName(codeOrName);
    }

    @Override
    public List<Goods> listHasInventoryQuantityByCodeOrName(String codeOrName) {
        return goodsMapper.listHasInventoryQuantityByCodeOrName(codeOrName);
    }

    @Override
    public Long getCountHasInventoryQuantityByCodeOrName(String codeOrName) {
        return goodsMapper.getCountHasInventoryQuantityByCodeOrName(codeOrName);
    }

    @Override
    public Integer delete(Integer id) {
        return goodsMapper.delete(id);
    }

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.findById(id);
    }

    @Override
    public Integer add(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }
}
