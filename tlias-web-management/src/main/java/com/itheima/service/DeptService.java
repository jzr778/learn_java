package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {



    /*
    * 查询全部部门数据
    * */
    List<Dept> list();

    /*
    * 根据部门id删除数据
    * */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 修改部门数据
     */
    void update(Dept dept);
}
