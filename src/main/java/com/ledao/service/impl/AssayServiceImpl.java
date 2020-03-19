package com.ledao.service.impl;

import com.ledao.entity.Assay;
import com.ledao.mapper.AssayMapper;
import com.ledao.service.AssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 化验记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 00:00
 */
@Service("assayService")
public class AssayServiceImpl implements AssayService {

    @Resource
    private AssayMapper assayMapper;

    @Override
    public List<Assay> list(Map<String, Object> map) {
        return assayMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return assayMapper.getCount(map);
    }

    @Override
    public Integer add(Assay assay) {
        return assayMapper.add(assay);
    }

    @Override
    public Integer update(Assay assay) {
        return assayMapper.update(assay);
    }

    @Override
    public Integer delete(Integer id) {
        return assayMapper.delete(id);
    }

    @Override
    public Assay findById(Integer id) {
        return assayMapper.findById(id);
    }
}
