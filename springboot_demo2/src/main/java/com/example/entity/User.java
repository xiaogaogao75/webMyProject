package com.example.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@TableName(value = "sys_user")
@ToString
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
//    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String role;


//    @TableField("") //指定数据库列名
}
