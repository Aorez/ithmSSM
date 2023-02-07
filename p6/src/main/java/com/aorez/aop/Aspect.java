package com.aorez.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {
    public void before() {
        System.out.println("Aspect before");
    }

    //测试多种通知
    public void afterReturning() {
        System.out.println("Aspect afterReturning");
    }

    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Aspect around before point");
        Object proceed = point.proceed();
        System.out.println("Aspect around after point");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("Aspect afterThrowing");
    }

    public void after() {
        System.out.println("Aspect after");
    }
}
