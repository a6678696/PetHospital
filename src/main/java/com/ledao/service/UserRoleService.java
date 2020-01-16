package com.ledao.service;

/**
 * 用户角色关联service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 00:19
 */
public interface UserRoleService {

    /**
     * 根据用户id删除所有关联信息
     *
     * @param userId
     * @return
     */
    Integer deleteByUserId(Integer userId);
}
