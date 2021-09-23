package com.yuanfang.dao;

import com.yuanfang.entity.Employee;

import java.util.List;

/**
 * @ClassName EmployeeDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
public interface EmployeeDAO {
    /**
     * 获取员工列表
     * @return
     */
    List<Employee> lists();

    /**
     * 添加员工
     * @param employee
     */
    void save(Employee employee);
}
