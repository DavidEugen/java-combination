package com.example.combination.config;

import com.example.combination.common.aop.MethodExecutionTimeAspect;
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
