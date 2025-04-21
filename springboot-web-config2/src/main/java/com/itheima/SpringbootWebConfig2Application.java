package com.itheima;
import org.dom4j.io.SAXReader;
import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 自动装配原理：
 * 导入第三方依赖的配置类与bean对象
 * 方案一：@ComponentScan将第三方依赖包添加进Spring扫描组件的范围
 * 方案二：@Import导入
 */
//@Import({TokenParser.class}) // 导入普通类
//@Import({HeaderConfig.class}) // 导入配置类
//@Import({MyImportSelector.class}) // 导入ImportSelector接口实现类
@EnableHeaderConfig // 封装@Import注解
//@ComponentScan({"com.itheima","com.example"}) // 通过包名指定扫描范围
// 注解需要被Spring的组件扫描到才生效
@SpringBootApplication // 具有包扫描作用，（扫描范围）仅扫描当前包及其子包，不能扫描到第三方依赖的包
public class SpringbootWebConfig2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebConfig2Application.class, args);
	}

	/**
	 * 声明第三方bean
	 * @return
	 */
//	@Bean // 将当前方法的返回值交给IOC容器管理，成为IOC容器的bean
//	public SAXReader saxReader(){
//		return new SAXReader();
//	}
}
