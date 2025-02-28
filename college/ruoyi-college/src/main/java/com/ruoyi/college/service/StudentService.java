package com.ruoyi.college.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.college.domain.Student;
import com.ruoyi.college.domain.dto.StudentDTO;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<StudentDTO> selectStudentList(Student student);
}
