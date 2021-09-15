package com.yuanfang.service.impl;

import com.yuanfang.dao.EmployeeDAO;
import com.yuanfang.entity.Employee;
import com.yuanfang.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EmployeeServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/15
 **/
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDAO employeeDAO;

    /**
     * 查询员工列表
     * @return 员工数组
     */
    @Override
    public List<Employee> empList() {
        return employeeDAO.findList();
    }

    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public Employee findEmpById(Integer id) {
       return employeeDAO.findById(id);
    }
}
