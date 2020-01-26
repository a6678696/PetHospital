package com.ledao.entity;

import lombok.Data;

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
     * 文章类型 1.医院公告 2.医院新闻 3.宠物大全 4.用药常识
     */
    private Integer type;
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
                ", 文章类型(1.医院公告 2.医院新闻 3.宠物大全 4.用药常识)=" + type +
                '}';
    }
}
