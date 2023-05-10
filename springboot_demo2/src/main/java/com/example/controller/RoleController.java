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
import com.example.entity.Role;
import com.example.entity.User;
import com.example.mapper.RoleMapper;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Role role){
        return roleService.save(role);
    }
    //查询所有
    @GetMapping
    public List<Role> index(){
        return roleService.list();
    }
    //删除数据根据id
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return roleService.removeById(id);
    }
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return roleService.removeBatchByIds(ids);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByDesc("id");
        return  Result.success(roleService.page(new Page<>(pageNum,pageSize),queryWrapper));

    }

    @PostMapping("/roleMenu/{roleId}")
    public Result roleMenu(@PathVariable Integer roleId,@RequestBody List<Integer>  menuIds){
        roleService.setRoleMenu(roleId,menuIds);
        return Result.success();
    }
    @GetMapping("/roleMenu/{roleId}")
    public Result getRoleMenu(@PathVariable Integer roleId){
        return Result.success(roleService.getRoleMenu(roleId));
    }
}
