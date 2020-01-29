package com.ledao.entity;

import lombok.Data;

import java.util.List;

/**
 * 商品类别实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:13
 */
@Data
public class GoodsType {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 类别节点类型 1 根节点 0 叶子节点
     */
    private Integer state;
    /**
     * 图标
     */
    private String icon;
    /**
     * 父菜单Id
     */
    private Integer pId;
    /**
     * 商品大类下的商品小类
     */
    private List<GoodsType> smallGoodsTypeList = null;

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 类别名称='" + name + '\'' +
                ", 父菜单Id=" + pId +
                '}';
    }
}
