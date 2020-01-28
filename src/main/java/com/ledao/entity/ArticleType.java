package com.ledao.entity;

import lombok.Data;

/**
 * 文章类型实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 15:38
 */
@Data
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

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 名称='" + name + '\'' +
                ", 备注='" + remarks + '\'' +
                '}';
    }
}
