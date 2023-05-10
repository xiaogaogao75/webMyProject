package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@TableName(value = "sys_menu")
public class Menu {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String path;
//    private String icon;
    private String description;

    @TableField(exist = false)
    private List<Menu> children;
    private Integer pid;
}
