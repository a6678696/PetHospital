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
}