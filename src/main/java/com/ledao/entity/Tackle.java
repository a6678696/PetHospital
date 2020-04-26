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
     * 类型 1.一次性用品 2.非一次性用品
     */
    private Integer type;
    /**
     * 状态 1.在库中 2.已出库
     */
    private Integer status;
}
