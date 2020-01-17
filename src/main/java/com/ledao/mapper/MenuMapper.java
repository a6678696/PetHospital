package com.ledao.mapper;

import com.ledao.entity.Menu;

import java.util.List;

/**
 * 菜单mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 22:32
 */
public interface MenuMapper {

    /**
     * 根据父节点以及用户角色id查询子节点
     *
     * @param parentId
     * @param roleId
     * @return
     */
    List<Menu> findByParentIdAndRoleId(Integer parentId, Integer roleId);

    /**
     * 根据角色id获取菜单集合
     *
     * @param roleId
     * @return
     */
    List<Menu> findByRoleId(Integer roleId);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    Menu findById(Integer id);

    /**
     * 根据父节点查找所有子节点
     *
     * @param parentId
     * @return
     */
    List<Menu> findByParentId(Integer parentId);
}
