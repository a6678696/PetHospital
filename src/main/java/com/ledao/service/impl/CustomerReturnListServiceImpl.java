package com.ledao.service.impl;

import com.ledao.entity.CustomerReturnList;
import com.ledao.mapper.CustomerReturnListMapper;
import com.ledao.service.CustomerReturnListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户退货单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 00:16
 */
@Service("customerReturnListService")
public class CustomerReturnListServiceImpl implements CustomerReturnListService {

    @Resource
    private CustomerReturnListMapper customerReturnListMapper;

    @Override
    public String getTodayMaxCustomerReturnNumber() {
        return customerReturnListMapper.getTodayMaxCustomerReturnNumber();
    }

    @Override
    public CustomerReturnList findById(Integer id) {
        return customerReturnListMapper.findById(id);
    }

    @Override
    public CustomerReturnList findByCustomerReturnNumber(String customerReturnNumber) {
        return customerReturnListMapper.findByCustomerReturnNumber(customerReturnNumber);
    }

    @Override
    public Integer add(CustomerReturnList customerReturnList) {
        return customerReturnListMapper.add(customerReturnList);
    }

    @Override
    public Integer update(CustomerReturnList customerReturnList) {
        return customerReturnListMapper.update(customerReturnList);
    }

    @Override
    public List<CustomerReturnList> list(Map<String, Object> map) {
        return customerReturnListMapper.list(map);
    }

    @Override
    public Integer delete(Integer id) {
        return customerReturnListMapper.delete(id);
    }
}
