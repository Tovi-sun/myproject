package org.sunyiwei.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * =============================
 *
 * @author:sunyiwei DateTime: 2019/3/27 10:14
 * =============================
 */
@Aspect
@Configuration
public class AopConfiguration {
    @Pointcut("execution(* org.sunyiwei.service.*.*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void before()
    {
        System.out.println("你好！Aop");
    }



}
