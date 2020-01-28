package com.ledao.mapper;

import com.ledao.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * 文章Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 19:35
 */
public interface ArticleMapper {

    /**
     * 条件查询文章
     *
     * @param map
     * @return
     */
    List<Article> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    Integer add(Article article);

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    Integer update(Article article);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    Article findById(Integer id);

    /**
     * 根据文章类型查询文章
     *
     * @param typeId
     * @return
     */
    List<Article> findByTypeId(Integer typeId);

    /**
     * 获取上一篇文章
     *
     * @param id
     * @return
     */
    Article getLast(Integer id);

    /**
     * 获取下一篇文章
     *
     * @param id
     * @return
     */
    Article getNext(Integer id);
}
