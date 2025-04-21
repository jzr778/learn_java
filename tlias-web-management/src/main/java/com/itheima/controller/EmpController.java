package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 查询员工信息
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/emps")
    public Result page(String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
        // @RequestParam 中 defaultValue 设置默认值
//        if(page == null) page = 1;
//        if(pageSize == null) pageSize = 10;
        log.info("分页查询参数：{},{},{},{},{},{}",name,gender,begin,end,page,pageSize);
        PageBean pageBean = empService.page(name,gender,begin,end,page,pageSize);
        return Result.success(pageBean);
    }

    /**
     * 删除员工信息
     * @param ids
     * @return
     */
    @Log
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除参数ids：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @Log
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.add(emp);
        return Result.success();
    }

    /**
     * 根据id查询回显
     * @param id
     * @return
     */
    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工,id:{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
