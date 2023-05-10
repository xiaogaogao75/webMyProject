package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Role;
import com.example.entity.RoleMenu;
import com.example.mapper.RoleMapper;
import com.example.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Transactional
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        roleMenuMapper.delete(queryWrapper);
//        roleMenuMapper.deleteById(roleId);
        for (Integer menuId : menuIds) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    public List<Integer> getRoleMenu(Integer roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }
}
