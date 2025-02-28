package com.ruoyi.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.college.domain.College;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.Student;
import com.ruoyi.college.domain.dto.StudentDTO;
import com.ruoyi.college.mapper.StudentMapper;
import com.ruoyi.college.service.CollegeService;
import com.ruoyi.college.service.DepartmentService;
import com.ruoyi.college.service.MajorService;
import com.ruoyi.college.service.StudentService;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{
    @Autowired
    private MajorService majorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CollegeService collegeService;
    @Override
    public List<StudentDTO> selectStudentList(Student student) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        LambdaQueryWrapper <Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(student.getNumber()), Student::getNumber, student.getNumber());
        queryWrapper.like(StringUtils.isNotEmpty(student.getName()), Student::getName, student.getName());
        List<Student> studentList = super.list(queryWrapper);
        studentList.forEach(s->{
            StudentDTO studentDTO=new StudentDTO();
            BeanUtils.copyBeanProp(studentDTO,s);

            Major major =  majorService.getOneById(s.getMajorId());
            if (major != null){
                studentDTO.setMajor(major);
            Department department = departmentService.getById(major.getDepartmentId());
            if (department != null)
                studentDTO.setDepartment(department);
            College college = collegeService.getById(department.getCollegeId());
            if (college != null)
                studentDTO.setCollege(college);
            studentDTOList.add(studentDTO);
            }

        });
        return studentDTOList;
    }
}
