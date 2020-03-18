package com.ledao.service.impl;

import com.ledao.entity.MedicalRecord;
import com.ledao.mapper.MedicalRecordMapper;
import com.ledao.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 病例单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 00:00
 */
@Service("medicalRecordService")
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Resource
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    public List<MedicalRecord> list(Map<String, Object> map) {
        return medicalRecordMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return medicalRecordMapper.getCount(map);
    }

    @Override
    public Integer add(MedicalRecord medicalRecord) {
        return medicalRecordMapper.add(medicalRecord);
    }

    @Override
    public Integer update(MedicalRecord medicalRecord) {
        return medicalRecordMapper.update(medicalRecord);
    }

    @Override
    public Integer delete(Integer id) {
        return medicalRecordMapper.delete(id);
    }

    @Override
    public MedicalRecord findById(Integer id) {
        return medicalRecordMapper.findById(id);
    }
}
