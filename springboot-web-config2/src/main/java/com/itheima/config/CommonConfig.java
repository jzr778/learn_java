package com.itheima.config;

import com.itheima.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean // 将当前方法的返回值交给IOC容器管理，成为IOC容器的bean
    public SAXReader saxReader(DeptService deptService){
        /**
         * 自己定义的类中进行依赖注入@Autowired
         * 第三方bean中依赖注入：直接在定义的方法中传入形参，Spring根据DeptService类型在IOC容器中找到对象完成注入
         */
        return new SAXReader();
    }
}
