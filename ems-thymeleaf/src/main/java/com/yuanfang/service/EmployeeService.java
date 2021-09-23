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

    /**
     * 根据id查询员工信息
     * @param id
     */
    Employee findById(Integer id);

    /**
     * 更新员工信息
     * @param employee
     */
    void update(Employee employee);

    /**
     * 根据员工id删除员工信息
     * @param id
     */
    void delete(Integer id);
}
