package com.ledao.entity;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 文章实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 19:30
 */
public class Article {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 标题
     */
    @NotEmpty(message = "请输入您要搜索的文章标题!")
    private String title;
    /**
     * 发布日期
     */
    private Date releaseDate;
    /**
     * 阅读次数
     */
    private Integer click;
    /**
     * 文章类型
     */
    private Integer typeId;
    /**
     * 文章类型实体
     */
    private ArticleType articleType;
    /**
     * 文章内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 标题='" + title + '\'' +
                ", 发布日期=" + releaseDate +
                ", 文章类型=" + typeId +
                '}';
    }
}
