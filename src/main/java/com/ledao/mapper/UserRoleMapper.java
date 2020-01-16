package com.ledao.mapper;

/**
 * 用户角色关联mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 00:10
 */
public interface UserRoleMapper {

    /**
     * 根据用户id删除所有关联信息
     *
     * @param userId
     * @return
     */
    Integer deleteByUserId(Integer userId);
}
