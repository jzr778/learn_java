package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
//    @Select("select count(*) from emp;")
//    public Long count();

    /**
     * 分页查询
     * @param start
     * @param pageSize
     * @return
     */
//    @Select("select * from emp limit #{start},#{pageSize};")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, dept_id, entrydate, job,  create_time, update_time)\n" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{deptId}, #{entrydate}, #{job}, #{createTime}, #{updateTime});")
    public void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
