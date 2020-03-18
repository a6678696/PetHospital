package com.ledao.mapper;

import com.ledao.entity.MedicalRecord;

import java.util.List;
import java.util.Map;

/**
 * 病例单Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:45
 */
public interface MedicalRecordMapper {

    /**
     * 根据条件查询病例单
     *
     * @param map
     * @return
     */
    List<MedicalRecord> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加病历单
     *
     * @param medicalRecord
     * @return
     */
    Integer add(MedicalRecord medicalRecord);

    /**
     * 修改病历单
     *
     * @param medicalRecord
     * @return
     */
    Integer update(MedicalRecord medicalRecord);

    /**
     * 根据id删除病历单
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询病历单
     *
     * @param id
     * @return
     */
    MedicalRecord findById(Integer id);
}
