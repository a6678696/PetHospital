package com.ledao.service.impl;

import com.ledao.entity.Information;
import com.ledao.mapper.InformationMapper;
import com.ledao.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户消息Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-05-02 00:35
 */
@Service("informationService")
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationMapper informationMapper;

    @Override
    public List<Information> list(Map<String, Object> map) {
        return informationMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return informationMapper.getCount(map);
    }

    @Override
    public Integer add(Information information) {
        return informationMapper.add(information);
    }

    @Override
    public Integer update(Information information) {
        return informationMapper.update(information);
    }

    @Override
    public Integer delete(Integer id) {
        return informationMapper.delete(id);
    }

    @Override
    public Information findById(Integer id) {
        return informationMapper.findById(id);
    }
}
