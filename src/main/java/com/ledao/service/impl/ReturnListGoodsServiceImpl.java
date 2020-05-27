package com.ledao.service.impl;

import com.ledao.entity.ReturnListGoods;
import com.ledao.mapper.ReturnListGoodsMapper;
import com.ledao.service.ReturnListGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 退货单商品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 15:08
 */
@Service("returnListGoodsService")
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Resource
    private ReturnListGoodsMapper returnListGoodsMapper;

    @Override
    public List<ReturnListGoods> listByReturnListId(Integer returnListId) {
        return returnListGoodsMapper.listByReturnListId(returnListId);
    }

    @Override
    public Integer deleteByReturnListId(Integer returnListId) {
        return returnListGoodsMapper.deleteByReturnListId(returnListId);
    }

    @Override
    public List<ReturnListGoods> list(Map<String, Object> map) {
        return returnListGoodsMapper.list(map);
    }

    @Override
    public Integer add(ReturnListGoods returnListGoods) {
        return returnListGoodsMapper.add(returnListGoods);
    }

    @Override
    public Long getReturnCount(Integer goodsId) {
        return returnListGoodsMapper.getReturnCount(goodsId);
    }
}
