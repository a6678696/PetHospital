package com.ledao.service.impl;

import com.ledao.entity.ArticleType;
import com.ledao.mapper.ArticleTypeMapper;
import com.ledao.service.ArticleTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 文章类型Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 15:47
 */
@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Resource
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> list(Map<String, Object> map) {
        return articleTypeMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return articleTypeMapper.getCount(map);
    }

    @Override
    public Integer add(ArticleType articleType) {
        return articleTypeMapper.add(articleType);
    }

    @Override
    public Integer update(ArticleType articleType) {
        return articleTypeMapper.update(articleType);
    }

    @Override
    public Integer delete(Integer id) {
        return articleTypeMapper.delete(id);
    }

    @Override
    public ArticleType findById(Integer id) {
        return articleTypeMapper.findById(id);
    }

    @Override
    public List<ArticleType> findByName(String name) {
        return articleTypeMapper.findByName(name);
    }
}
