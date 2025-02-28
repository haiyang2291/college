package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.Industry;
import com.ruoyi.college.mapper.IndustryMapper;
import com.ruoyi.college.service.IndustryService;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl extends ServiceImpl<IndustryMapper, Industry> implements IndustryService {
    @Override
    public List<Industry> selectIndustryList(Industry industry) {
        LambdaQueryWrapper<Industry> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(industry.getName()), Industry::getName, industry.getName());
        return super.list(queryWrapper);
    }
}
