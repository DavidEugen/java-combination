package com.example.combination.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodExecutionTimeAspect {

    @Around("execution(* com.example.combination.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("##" + joinPoint.getSignature() + " executed in " + executionTime + "ms ###");
        return proceed;
    }
}
