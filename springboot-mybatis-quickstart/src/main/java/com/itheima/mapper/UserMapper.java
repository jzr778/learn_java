package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // mybatis的mapper接口，运行时会自动生成该接口的实现类对象（动态代理中的代理对象），并且将该对象交给spring的IOC容器管理
public interface UserMapper {
    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
