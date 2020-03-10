package com.ledao.service.impl;

import com.ledao.entity.Inquiry;
import com.ledao.mapper.InquiryMapper;
import com.ledao.service.InquiryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户问诊Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-03-10 22:39
 */
@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService {

    @Resource
    private InquiryMapper inquiryMapper;

    @Override
    public List<Inquiry> list(Map<String, Object> map) {
        return inquiryMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return inquiryMapper.getCount(map);
    }

    @Override
    public Integer add(Inquiry inquiry) {
        return inquiryMapper.add(inquiry);
    }

    @Override
    public Integer update(Inquiry inquiry) {
        return inquiryMapper.update(inquiry);
    }

    @Override
    public Integer delete(Integer id) {
        return inquiryMapper.delete(id);
    }

    @Override
    public Inquiry findById(Integer id) {
        return inquiryMapper.findById(id);
    }
}
