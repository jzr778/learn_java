package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    // 根据id查询员工信息
    @Select("select * from emp where id=#{id};")
    public Emp getById(Integer id);
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id};")
//    public Emp empList(Integer id);

    // 条件查询员工
    // 方式一：注解
//    @Select("select *" +
//            "from emp where name like concat('%'+#{name}+'%') and gender=#{gender} and entrydate between #{begin} and #{end} order by update_time desc ;")
//    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);

    // 方式二：XML
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);


    // 根据id删除数据
    @Delete("delete from emp where id = #{id};") // 根据传递进来的id动态实现删除功能
    public void delete(Integer id); // 删除数据不需要返回值->void
    // 如果有返回值，表示此次操作影响的记录数->int

    // 插入
    // 新增(主键返回
    // 数据添加成功后需要获取插入数据库的主键
    // 如添加套餐数据时还需要维护套餐菜品关系表数据
    @Options(keyProperty = "id",useGeneratedKeys = true) // 需要拿到生成的主键值，获取到的主键封装到emp对象的id属性中
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" + // 字段名
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});") // 属性名
    public void insert(Emp emp);// #{}中获取的是对象的属性


    // 更新
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime}" +
            "where id=1;")
    public void update(Emp emp);
}
