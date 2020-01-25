package com.ledao.service.impl;

import com.ledao.entity.OverflowList;
import com.ledao.mapper.OverflowListMapper;
import com.ledao.service.OverflowListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品报溢单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:32
 */
@Service("overflowListService")
public class OverflowListServiceImpl implements OverflowListService {

    @Resource
    private OverflowListMapper overflowListMapper;

    @Override
    public String getTodayMaxOverflowNumber() {
        return overflowListMapper.getTodayMaxOverflowNumber();
    }

    @Override
    public OverflowList findById(Integer id) {
        return overflowListMapper.findById(id);
    }

    @Override
    public OverflowList findByOverflowNumber(String overflowNumber) {
        return overflowListMapper.findByOverflowNumber(overflowNumber);
    }

    @Override
    public Integer add(OverflowList overflowList) {
        return overflowListMapper.add(overflowList);
    }

    @Override
    public Integer update(OverflowList overflowList) {
        return overflowListMapper.update(overflowList);
    }

    @Override
    public List<OverflowList> list(Map<String, Object> map) {
        return overflowListMapper.list(map);
    }
}
