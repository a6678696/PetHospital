package com.ledao.entity;

import lombok.Data;

/**
 * 角色实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:36
 */
@Data
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
}
