package com.itheima.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data // 提供get,set,toString方法
@Component // 交给IOC容器管理
@ConfigurationProperties(prefix = "aliyun.oss") // 属性自动注入
public class AliOSSProperties {

    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endpoint;
}
