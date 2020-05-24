package com.ledao.service.impl;

import com.ledao.entity.SaleListPaymentInformation;
import com.ledao.mapper.SaleListPaymentInformationMapper;
import com.ledao.service.SaleListPaymentInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 条件查询客户支付记录Service接口实现类
 *
 * @author LeDao
 * @company
 * @create 2020-05-22 14:44
 */
@Service("saleListPaymentInformationService")
public class SaleListPaymentInformationServiceImpl implements SaleListPaymentInformationService {

    @Resource
    private SaleListPaymentInformationMapper saleListPaymentInformationMapper;

    @Override
    public List<SaleListPaymentInformation> list(Map<String, Object> map) {
        return saleListPaymentInformationMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return saleListPaymentInformationMapper.getCount(map);
    }

    @Override
    public Integer add(SaleListPaymentInformation saleListPaymentInformation) {
        return saleListPaymentInformationMapper.add(saleListPaymentInformation);
    }
}
