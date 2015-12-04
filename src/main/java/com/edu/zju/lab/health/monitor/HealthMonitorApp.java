package com.edu.zju.lab.health.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2015/10/14.
 */
@SpringBootApplication
public class HealthMonitorApp extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(HealthMonitorApp.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/ecg/**")
                .addPathPatterns("/bloodketone/**").addPathPatterns("/bloodoxygen/**")
                .addPathPatterns("/bloodpressure/**").addPathPatterns("/bloodsugar/**")
                .addPathPatterns("/category/**");
    }
}
