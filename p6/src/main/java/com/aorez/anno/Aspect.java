package com.aorez.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//注解配置切面对象bean
@Component("aspect")
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    //注解配置通知增强的方法
//    @Before("execution(* com.aorez.anno.*.*(..))")
    //测试切点表达式的抽取
    @Before("Aspect.pointcut1()")
    public void before() {
        System.out.println("Aspect before");
    }

    @AfterReturning("execution(* com.aorez.anno.*.*(..))")
    public void afterReturning() {
        System.out.println("Aspect afterReturning");
    }

    @Around("execution(* com.aorez.anno.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Aspect around before point");
        Object proceed = point.proceed();
        System.out.println("Aspect around after point");
        return proceed;
    }

    @AfterThrowing("execution(* com.aorez.anno.*.*(..))")
    public void afterThrowing() {
        System.out.println("Aspect afterThrowing");
    }

    @After("execution(* com.aorez.anno.*.*(..))")
    public void after() {
        System.out.println("Aspect after");
    }

    //测试切点表达式的抽取
    @Pointcut("execution(* com.aorez.anno.*.*(..))")
    public void pointcut1() {

    }
}
