package com.ledao.service.impl;

import com.ledao.entity.Favorite;
import com.ledao.mapper.FavoriteMapper;
import com.ledao.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 我的收藏Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 12:47
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteMapper favoriteMapper;

    @Override
    public List<Favorite> list(Map<String, Object> map) {
        return favoriteMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return favoriteMapper.getCount(map);
    }

    @Override
    public Integer add(Favorite favorite) {
        return favoriteMapper.add(favorite);
    }

    @Override
    public Integer delete(Integer customerId, Integer goodsId) {
        return favoriteMapper.delete(customerId, goodsId);
    }
}
