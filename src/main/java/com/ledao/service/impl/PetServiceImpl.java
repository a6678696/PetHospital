package com.ledao.service.impl;

import com.ledao.entity.Pet;
import com.ledao.mapper.PetMapper;
import com.ledao.service.PetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户宠物Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-02-02 14:44
 */
@Service("petService")
public class PetServiceImpl implements PetService {

    @Resource
    private PetMapper petMapper;

    @Override
    public List<Pet> list(Map<String, Object> map) {
        return petMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return petMapper.getCount(map);
    }

    @Override
    public Integer add(Pet pet) {
        return petMapper.add(pet);
    }

    @Override
    public Integer update(Pet pet) {
        return petMapper.update(pet);
    }

    @Override
    public Integer delete(Integer id) {
        return petMapper.delete(id);
    }

    @Override
    public Pet findById(Integer id) {
        return petMapper.findById(id);
    }

    @Override
    public Pet findByName(String name) {
        return petMapper.findByName(name);
    }
}
