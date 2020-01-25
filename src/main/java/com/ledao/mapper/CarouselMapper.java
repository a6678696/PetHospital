package com.ledao.mapper;

import com.ledao.entity.Carousel;

import java.util.List;
import java.util.Map;

/**
 * 轮播图Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:14
 */
public interface CarouselMapper {

    /**
     * 分页条件查询轮播图信息
     *
     * @param map
     * @return
     */
    List<Carousel> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加轮播图信息
     *
     * @param carousel
     * @return
     */
    Integer add(Carousel carousel);

    /**
     * 修改轮播图信息
     *
     * @param carousel
     * @return
     */
    Integer update(Carousel carousel);

    /**
     * 删除轮播图信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    Carousel findById(Integer id);
}
