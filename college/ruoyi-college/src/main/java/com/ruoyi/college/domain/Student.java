package com.ruoyi.college.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_student")

public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private  long id;
    private  String number;
    private  String name;
    @TableField("major_id")
    private  long majorId;
    private  String sex;
    private  String birthday;
    private  String age;
    private  String phone;
    private  String qq;
    private  String wechat;
    private  String email;
    @TableField("admission_time")
    private  String admissionTime;
    @TableField("graduation_time")
    private  String graduationTime;
    @TableField("create_by")
    private  String createBy;
    @TableField("create_by")
    private  String updateBy;
    @TableLogic
    private  long deleted;
}
