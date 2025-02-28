package com.ruoyi.college.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.college.domain.Industry;

import java.util.List;

public interface IndustryService extends IService<Industry> {
    List<Industry> selectIndustryList(Industry industry);
}
