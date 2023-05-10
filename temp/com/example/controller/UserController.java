package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@MapperScan("com/example/mapper")
@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    public UserMapper userMapper;

    @Autowired
    public UserService userService;

    //新增和修改
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);

    }
    //查询所有
    @GetMapping
    public List<User> index(){
        return userService.list();
    }
    //删除数据根据id
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeBatchByIds(ids);
    }
    //分页查询 mybatis 方法
//    @GetMapping("/page")
//    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username){
//        pageNum = (pageNum-1) * pageSize;
////        username="%"+username+"%";
//        List<User> date= userMapper.findPage(pageNum,pageSize,username);
//        //查询总条数
//        Integer total= userMapper.selectTotal(username);
//        Map<String,Object> res =new HashMap<>();
//        res.put("total",total);
//        res.put("date",date);
//        return res;
//    }

    //mybatis-plus

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",username);
        return  userService.page(page,queryWrapper);

    }
}
