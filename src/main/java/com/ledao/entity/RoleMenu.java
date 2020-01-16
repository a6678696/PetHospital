package com.ledao.entity;

import lombok.Data;

/**
 * 角色菜单关联实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:46
 */
@Data
public class RoleMenu {
    /**
     * 编号
     */
    private Integer id;
    /**
     *角色
     */
    private Role role;
    /**
     *菜单
     */
    private Menu menu;
}
