package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 设备使用记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 14:47
 */
@Data
public class UseEquipmentLog {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 开始使用时间
     */
    private Date beginDate;
    /**
     * 结束使用的时间
     */
    private Date endDate;
    /**
     * 使用的用户
     */
    private User user;
    /**
     * 使用的用户id
     */
    private Integer userId;
    /**
     * 使用的设备
     */
    private Equipment equipment;
    /**
     * 使用的设备id
     */
    private Integer equipmentId;
    /**
     * 使用设备的用户
     */
    private String userName;
    /**
     * 标签,用来插入结束日期
     */
    private Integer key;
}
