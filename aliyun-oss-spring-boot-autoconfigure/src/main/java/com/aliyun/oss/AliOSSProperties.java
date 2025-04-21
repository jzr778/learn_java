package com.aliyun.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data // 提供get,set,toString方法
/**
 * 需求：自定义aliyun-oss-spring-boot-starter完成阿里云OSS操作工具类AliyunOSSUtils的自动配置
 * 目标：引入起步依赖后想要使用阿里云OSS直接注入AliyunOSSUtils即可
 *
 * 要使用第三方包的bean对象，需要在第三方包使用@Component将类交给IOC容器管理，使用时需要让Sping扫描到生效
 * 因为自动配置后不需要用户扫描com.aliyun.oss这个包，所以不需要@Component
 */
//@Component // 交给IOC容器管理
/**
 * AliOSSProperties已经不是一个bean了，无法使用@ConfigurationProperties将配置文件中的值注入
 * 解决方法：在配置类中注解
 * @EnableConfigurationProperties(AliOSSProperties.class) // 将AliOSSProperties类导入IOC容器成为bean
 */
@ConfigurationProperties(prefix = "aliyun.oss") // 属性自动注入
public class AliOSSProperties {

    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endpoint;
}
