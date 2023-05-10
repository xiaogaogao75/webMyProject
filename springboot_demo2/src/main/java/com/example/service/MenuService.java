package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Menu;
import com.example.mapper.MenuMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends ServiceImpl<MenuMapper, Menu> {
}
