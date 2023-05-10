package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName(value = "oj_temp")
public class OJTemp {
    @TableId(type = IdType.AUTO)
    @TableField("oj_id")
    private Integer id;
    @TableField("oj_code")
    private String code;
    @TableField("oj_user_id")
    private int userId;
    @TableField("oj_answer")
    private String answer;
}
