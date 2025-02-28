package com.ruoyi.college.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.dto.MajorDTO;
import com.ruoyi.college.domain.vo.MajorVO;

import java.util.List;

public interface MajorService extends IService<Major> {
    List<MajorDTO> selectMajorList(Major major);

    MajorVO getById(Long  id);

    List<Major> getDepartmentIdMajors(Long departmentId);

    Major getOneById(long majorId);
}
