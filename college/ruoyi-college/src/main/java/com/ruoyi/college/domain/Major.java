package com.ruoyi.college.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_major")

public class Major implements Serializable {
    @TableId(type = IdType.AUTO)
    private  long id;
    private  String name;
    @TableField("department_id")
    private  long departmentId;
    private  String introduction;
    @TableField("create_by")
    private  String createBy;
    @TableField("create_by")
    private  String updateBy;
    @TableLogic
    private  long deleted;

}
