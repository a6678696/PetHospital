package com.ledao.service;

import com.ledao.entity.Pet;

import java.util.List;
import java.util.Map;

/**
 * 客户宠物Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-02-02 14:43
 */
public interface PetService {

    /**
     * 分页分条件查询
     *
     * @param map
     * @return
     */
    List<Pet> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加宠物信息
     *
     * @param pet
     * @return
     */
    Integer add(Pet pet);

    /**
     * 修改宠物信息
     *
     * @param pet
     * @return
     */
    Integer update(Pet pet);

    /**
     * 删除宠物信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    Pet findById(Integer id);

    /**
     * 根据宠物名查找宠物
     *
     * @param name
     * @return
     */
    Pet findByName(String name);
}
