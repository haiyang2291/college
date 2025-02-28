package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.College;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.dto.MajorDTO;
import com.ruoyi.college.domain.vo.MajorVO;
import com.ruoyi.college.mapper.MajorMapper;
import com.ruoyi.college.service.CollegeService;
import com.ruoyi.college.service.DepartmentService;
import com.ruoyi.college.service.MajorService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImpl extends ServiceImpl <MajorMapper, Major> implements MajorService {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CollegeService collegeService;
    @Override
    public List<MajorDTO> selectMajorList(Major major) {
        List<MajorDTO> majorDTOList=new ArrayList<>();
        LambdaQueryWrapper<Major> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(major.getName()), Major::getName, major.getName());
        List<Major> majorList = super.list(lambdaQueryWrapper);
        majorList.forEach(m -> {
            MajorDTO majorDTO = new MajorDTO();
            BeanUtils.copyBeanProp(majorDTO, m);
            Department department = departmentService.getById(m.getDepartmentId());
            if (department != null){
                majorDTO.setDepartment(department);
            }
            College college = collegeService.getById(department.getCollegeId());
            if (college != null){
                majorDTO.setCollege(college);
            }
            majorDTOList.add(majorDTO);
//            majorDTO.setDepartment(department);
//            majorDTO.setCollege(collegeService.getById(department.getCollegeId()));
//            majorDTOList.add(majorDTO);
        });
        return majorDTOList;
    }

    @Override
    public MajorVO getById(Long id) {
        MajorVO majorVO = new MajorVO();
        Major major = super.getById(id);
//        判断对象不为空
        if (major != null){
            majorVO.setId(major.getId());
        }

        return majorVO;
    }

    @Override
    public List<Major> getDepartmentIdMajors(Long departmentId) {
            LambdaQueryWrapper<Major> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Major::getDepartmentId, departmentId);
            return super.list(lambdaQueryWrapper);
        }

    @Override
    public Major getOneById(long majorId) {
        return super.getById(majorId);
    }

}
