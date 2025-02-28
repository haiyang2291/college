package com.ruoyi.college.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_employment")
public class Employement implements Serializable {
    @TableId(type = IdType.AUTO)
    private long id;
    @TableField("student_id")
    private String studentId;
    private String company;
    private String position;
    private String salary;
    private String area;
    @TableField("entry_time")
    private String entryTime;
    @TableField("industry_id")
    private String industryId;
    @TableField("create_by")
    private String createBy;
    @TableField("create_by")
    private String updateBy;
    @TableLogic
    private long deleted;
}