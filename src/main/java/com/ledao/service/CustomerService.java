package com.ledao.service;

import com.ledao.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * 客户Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 18:52
 */
public interface CustomerService {

    /**
     * 根据名称模糊查询客户信息
     *
     * @param name
     * @return
     */
    List<Customer> findByName(String name);

    /**
     * 根据联系人查找客户
     *
     * @param contact
     * @return
     */
    Customer findByContact(String contact);

    /**
     * 根据名称模糊查询客户信息
     *
     * @param userName
     * @return
     */
    List<Customer> findByUserName(String userName);

    /**
     * 判断用户名是否存在 返回1代表存在
     *
     * @param userName
     * @return
     */
    Long getCountByUserName(String userName);

    /**
     * 分页查询顾客信息
     *
     * @param map
     * @return
     */
    List<Customer> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加顾客信息
     *
     * @param customer
     * @return
     */
    Integer add(Customer customer);

    /**
     * 修改顾客信息
     *
     * @param customer
     * @return
     */
    Integer update(Customer customer);

    /**
     * 删除顾客信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    Customer findById(Integer id);
}
