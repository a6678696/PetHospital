package com.ledao.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 文章实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 19:30
 */
@Data
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
