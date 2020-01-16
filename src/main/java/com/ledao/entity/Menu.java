package com.ledao.entity;

import lombok.Data;

/**
 * 菜单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:42
 */
@Data
public class Menu {

    /**
     * 编号
     */
    private Integer id;
    /**
     *菜单名称
     */
    private String name;
    /**
     *菜单地址
     */
    private String url;
    /**
     *菜单节点类型 1 根节点 0 叶子节点
     */
    private Integer state;
    /**
     * 图标
     */
    private String icon;
    /**
     *父菜单Id
     */
    private Integer pId;
}
