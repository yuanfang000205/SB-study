package com.yuanfang.dao;

import com.yuanfang.entity.Employee;

import java.util.List;

/**
 * @ClassName EmployeeDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/15
 **/
public interface EmployeeDAO {

    /**
     * 查询员工列表
     * @return list
     */
    List<Employee> findList();

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
     * 根据id查询员工
     * @param id
     * @return
     */
    Employee findById(Integer id);

    void delete(Integer id);
}
