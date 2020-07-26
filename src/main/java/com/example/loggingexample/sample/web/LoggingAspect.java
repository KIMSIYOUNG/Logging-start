package com.example.loggingexample.sample.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.example.loggingexample.sample.web.AopLogController.*(..))")
    public Object wow(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("wow it works");
        final Object proceed = joinPoint.proceed();
        log.info("proceed not returned");
        return proceed;
    }
}
