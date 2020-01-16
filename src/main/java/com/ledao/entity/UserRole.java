package com.ledao.entity;

import lombok.Data;

/**
 * 用户角色关联实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:45
 */
@Data
public class UserRole {
    /**
     * 编号
     */
    private Integer id;
    /**
     *用户
     */
    private User user;
    /**
     *角色
     */
    private Role role;
}
