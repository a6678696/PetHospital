package com.ledao.service;

import com.ledao.entity.ArticleType;

import java.util.List;
import java.util.Map;

/**
 * 文章类型Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 15:46
 */
public interface ArticleTypeService {

    /**
     * 分页分条件查询文章类型
     *
     * @param map
     * @return
     */
    List<ArticleType> list(Map<String, Object> map);

    /**
     * 获取位置记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加文章类型
     *
     * @param articleType
     * @return
     */
    Integer add(ArticleType articleType);

    /**
     * 修改文章类型
     *
     * @param articleType
     * @return
     */
    Integer update(ArticleType articleType);

    /**
     * 删除文章类型
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询文章类型
     *
     * @param id
     * @return
     */
    ArticleType findById(Integer id);

    /**
     * 根据名称查询文章类型
     *
     * @param name
     * @return
     */
    List<ArticleType> findByName(String name);
}
