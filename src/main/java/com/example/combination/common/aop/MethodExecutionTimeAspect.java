package com.example.combination.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class MethodExecutionTimeAspect {

    @Around("execution(* com.example.combination.file.service.analyze.*Analyzer.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("[TimeLaps] {} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
