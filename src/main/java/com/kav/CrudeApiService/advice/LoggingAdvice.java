package com.kav.CrudeApiService.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAdvice {
    @Pointcut("execution(* com.kav.CrudeApiService.services.UserService.*(..))")
    private  void logPointCut(){}
    @Before("logPointCut()")
    public void logRequestBefore(JoinPoint joinPoint){
        log.info("Before - "+  joinPoint.getTarget() + " " + joinPoint.getSignature().getName());

    }
    @After("logPointCut()")
    public void logRequestAfter(JoinPoint joinPoint){
        log.info("After - " +  joinPoint.getTarget() +" " + joinPoint.getSignature().getName());

    }
}
