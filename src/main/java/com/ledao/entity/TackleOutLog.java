package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 医院用品出入库记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-04-26 21:30
 */
@Data
public class TackleOutLog {

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
    private Tackle tackle;
    /**
     * 使用的设备id
     */
    private Integer tackleId;
    /**
     * 使用设备的用户
     */
    private String userName;
    /**
     * 标签,用来插入结束日期
     */
    private Integer key;
}
