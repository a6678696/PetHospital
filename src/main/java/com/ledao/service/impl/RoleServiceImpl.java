package com.ledao.service.impl;

import com.ledao.entity.Role;
import com.ledao.mapper.RoleMapper;
import com.ledao.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:58
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByUserId(Integer id) {
        return roleMapper.findByUserId(id);
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.findById(id);
    }

    @Override
    public List<Role> listAll() {
        return roleMapper.listAll();
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleMapper.findByRoleName(roleName);
    }

    @Override
    public List<Role> list(Map<String, Object> map) {
        return roleMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return roleMapper.getCount(map);
    }

    @Override
    public Integer add(Role role) {
        return roleMapper.add(role);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public Integer delete(Integer id) {
        return roleMapper.delete(id);
    }
}
