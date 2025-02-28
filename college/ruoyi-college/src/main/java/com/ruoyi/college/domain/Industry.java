package com.ruoyi.college.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_industry")

public class Industry implements Serializable {
    @TableId(type = IdType.AUTO)
    private  long id;
    private  String name;
    @TableField("create_by")
    private  String createBy;
    @TableField("create_by")
    private  String updateBy;
    @TableLogic
    private  long deleted;

}
