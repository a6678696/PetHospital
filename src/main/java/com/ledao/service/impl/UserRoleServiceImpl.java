package com.ledao.service.impl;

import com.ledao.mapper.UserRoleMapper;
import com.ledao.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色关联Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 00:19
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer deleteByUserId(Integer userId) {
        return userRoleMapper.deleteByUserId(userId);
    }

    @Override
    public Integer add(Integer roleId, Integer userId) {
        return userRoleMapper.add(roleId, userId);
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return userRoleMapper.deleteByRoleId(roleId);
    }
}
