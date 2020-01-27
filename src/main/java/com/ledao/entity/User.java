package com.ledao.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.beans.Transient;

/**
 * 医院用户实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:02
 */
@Data
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