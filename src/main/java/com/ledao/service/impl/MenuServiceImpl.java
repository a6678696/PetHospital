package com.ledao.service.impl;

import com.ledao.entity.Menu;
import com.ledao.mapper.MenuMapper;
import com.ledao.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限菜单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 22:42
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findByParentIdAndRoleId(Integer parentId, Integer roleId) {
        return menuMapper.findByParentIdAndRoleId(parentId, roleId);
    }

    @Override
    public List<Menu> findByRoleId(Integer roleId) {
        return menuMapper.findByRoleId(roleId);
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.findById(id);
    }

    @Override
    public List<Menu> findByParentId(Integer parentId) {
        return menuMapper.findByParentId(parentId);
    }
}
