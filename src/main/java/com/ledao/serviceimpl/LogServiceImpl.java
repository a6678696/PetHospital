package com.ledao.serviceimpl;

import com.ledao.entity.Log;
import com.ledao.mapper.LogMapper;
import com.ledao.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:09
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public Integer add(Log log) {
        return logMapper.add(log);
    }

    @Override
    public List<Log> list(Map<String, Object> map) {
        return logMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return logMapper.getCount(map);
    }
}
