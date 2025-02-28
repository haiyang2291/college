package com.ruoyi.college.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService extends IService<Department> {
    List<DepartmentDTO> selectDepartmentList(Department department);

    List<Department> getCollegeIdDepartment(Long collegeId);

}
