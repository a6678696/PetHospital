package com.ledao.service.impl;

import com.ledao.entity.ReturnVisit;
import com.ledao.mapper.ReturnVisitMapper;
import com.ledao.service.ReturnVisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户回访记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 00:00
 */
@Service("returnVisitService")
public class ReturnVisitServiceImpl implements ReturnVisitService {

    @Resource
    private ReturnVisitMapper returnVisitMapper;

    @Override
    public List<ReturnVisit> list(Map<String, Object> map) {
        return returnVisitMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return returnVisitMapper.getCount(map);
    }

    @Override
    public Integer add(ReturnVisit returnVisit) {
        return returnVisitMapper.add(returnVisit);
    }

    @Override
    public Integer update(ReturnVisit returnVisit) {
        return returnVisitMapper.update(returnVisit);
    }

    @Override
    public Integer delete(Integer id) {
        return returnVisitMapper.delete(id);
    }

    @Override
    public ReturnVisit findById(Integer id) {
        return returnVisitMapper.findById(id);
    }
}
