package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Menu;
import com.example.entity.Role;
import com.example.service.MenuService;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    //新增和修改
    @PostMapping
    public boolean save(@RequestBody Menu role){
        return menuService.save(role);
    }
    //查询所有
    @GetMapping
    public Result index(@RequestParam(defaultValue = "") String name){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        List<Menu> list = menuService.list(queryWrapper);
        //找出pid为null的一级菜单
        List<Menu> parentNode = list.stream().filter(menu -> menu.getPid() == null).collect(Collectors.toList());
        //找出一级菜单的子菜单
        for (Menu menu : parentNode) {
            menu.setChildren(list.stream().filter(m -> menu.getId().equals(m.getPid())).collect(Collectors.toList()));
        }
        return Result.success(parentNode);
    }
    //删除数据根据id
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return menuService.removeById(id);
    }
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return menuService.removeBatchByIds(ids);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String name){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        queryWrapper.orderByDesc("id");
        return  Result.success(menuService.page(new Page<>(pageNum,pageSize),queryWrapper));

    }
}
