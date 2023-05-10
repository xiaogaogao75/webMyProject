package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.OJTemp;
import com.example.mapper.OJTempMapper;
import org.springframework.stereotype.Service;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;

@Service
public class OJTempService extends ServiceImpl<OJTempMapper, OJTemp> {

    public static void compileAndRun(String code) {
        long startTime = System.nanoTime(); // 记录开始时间
        try {
            // 使用Java Compiler API编译代码
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
            String className = "CodeToRun";
            JavaFileObject javaFileObject = new JavaSourceFromString(className, code);
            Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(javaFileObject);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
            boolean success = task.call();
            fileManager.close();
            if (success) {
                // 使用反射机制运行代码
                Class<?> clazz = Class.forName(className);
                Method method = clazz.getDeclaredMethod("main", String[].class);
                method.invoke(null, (Object) null);
                System.out.println("运行成功！");
            } else {
                System.out.println("编译失败！");
            }
        } catch (Exception e) {
            System.out.println("运行出错：" + e.getMessage());
        }
        long endTime = System.nanoTime(); // 记录结束时间
        System.out.println("运行时间：" + (endTime - startTime) / 1000000 + "毫秒");
    }

    // JavaFileObject的实现类，用于将代码字符串转换为Java源文件
    static class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

}
