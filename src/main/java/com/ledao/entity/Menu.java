package com.ledao.entity;

/**
 * 菜单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:42
 */
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", state=" + state +
                ", icon='" + icon + '\'' +
                ", pId=" + pId +
                '}';
    }
}
