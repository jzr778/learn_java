package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门数据
     * @return
     */
    @Select("select * from dept;")
    List<Dept> list();

    /**
     * 根据id删除部门信息
     * @param id
     */
    @Delete("delete from dept where id=#{id};")
    void deleteById(Integer id);

    /**
     * 根据部门名称添加部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime});")
    void insert(Dept dept);

    @Select("select * from dept where id=#{id};")
    Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id};")
    void update(Dept dept);
}
