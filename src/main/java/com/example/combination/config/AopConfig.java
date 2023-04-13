package com.example.combination.config;

import com.example.combination.config.aop.MethodExecutionTimeAspect;
//import com.example.combination.test.MethodExecutionTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public MethodExecutionTimeAspect executionTimeAspect() {
        return new MethodExecutionTimeAspect();
    }
}
