package com.kav.CrudeApiService.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogExecutionTimerAdvice {

    @Around("@annotation(com.kav.CrudeApiService.annotation.TrackExecutionTIme)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
//        Before advice
        Object obj = proceedingJoinPoint.proceed();
//        after advice
        long end = System.currentTimeMillis() - start ;
        log.info(String.format("method {%s} took %s ms", proceedingJoinPoint.getSignature().getName(), end));
        return obj;
    }
}
