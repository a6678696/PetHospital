package com.ledao.service.impl;

import com.ledao.entity.Suggestion;
import com.ledao.mapper.SuggestionMapper;
import com.ledao.service.SuggestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户建议或反馈Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-07 21:47
 */
@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService {

    @Resource
    private SuggestionMapper suggestionMapper;

    @Override
    public List<Suggestion> list(Map<String, Object> map) {
        return suggestionMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return suggestionMapper.getCount(map);
    }

    @Override
    public Integer add(Suggestion suggestion) {
        return suggestionMapper.add(suggestion);
    }

    @Override
    public Integer update(Suggestion suggestion) {
        return suggestionMapper.update(suggestion);
    }

    @Override
    public Integer delete(Integer id) {
        return suggestionMapper.delete(id);
    }

    @Override
    public Suggestion findById(Integer id) {
        return suggestionMapper.findById(id);
    }

    @Override
    public Long getCountTodaySuggestion(Integer customerId) {
        return suggestionMapper.getCountTodaySuggestion(customerId);
    }
}
