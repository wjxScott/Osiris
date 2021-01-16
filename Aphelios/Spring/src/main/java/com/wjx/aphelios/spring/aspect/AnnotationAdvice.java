package com.wjx.aphelios.spring.aspect;

/**
 * @author WJX
 * @since 2018/4/21 22:53
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Spring注解方式的通知类
 */
//表明是一个通知类
@Aspect
public class AnnotationAdvice {

    @Pointcut("execution(* com.wjx.service..*Impl.*(..))")
    public void cutpoint() {
    }

    //前置通知
    @Before("AnnotationAdvice.cutpoint()")
    public void before() {
        System.out.println("这是前置通知!!");
    }

    //后置通知
    @AfterReturning("execution(* com.wjx.service..*Impl.*(..))")
    public void afterReturning() {
        System.out.println("这是后置通知(如果出现异常不会调用)!!");
    }

    //环绕通知
    @Around("execution(* com.wjx.service..*Impl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!!");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分!!");
        return proceed;
    }

    //异常通知
    @AfterThrowing("execution(* com.wjx.service..*Impl.*(..))")
    public void afterException() {
        System.out.println("出事啦!出现异常了!!");
    }

    //后置通知
    @After("execution(* com.wjx.service..*Impl.*(..))")
    public void after() {
        System.out.println("这是后置通知(出现异常也会调用)!!");
    }
}