package com.ledao.service.impl;

import com.ledao.entity.Goods;
import com.ledao.mapper.GoodsMapper;
import com.ledao.service.GoodsService;
import org.springframework.stereotype.Service;

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
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findByTypeId(Integer typeId) {
        return goodsMapper.findByTypeId(typeId);
    }

    @Override
    public List<Goods> listByBigTypeId(Map<String, Object> map) {
        return goodsMapper.listByBigTypeId(map);
    }

    @Override
    public Long getCountByBigTypeId(Map<String, Object> map) {
        return goodsMapper.getCountByBigTypeId(map);
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
    public List<Goods> listInventory(Map<String, Object> map) {
        return goodsMapper.listInventory(map);
    }

    @Override
    public Long getCountInventory(Map<String, Object> map) {
        return goodsMapper.getCountInventory(map);
    }

    @Override
    public List<Goods> listNoInventoryQuantityByCodeOrName(Map<String, Object> map) {
        return goodsMapper.listNoInventoryQuantityByCodeOrName(map);
    }

    @Override
    public Long getCountNoInventoryQuantityByCodeOrName(Map<String, Object> map) {
        return goodsMapper.getCountNoInventoryQuantityByCodeOrName(map);
    }

    @Override
    public List<Goods> listHasInventoryQuantityByCodeOrName(Map<String, Object> map) {
        return goodsMapper.listHasInventoryQuantityByCodeOrName(map);
    }

    @Override
    public Long getCountHasInventoryQuantityByCodeOrName(Map<String, Object> map) {
        return goodsMapper.getCountHasInventoryQuantityByCodeOrName(map);
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

    @Override
    public void goodsNewToOld() {
        List<Goods> oldGoodsList = goodsMapper.findOldGoods();
        for (Goods goods : oldGoodsList) {
            goods.setIsNew(0);
            goodsMapper.update(goods);
        }
    }
}
