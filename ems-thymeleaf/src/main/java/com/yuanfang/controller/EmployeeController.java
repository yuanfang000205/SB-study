package com.yuanfang.controller;

import com.yuanfang.entity.Employee;
import com.yuanfang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    @Value("${photo.file.dir}")
    private String realpath;

    @RequestMapping("lists")
    public String emplist(Model model){
        //获取员工列表数据
        List<Employee> employeeList = employeeService.getLists();
        //保存员工列表数据
        model.addAttribute("employeeList",employeeList);
        //展示数据
        return "emplist";
    }
    /**
     * 添加员工
     */
    @RequestMapping("addEmp")
    public String addEmp(Employee employee, MultipartFile img) throws IOException {
        String originalFilename = img.getOriginalFilename();
        //1.处理头像的上传&修改文件名称
        if (originalFilename!=null){
            String newFileName = uploadPhoto(img, originalFilename);
            //2.保存员工信息
            //保存头像名字
            employee.setPhoto(newFileName);
            employeeService.add(employee);
        }
        return "redirect:/employee/lists";
    }

    //上传头像方法
    private String uploadPhoto(MultipartFile img, String originalFilename) throws IOException {
        String fileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = fileNamePrefix + fileNameSuffix;
        img.transferTo(new File(realpath, newFileName));
        return newFileName;
    }

}
