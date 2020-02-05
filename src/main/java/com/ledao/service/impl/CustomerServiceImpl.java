package com.ledao.service.impl;

import com.ledao.entity.Customer;
import com.ledao.mapper.CustomerMapper;
import com.ledao.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 18:53
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findByName(String name) {
        return customerMapper.findByName(name);
    }

    @Override
    public Customer findByContact(String contact) {
        return customerMapper.findByContact(contact);
    }

    @Override
    public List<Customer> findByUserName(String userName) {
        return customerMapper.findByUserName(userName);
    }

    @Override
    public Long getCountByUserName(String userName) {
        return customerMapper.getCountByUserName(userName);
    }

    @Override
    public List<Customer> list(Map<String, Object> map) {
        return customerMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return customerMapper.getCount(map);
    }

    @Override
    public Integer add(Customer customer) {
        return customerMapper.add(customer);
    }

    @Override
    public Integer update(Customer customer) {
        return customerMapper.update(customer);
    }

    @Override
    public Integer delete(Integer id) {
        return customerMapper.delete(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }
}
