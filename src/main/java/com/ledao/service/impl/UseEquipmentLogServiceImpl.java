package com.ledao.service.impl;

import com.ledao.entity.UseEquipmentLog;
import com.ledao.mapper.UseEquipmentLogMapper;
import com.ledao.service.UseEquipmentLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设备使用记录Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 15:29
 */
@Service("useEquipmentLogService")
public class UseEquipmentLogServiceImpl implements UseEquipmentLogService {

    @Resource
    private UseEquipmentLogMapper useEquipmentLogMapper;

    @Override
    public List<UseEquipmentLog> list(Map<String, Object> map) {
        return useEquipmentLogMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return useEquipmentLogMapper.getCount(map);
    }

    @Override
    public Integer add(UseEquipmentLog useEquipmentLog) {
        return useEquipmentLogMapper.add(useEquipmentLog);
    }

    @Override
    public Integer update(UseEquipmentLog useEquipmentLog) {
        return useEquipmentLogMapper.update(useEquipmentLog);
    }

    @Override
    public Integer delete(Integer id) {
        return useEquipmentLogMapper.delete(id);
    }

    @Override
    public UseEquipmentLog findById(Integer id) {
        return useEquipmentLogMapper.findById(id);
    }
}
