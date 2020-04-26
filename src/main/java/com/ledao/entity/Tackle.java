package com.ledao.entity;

import lombok.Data;

/**
 * 医院用品实体
 *
 * @author LeDao
 * @company
 * @create 2020-04-06 13:02
 */
@Data
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
     * 使用设备的用户名称
     */
    private String userName;
}
