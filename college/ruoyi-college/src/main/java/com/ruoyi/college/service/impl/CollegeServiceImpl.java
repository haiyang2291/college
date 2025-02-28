package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.College;
import com.ruoyi.college.mapper.CollegeMapper;
import com.ruoyi.college.service.CollegeService;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {
    @Override
    public List<College> list(College college) {
        LambdaQueryWrapper<College> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(college.getName()), College::getName, college.getName());
        return super.list(lambdaQueryWrapper);
    }
}
