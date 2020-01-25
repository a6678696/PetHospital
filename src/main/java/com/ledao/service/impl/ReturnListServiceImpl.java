package com.ledao.service.impl;

import com.ledao.entity.ReturnList;
import com.ledao.mapper.ReturnListMapper;
import com.ledao.service.ReturnListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 退货单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 13:54
 */
@Service("returnListService")
public class ReturnListServiceImpl implements ReturnListService {

    @Resource
    private ReturnListMapper returnListMapper;

    @Override
    public String getTodayMaxReturnNumber() {
        return returnListMapper.getTodayMaxReturnNumber();
    }

    @Override
    public List<ReturnList> list(Map<String, Object> map) {
        return returnListMapper.list(map);
    }

    @Override
    public Integer add(ReturnList returnList) {
        return returnListMapper.add(returnList);
    }

    @Override
    public Integer update(ReturnList returnList) {
        return returnListMapper.update(returnList);
    }

    @Override
    public ReturnList findById(Integer id) {
        return returnListMapper.findById(id);
    }

    @Override
    public ReturnList findByReturnNumber(String returnName) {
        return returnListMapper.findByReturnNumber(returnName);
    }

    @Override
    public Integer delete(Integer id) {
        return returnListMapper.delete(id);
    }
}
