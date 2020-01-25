package com.ledao.service.impl;

import com.ledao.entity.Carousel;
import com.ledao.mapper.CarouselMapper;
import com.ledao.service.CarouselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 轮播图Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:28
 */
@Service("carouselService")
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> list(Map<String, Object> map) {
        return carouselMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return carouselMapper.getCount(map);
    }

    @Override
    public Integer add(Carousel carousel) {
        return carouselMapper.add(carousel);
    }

    @Override
    public Integer update(Carousel carousel) {
        return carouselMapper.update(carousel);
    }

    @Override
    public Integer delete(Integer id) {
        return carouselMapper.delete(id);
    }

    @Override
    public Carousel findById(Integer id) {
        return carouselMapper.findById(id);
    }
}
