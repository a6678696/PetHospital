package com.ledao.service;

import com.ledao.entity.Favorite;

import java.util.List;
import java.util.Map;

/**
 * 我的收藏Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 12:46
 */
public interface FavoriteService {

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<Favorite> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加商品到我的收藏
     *
     * @param favorite
     * @return
     */
    Integer add(Favorite favorite);

    /**
     * 删除实体
     *
     * @param customerId
     * @param goodsId
     * @return
     */
    Integer delete(Integer customerId, Integer goodsId);
}
