package com.yuanfang.entity;

import java.util.Date;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/23
 **/
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Date birthday;
    private String photo;//头像路径

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Employee(Integer id, String name, Double salary, String photo, Date birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.photo = photo;
        this.birthday = birthday;
    }

    public Employee() {
    }
}
