package com.example;

import org.springframework.context.annotation.Import;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 元注解，修饰注解的注解
@Target(ElementType.TYPE)
@Import(MyImportSelector.class) // 要导入的配置类和bean
public @interface EnableHeaderConfig {
}
