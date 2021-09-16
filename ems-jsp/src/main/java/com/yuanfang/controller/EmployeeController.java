package com.yuanfang.controller;

import com.yuanfang.entity.Employee;
import com.yuanfang.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/15
 **/
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 查看员工列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String employeeList(HttpServletRequest request, Model model){
        List<Employee> employees = employeeService.empList();
        //request.setAttribute("employees",employees);
        model.addAttribute("employees",employees);
        return "emplist";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping("add")
    public String addEmployee(Employee employee){
        //添加员工信息
        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    /**
     * 根据id查询员工信息
     * @param id 员工id
     * @return
     */
    @RequestMapping("detail")
    public String findById(Integer id,Model model){
        Employee employee = employeeService.findEmpById(id);
        //将查询到的员工信息保存至作用域
        model.addAttribute("employee",employee);
        return "updateEmp";
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @RequestMapping("update")
    public String updateEmployee(Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    /**
     * 删除员工
     * @param id 员工id
     * @return
     */
    @RequestMapping("delete")
    public String deleteEmployee(Integer id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
