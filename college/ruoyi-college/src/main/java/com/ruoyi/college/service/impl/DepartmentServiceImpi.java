package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.dto.DepartmentDTO;
import com.ruoyi.college.mapper.DepartmentMapper;
import com.ruoyi.college.service.CollegeService;
import com.ruoyi.college.service.DepartmentService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpi extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Autowired
    private CollegeService collegeService;

    @Override
    public List<DepartmentDTO> selectDepartmentList(Department department) {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        LambdaQueryWrapper<Department> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(department.getName()), Department::getName, department.getName());
        List<Department> departmentList = super.list(queryWrapper);
        departmentList.forEach(d -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyBeanProp(departmentDTO, d);
            departmentDTO.setCollege(collegeService.getById(d.getCollegeId()));
            departmentDTOList.add(departmentDTO);
        });
        return departmentDTOList;
    }

    @Override
    public List<Department> getCollegeIdDepartment(Long collegeId) {
        LambdaQueryWrapper<Department> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Department::getCollegeId, collegeId);
        return super.list(queryWrapper);
    }
}
//    @Override
//    public String getCollegeIdDepartment(Long collegeId) {
//        return "";
//    }
//}
