package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.Employement;
import com.ruoyi.college.mapper.EmployementMapper;
import com.ruoyi.college.service.EmployementService;
import org.springframework.stereotype.Service;

@Service
public class EmployementServiceImpl extends ServiceImpl<EmployementMapper, Employement> implements EmployementService {
}
