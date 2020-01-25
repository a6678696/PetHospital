package com.ledao.service.impl;

import com.ledao.entity.DamageList;
import com.ledao.mapper.DamageListMapper;
import com.ledao.service.DamageListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品报损单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:22
 */
@Service("damageListService")
public class DamageListServiceImpl implements DamageListService {

    @Resource
    private DamageListMapper damageListMapper;

    @Override
    public String getTodayMaxDamageNumber() {
        return damageListMapper.getTodayMaxDamageNumber();
    }

    @Override
    public DamageList findById(Integer id) {
        return damageListMapper.findById(id);
    }

    @Override
    public DamageList findByDamageNumber(String damageNumber) {
        return damageListMapper.findByDamageNumber(damageNumber);
    }

    @Override
    public Integer add(DamageList damageList) {
        return damageListMapper.add(damageList);
    }

    @Override
    public Integer update(DamageList damageList) {
        return damageListMapper.update(damageList);
    }

    @Override
    public List<DamageList> list(Map<String, Object> map) {
        return damageListMapper.list(map);
    }
}
