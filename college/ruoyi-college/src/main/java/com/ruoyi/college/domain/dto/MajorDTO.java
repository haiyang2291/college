package com.ruoyi.college.domain.dto;

import com.ruoyi.college.domain.College;
import com.ruoyi.college.domain.Department;
import lombok.Data;

import java.io.Serializable;
@Data
public class MajorDTO implements Serializable {
    private  long id;
    private  String name;
    private College college;
    private Department department;
    private  String introduction;
    private  String createBy;
    private  String updateBy;
}
