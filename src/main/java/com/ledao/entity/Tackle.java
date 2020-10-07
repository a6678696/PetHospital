package com.ledao.entity;

/**
 * 医院用品实体
 *
 * @author LeDao
 * @company
 * @create 2020-04-06 13:02
 */
public class Tackle {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态 0.在库中 1.已出库
     */
    private Integer status;
    /**
     * 使用设备的用户名称(用来检验使用的用户是否存在)
     */
    private String userName;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Tackle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }
}
