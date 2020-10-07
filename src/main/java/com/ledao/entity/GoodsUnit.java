package com.ledao.entity;

/**
 * 商品单位实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:14
 */
public class GoodsUnit {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品单位名称
     */
    private String name;

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

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 商品单位名称='" + name + '\'' +
                '}';
    }
}
