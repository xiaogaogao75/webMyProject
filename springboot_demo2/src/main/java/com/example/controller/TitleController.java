package com.example.controller;

import com.example.entity.SingleTitle;
import com.example.entity.User;
import com.example.mapper.SingleTitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/groupexercise")
public class TitleController {
     @Autowired
     private SingleTitleMapper  singleTitleMapper;

     @GetMapping
     public List<SingleTitle> index(){
         List<SingleTitle> singleTitles = singleTitleMapper.selectList(null);
         System.out.println("==============================");
         System.out.println(Arrays.toString(singleTitles.toArray()));

         return singleTitles;
     }
}
