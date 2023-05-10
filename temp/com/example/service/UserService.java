package com.example.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }


//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        if (user.getId() == null){
//            System.out.println(user.getId());
//            return userMapper.insert(user); //没有id，新增
//        }else {         //有id，更新
//            return userMapper.update(user);
//        }
//    }
}
