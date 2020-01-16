package com.ledao.serviceimpl;

import com.ledao.entity.Role;
import com.ledao.mapper.RoleMapper;
import com.ledao.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
