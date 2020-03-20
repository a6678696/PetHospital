package com.ledao.service.impl;

import com.ledao.entity.FosterCare;
import com.ledao.mapper.FosterCareMapper;
import com.ledao.service.FosterCareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 寄养记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-20 20:05
 */
@Service("fosterCareService")
public class FosterCareServiceImpl implements FosterCareService {

    @Resource
    private FosterCareMapper fosterCareMapper;

    @Override
    public List<FosterCare> list(Map<String, Object> map) {
        return fosterCareMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return fosterCareMapper.getCount(map);
    }

    @Override
    public Integer add(FosterCare fosterCare) {
        return fosterCareMapper.add(fosterCare);
    }

    @Override
    public Integer update(FosterCare fosterCare) {
        return fosterCareMapper.update(fosterCare);
    }

    @Override
    public Integer delete(Integer id) {
        return fosterCareMapper.delete(id);
    }

    @Override
    public FosterCare findById(Integer id) {
        return fosterCareMapper.findById(id);
    }
}
