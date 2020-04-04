package com.ledao.service.impl;

import com.ledao.entity.Equipment;
import com.ledao.mapper.EquipmentMapper;
import com.ledao.service.EquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设备Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-25 10:11
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> list(Map<String, Object> map) {
        return equipmentMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return equipmentMapper.getCount(map);
    }

    @Override
    public Integer add(Equipment equipment) {
        return equipmentMapper.add(equipment);
    }

    @Override
    public Integer update(Equipment equipment) {
        return equipmentMapper.update(equipment);
    }

    @Override
    public Integer delete(Integer id) {
        return equipmentMapper.delete(id);
    }

    @Override
    public Equipment findById(Integer id) {
        return equipmentMapper.findById(id);
    }

    @Override
    public List<Equipment> findByName(String name) {
        return equipmentMapper.findByName(name);
    }

    @Override
    public Long getCountByName(String name) {
        return equipmentMapper.getCountByName(name);
    }

    @Override
    public Long getCountByEquipmentTypeId(Integer equipmentTypeId) {
        return equipmentMapper.getCountByEquipmentTypeId(equipmentTypeId);
    }
}
