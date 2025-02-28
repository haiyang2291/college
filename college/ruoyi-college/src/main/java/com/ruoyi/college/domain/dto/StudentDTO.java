package com.ruoyi.college.domain.dto;

import com.ruoyi.college.domain.College;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Major;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;


@Data
public class StudentDTO implements Serializable {
    private  long id;
    @Excel(name = "学号")
    private  String number;
    @Excel(name = "姓名")
    private  String name;
    @Excel(name = "专业", targetAttr = "name")
    private Major major;
    @Excel(name = "院系名称", targetAttr = "name")
    private Department department;
    @Excel(name = "高校名称", targetAttr = "name")
    private College college;
    @Excel(name = "性别")
    private  String sex;
    @Excel(name = "出生日期")
    private  String birthday;
    @Excel(name = "年龄")
    private  String age;
    @Excel(name = "手机号码")
    private  String phone;
    @Excel(name = "qq")
    private  String qq;
    @Excel(name = "微信")
    private  String wechat;
    @Excel(name = "邮箱")
    private  String email;
    @Excel(name = "入学时间")
    private  String admissionTime;
    @Excel(name = "毕业时间")
    private  String graduationTime;
    private  String createBy;
    private  String updateBy;
}
