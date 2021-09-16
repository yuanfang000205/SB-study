package com.yuanfang.service;

import com.yuanfang.entity.Employee;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/15
 **/
public interface EmployeeService {

    /**
     * 员工列表
     * @return list
     */
    List<Employee> empList();

    /**
     * 添加员工信息
     * @param employee
     */
    void add(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 通过id查询员工信息
     * @param id
     * @return
     */
    Employee findEmpById(Integer id);

    void delete(Integer id);
}
