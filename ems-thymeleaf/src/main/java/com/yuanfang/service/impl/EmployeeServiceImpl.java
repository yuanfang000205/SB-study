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
 * @Date 2021/9/23
 **/
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDAO employeeDAO;
    @Override
    public List<Employee> getLists() {
        return employeeDAO.lists();
    }

    @Override
    public void add(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return  employeeDAO.findById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }
}
