package com.example.config;

import com.example.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptors())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/register",
                        "/user/export","/user/import","/groupexercise/**","/api/**");    // 拦截所有请求，通过判断token是否合法，决定是否需要登录
    }
    @Bean
    public JwtInterceptor jwtInterceptors(){
        return new JwtInterceptor();
    }
}
