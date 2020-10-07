package com.ledao.entity;

import java.util.List;

/**
 * 文章类型实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 15:38
 */
public class ArticleType {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 每个类别下的文章集合
     */
    private List<Article> articleList = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 名称='" + name + '\'' +
                ", 备注='" + remarks + '\'' +
                '}';
    }
}
