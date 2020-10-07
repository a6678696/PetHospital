package com.ledao.entity;

import javax.validation.constraints.NotEmpty;

/**
 * 医院用户实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:02
 */
public class User {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户名
     */
    @NotEmpty(message = "请输入用户名!")
    private String userName;

    /**
     * 密码
     */
    @NotEmpty(message = "请输入密码!")
    private String password;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 备注
     */
    private String remarks;

    /**
     *所拥有的角色
     */
    private String roles;
    /**
     * 类型 1.系统维护人员 2.医生 3.美容师 4.维修员
     */
    private Integer type;
    /**
     * 头像图片
     */
    private String imageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 用户名='" + userName + '\'' +
                ", 密码='" + password + '\'' +
                ", 真实姓名='" + trueName + '\'' +
                ", 备注='" + remarks + '\'' +
                '}';
    }
}