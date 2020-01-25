package com.ledao.entity;

import lombok.Data;

/**
 * 轮播图实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:09
 */
@Data
public class Carousel {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 轮播图图片
     */
    private String imageName;
    /**
     * 轮播图顺序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 轮播图图片='" + imageName + '\'' +
                ", 轮播图顺序=" + sort +
                ", 备注=" + remarks +
                '}';
    }
}
