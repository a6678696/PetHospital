package com.ledao.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类别实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:13
 */
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public List<GoodsType> getSmallGoodsTypeList() {
        return smallGoodsTypeList;
    }

    public void setSmallGoodsTypeList(List<GoodsType> smallGoodsTypeList) {
        this.smallGoodsTypeList = smallGoodsTypeList;
    }

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 类别名称='" + name + '\'' +
                ", 父菜单Id=" + pId +
                '}';
    }
}
