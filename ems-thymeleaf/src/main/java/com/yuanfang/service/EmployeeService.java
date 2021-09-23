package com.yuanfang.service;

import com.yuanfang.entity.Employee;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
public interface EmployeeService {
    /**
     * 获取员工列表
     * @return
     */
    List<Employee> getLists();

    /**
     * 添加员工
     * @param employee
     */
    void add(Employee employee);
}
