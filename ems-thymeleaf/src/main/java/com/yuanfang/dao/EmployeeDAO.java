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
     * 根据员工id删除员工
     * @param id
     */
    void delete(Integer id);

}
