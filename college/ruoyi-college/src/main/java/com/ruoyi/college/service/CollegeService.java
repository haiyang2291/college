package com.ruoyi.college.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.college.domain.College;

import java.util.List;

public interface CollegeService extends IService<College> {

    List<College> list(College college);
}
