package com.gzs.learn.boot.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Intercepter implements Ordered {
    @Around("execution(* com.gzs.learn.boot.aspectj.TestAspect.*(..))")
    public static Object around(ProceedingJoinPoint joinPoint)
            throws Throwable {
        System.out.println("before aspectj  and check is " );
        Object obj = joinPoint.proceed();
        System.out.println("after method");
        return obj;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
