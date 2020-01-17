package com.ledao.service;

import com.ledao.entity.Role;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据角色名查找角色实体
     *
     * @param roleName
     * @return
     */
    Role findByRoleName(String roleName);

    /**
     * 查询所有角色信息
     *
     * @return
     */
    List<Role> listAll();

    /**
     * 分页查询角色信息
     *
     * @param map
     * @return
     */
    List<Role> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加角色信息
     *
     * @param role
     * @return
     */
    Integer add(Role role);

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    Integer update(Role role);

    /**
     * 删除角色信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
