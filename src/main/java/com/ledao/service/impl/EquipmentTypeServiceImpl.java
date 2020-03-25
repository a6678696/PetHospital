package com.ledao.service.impl;

import com.ledao.entity.EquipmentType;
import com.ledao.mapper.EquipmentTypeMapper;
import com.ledao.service.EquipmentTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 设备类型Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 00:18
 */
@Service("equipmentTypeService")
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Resource
    private EquipmentTypeMapper equipmentTypeMapper;

    @Override
    public List<EquipmentType> list(Map<String, Object> map) {
        return equipmentTypeMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return equipmentTypeMapper.getCount(map);
    }

    @Override
    public Integer add(EquipmentType equipmentType) {
        return equipmentTypeMapper.add(equipmentType);
    }

    @Override
    public Integer update(EquipmentType equipmentType) {
        return equipmentTypeMapper.update(equipmentType);
    }

    @Override
    public Integer delete(Integer id) {
        return equipmentTypeMapper.delete(id);
    }

    @Override
    public EquipmentType findById(Integer id) {
        return equipmentTypeMapper.findById(id);
    }

    @Override
    public List<EquipmentType> findByName(String name) {
        return equipmentTypeMapper.findByName(name);
    }
}
