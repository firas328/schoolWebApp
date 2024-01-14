package com.springHandOn.schoolWebApp.aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@Aspect
@Slf4j
@Component
public class LoggerAspect {
    @Around("execution(* com.springHandOn.schoolWebApp..*.*(..))")
    public Object executionLog(ProceedingJoinPoint jointPoint) throws Throwable{
        log.info(jointPoint.getSignature()+" METHOD START ");
        Instant start=Instant.now();
        Object returnObj = jointPoint.proceed();
        Instant finish=Instant.now();
        float exDuration= Duration.between(start,finish).toMillis();
        log.info(jointPoint.getSignature().getName()+"METHOD FINISH IN :"+exDuration+" ms");
        return returnObj;
    }
    @AfterThrowing(value="execution(* com.springHandOn.schoolWebApp..*.*(..))",throwing="ex")
    public void exceptionLog(JoinPoint joinPoint, Exception ex){
        log.error(joinPoint.getSignature().getName()+"Throws Exception Due To :"+ex.getMessage());
    }
}
