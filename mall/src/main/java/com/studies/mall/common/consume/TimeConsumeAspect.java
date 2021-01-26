package com.studies.mall.common.consume;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @date : 2020/7/24 10:47
 *  方法执行时间切面
 */
@Aspect
@Component
@Order(4)
@Slf4j
public class TimeConsumeAspect {

    @Pointcut("@annotation(com.studies.mall.common.consume.TimeConsumeLog)")
    public void fun() {

    }

    @Around("fun()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TimeConsumeLog timeConsumeLog = method.getAnnotation(TimeConsumeLog.class);
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime - startTime;
        String methodName=method.getDeclaringClass().getName()+"."+method.getName();
        String methodDesc=timeConsumeLog.methodDesc();
        log.info("methodName: {}, methodDesc: {} ==> 执行耗费: {}ms",methodName,methodDesc,costTime);
        return result;
    }

}

