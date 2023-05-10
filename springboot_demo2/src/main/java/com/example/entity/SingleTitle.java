package com.example.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "single_title")
public class SingleTitle {
    @TableId(type = IdType.AUTO)
    private Integer titleId;

    private String titleName;

    private String titleAnswer;
    @TableField("titile_answera")
    private String titleAnswerA;
    @TableField("titile_answerb")
    private String titleAnswerB;
    @TableField("titile_answerc")
    private String titleAnswerC;
    @TableField("titile_answerd")
    private String titleAnswerD;
    private String titleAnalysis;
}
