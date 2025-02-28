package com.ruoyi.college.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_department")

public class Department implements Serializable {
    @TableId(type = IdType.AUTO)
    private  long id;
    private  String name;
    @TableField("college_id")
    private  long collegeId;
    private  String introduction;
    @TableField("create_by")
    private  String createBy;
    @TableField("update_by")
    private  String updateBy;
    @TableLogic
    private  long deleted;

}
