package com.example.controller;

import com.example.entity.OJTemp;
import com.example.entity.Role;
import com.example.entity.SingleTitle;
import com.example.mapper.OJTempMapper;
import com.example.mapper.SingleTitleMapper;
import com.example.service.OJTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OJTempController {
    @Autowired
    private OJTempService ojTempService;

    @PostMapping
    public boolean save(@RequestBody OJTemp ojTemp){
        return ojTempService.save(ojTemp);
    }
    @PostMapping("/demo")
    public void demo(@RequestBody String code){
        System.out.println(code);
        String code1 = "public class HelloWorld {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello, world!\");\n" +
                "    }\n" +
                "}";

        System.out.println(code1);
        System.out.println(code1);
        System.out.println(code);
        OJTempService.compileAndRun(code1);
    }

}


