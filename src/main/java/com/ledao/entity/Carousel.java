package com.ledao.entity;

/**
 * 轮播图实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:09
 */
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
    /**
     * 轮播图类型 1.代表首页第一个轮播图 2.代表第二个轮播图
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
