package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询的结果封装类
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PageBean {
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    private Long total; // 总记录数

    private List rows; // 数据列表
    // 仅做数据载体，不对集合进行操作，所以可以不用泛型
    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }



}
