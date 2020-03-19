package com.ledao.service.impl;

import com.ledao.entity.Vaccine;
import com.ledao.mapper.VaccineMapper;
import com.ledao.service.VaccineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 疫苗注射记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 00:00
 */
@Service("vaccineService")
public class VaccineServiceImpl implements VaccineService {

    @Resource
    private VaccineMapper vaccineMapper;

    @Override
    public List<Vaccine> list(Map<String, Object> map) {
        return vaccineMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return vaccineMapper.getCount(map);
    }

    @Override
    public Integer add(Vaccine vaccine) {
        return vaccineMapper.add(vaccine);
    }

    @Override
    public Integer update(Vaccine vaccine) {
        return vaccineMapper.update(vaccine);
    }

    @Override
    public Integer delete(Integer id) {
        return vaccineMapper.delete(id);
    }

    @Override
    public Vaccine findById(Integer id) {
        return vaccineMapper.findById(id);
    }
}
