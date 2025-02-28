package com.ruoyi.college.domain.dto;

import com.ruoyi.college.domain.College;
import lombok.Data;

import java.io.Serializable;
@Data
public class DepartmentDTO implements Serializable {
    private  long id;
    private  String name;
    private College college;
    private  String introduction;
    private  String createBy;
    private  String updateBy;
}
