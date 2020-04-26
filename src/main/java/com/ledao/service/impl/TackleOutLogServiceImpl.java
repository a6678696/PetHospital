package com.ledao.service.impl;

import com.ledao.entity.TackleOutLog;
import com.ledao.mapper.TackleOutLogMapper;
import com.ledao.service.TackleOutLogService;
import com.ledao.service.TackleOutLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 医院用品出库记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 15:29
 */
@Service("tackleOutLogService")
public class TackleOutLogServiceImpl implements TackleOutLogService {

    @Resource
    private TackleOutLogMapper tackleOutLogMapper;

    @Override
    public List<TackleOutLog> list(Map<String, Object> map) {
        return tackleOutLogMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return tackleOutLogMapper.getCount(map);
    }

    @Override
    public Integer add(TackleOutLog tackleOutLog) {
        return tackleOutLogMapper.add(tackleOutLog);
    }

    @Override
    public Integer update(TackleOutLog tackleOutLog) {
        return tackleOutLogMapper.update(tackleOutLog);
    }

    @Override
    public Integer delete(Integer id) {
        return tackleOutLogMapper.delete(id);
    }

    @Override
    public TackleOutLog findById(Integer id) {
        return tackleOutLogMapper.findById(id);
    }
}
