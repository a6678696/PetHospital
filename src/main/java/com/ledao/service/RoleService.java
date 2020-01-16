package com.ledao.service;

import com.ledao.entity.Role;

import java.util.List;

/**
 * 角色Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:55
 */
public interface RoleService {

    /**
     * 根据用户id查角色集合
     *
     * @param id
     * @return
     */
    List<Role> findByUserId(Integer id);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    Role findById(Integer id);
}
