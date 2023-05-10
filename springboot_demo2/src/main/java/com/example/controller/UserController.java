package com.example.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.controller.dto.UserDTO;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@MapperScan("com/example/mapper")
@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    public UserMapper userMapper;

    @Autowired
    public UserService userService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        String password = userDTO.getPassword();
        String username = userDTO.getUsername();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        UserDTO dto = userService.login(userDTO);
        return Result.success(dto);

    }
    //注册
    @PostMapping("/register")
    public Boolean register(@RequestBody User user ){
        Boolean jup = userService.selectByUsername(user);
        if (!jup){
            return false;
        }
        System.out.println(jup);
        return true;
    }

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


    //导出接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        //1.查询所有数据
        List<User> list = userService.list();

        //2.内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //ExcelWriter writer1 = ExcelUtil.getWriter("d:dasdasd.xlsx"); 写入指定文件

        //3.定义excel标题
        writer.addHeaderAlias("username","用户名");
        writer.addHeaderAlias("password","密码");
        writer.addHeaderAlias("nickname","昵称");
        writer.addHeaderAlias("email","邮箱");
        writer.addHeaderAlias("phone","电话");
        writer.addHeaderAlias("address","地址");

        //4.写入excel，使用默认样式，强制输出标题
        writer.write(list,true);

        //5.设置浏览器响应格式
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=user.xls");
        ServletOutputStream out=response.getOutputStream();
        writer.flush(out, true);
        //6.关闭writer，释放内存
        writer.close();
        //7.此处记得关闭输出Servlet流
        IoUtil.close(out);
    }
    //导入
    @PostMapping("/import")
    public Boolean imp(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        //表格第一行一定要英文，否则读取不到！！！ 模板在temp中
        List<User> users = reader.readAll(User.class);
        userService.saveBatch(users);
        return true;
    }


}
