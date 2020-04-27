package com.ledao.service.impl;

import com.ledao.entity.Tackle;
import com.ledao.mapper.TackleMapper;
import com.ledao.service.TackleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 医院用品Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-04-08 10:49
 */
@Service("tackleService")
public class TackleServiceImpl implements TackleService {

    @Resource
    private TackleMapper tackleMapper;

    @Override
    public List<Tackle> list(Map<String, Object> map) {
        return tackleMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return tackleMapper.getCount(map);
    }

    @Override
    public Integer add(Tackle tackle) {
        return tackleMapper.add(tackle);
    }

    @Override
    public Integer update(Tackle tackle) {
        return tackleMapper.update(tackle);
    }

    @Override
    public Integer delete(Integer id) {
        return tackleMapper.delete(id);
    }

    @Override
    public Tackle findById(Integer id) {
        return tackleMapper.findById(id);
    }

    @Override
    public List<Tackle> findByName(String name) {
        return tackleMapper.findByName(name);
    }
}
