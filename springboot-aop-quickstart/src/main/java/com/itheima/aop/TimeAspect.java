package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect // AOP类
@Component // 交给IOC容器管理，成为IOC容器中bean对象
public class TimeAspect {
    /**
     *
     * execution(* com.itheima.service.*.*(..))
     * 切入点表达式
     * 执行包下所有类的所有方法
     *
     * JoinPoint 连接点
     * 可以被AOP控制的方法
     *
     * 抽取出来的重复逻辑，即共性功能成为 通知
     * Advice 通知，最终体现为一个方法
     *
     * 通知作用在切入点上
     * PointCut，匹配连接点的条件，通知仅会在切入点方法执行时被应用
     *
     * execution(* com.itheima.service.impl.DeptServiceImpl.list())
     * 表示只有com.itheima.service.impl包下DeptServiceImpl类的list方法才会应用该通知
     *
     * Aspect切面，描述通知与切入点的对应关系
     *
     * Target目标对象，通知所应用的对象
     *
     * AOP自动生成代理对象交给IOC容器，controller中注入的不再是目标对象而是代理对象
     */
    @Around("execution(* com.itheima.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录开始时间
        long begin = System.currentTimeMillis();
        // 2. 调用原始方法运行
        Object result = joinPoint.proceed();
        // 3. 记录结束时间，计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",end-begin);

        return result;
    }
}
