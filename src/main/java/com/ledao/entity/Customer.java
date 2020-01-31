package com.ledao.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 客户实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:01
 */
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 用户名
     */
    @NotEmpty(message = "请输入用户名!")
    private String userName;
    /**
     * 密码
     */
    @NotEmpty(message = "请输入密码!")
    @Size(min = 6,message = "密码长度要大于5!")
    private String password;
    /**
     * 确认密码
     */
    @NotEmpty(message = "请输入确认密码!")
    private String password2;
    /**
     * 用户头像
     */
    private String imageName;
    /**
     * 联系人
     */
    @NotEmpty(message = "请输入真实姓名!")
    private String contact;
    /**
     * 联系电话
     */
    @NotEmpty(message = "请输入联系电话!")
    private String number;
    /**
     * 联系地址
     */
    @NotEmpty(message = "请输入收货地址!")
    private String address;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "--{" +
                "id=" + id +
                ", 客户名称='" + name + '\'' +
                ", 联系人='" + contact + '\'' +
                ", 联系电话='" + number + '\'' +
                ", 联系地址='" + address + '\'' +
                '}';
    }
}
