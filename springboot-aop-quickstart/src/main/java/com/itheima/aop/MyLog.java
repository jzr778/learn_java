package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 描述注解什么时候生效，这里代表运行时有效
@Target(ElementType.METHOD) // 注解作用的地方，该注解用来标识方法，生效的地方为方法上
public @interface MyLog {
}
