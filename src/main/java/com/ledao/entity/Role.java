package com.ledao.entity;

/**
 * 角色实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:36
 */
public class Role {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     *备注
     */
    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
