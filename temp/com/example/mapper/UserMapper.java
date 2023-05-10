package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

    //mybatis查询
//    @Select("SELECT * from sys_user")
//    List<User> findAll();
//
//    @Insert("INSERT into sys_user(username,password,nickname,email,phone,address) " +
//            "VALUES (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
//    int  insert(User user);
//
////    @Update("update sys_user set username=#{username},password=#{password},nickname=#{nickname}" +
////            ",email=#{email},phone=#{phone},address=#{address} where id=#{id}")
//    int update(User user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like  concat('%',#{username},'%') limit #{pageNum},#{pageSize}")
//    List<User> findPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("username") String username);
//    @Select("select count(*) from sys_user where username like  concat('%',#{username},'%')")
//    Integer selectTotal(String username);


//    mybatis-plus查询

}
