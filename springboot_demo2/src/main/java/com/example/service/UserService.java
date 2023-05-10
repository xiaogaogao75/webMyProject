package com.example.service;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.controller.dto.UserDTO;
import com.example.entity.User;
import com.example.exception.ServiceException;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }
    //登录
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
        }catch (Exception e){
            throw new  ServiceException(Constants.CODE_600,"系统错误");

        }
        if ( one !=null ) {
            BeanUtil.copyProperties(one, userDTO, true);
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else{
            throw new  ServiceException(Constants.CODE_600,"用户或密码错误");
        }
    }

    public Boolean selectByUsername(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> list = queryWrapper.eq("username", user.getUsername());
        User one = getOne(queryWrapper);
        if (one ==null){
            saveUser(user);
            return true;
        }
        return false;
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
