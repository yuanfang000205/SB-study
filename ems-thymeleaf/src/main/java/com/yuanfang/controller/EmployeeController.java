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

    /**
     * 查询员工列表
     * @param model
     * @return
     */
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
    /**
     * 删除员工
     */
    @RequestMapping("delete")
    public String delete(Integer id){
        String photo = employeeService.findById(id).getPhoto();
        //删除员工信息
        employeeService.delete(id);
        //删除员工头像
        File file = new File(realpath, photo);
        if (file.exists()){
            file.delete();
        }
        return "redirect:/employee/lists";
    }

    /**
     * 根据id查询员工详情信息
     * @return
     */
    @RequestMapping("detail")
    public String detail(Integer id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "updateEmp";
    }
    /**
     * 更新员工信息
     */
    @RequestMapping("update")
    public String update(Employee employee, MultipartFile img) throws IOException {
        boolean notEmpty = !img.isEmpty();
        //1.判断是否更新头像
        if (notEmpty) {
            //1.删除老的头像 根据id查询原始头像
            String oldPhoto = employeeService.findById(employee.getId()).getPhoto();
            File file = new File(realpath, oldPhoto);
            if (file.exists()) {
                file.delete();//删除文件
            }
            //2.处理新的头像上传
            String originalFilename = img.getOriginalFilename();
            String newFileName = uploadPhoto(img, originalFilename);
            //3.修改员工新的头像名称
            employee.setPhoto(newFileName);
        }
        //2.没有更新头像直接更新基本信息
        employeeService.update(employee);
        //更新成功,跳转到员工列表
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
