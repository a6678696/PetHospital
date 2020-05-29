package com.ledao.service.impl;

import com.ledao.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ledao.mapper.UserMapper;
import com.ledao.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * 用户Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public User findByTrueName(String trueName) {
        return userMapper.findByTrueName(trueName);
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return userMapper.getTotal(map);
    }

    @Override
    public Integer add(User user) {
        return userMapper.add(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> canReserve() {
        return userMapper.canReserve();
    }
}
