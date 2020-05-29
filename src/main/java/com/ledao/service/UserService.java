package com.ledao.service;

import com.ledao.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:02
 */
public interface UserService {

    /**
     * 根据用户名查找用户实体
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据真实姓名查找用户实体
     *
     * @param trueName
     * @return
     */
    User findByTrueName(String trueName);

    /**
     * 分页查询用户
     *
     * @param map
     * @return
     */
    List<User> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getTotal(Map<String, Object> map);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Integer add(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据用户真实姓名搜索用户
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查看可以预约的用户(医生或美容师)
     *
     * @return
     */
    List<User> canReserve();
}
