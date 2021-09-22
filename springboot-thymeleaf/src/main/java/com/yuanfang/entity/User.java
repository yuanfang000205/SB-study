package com.yuanfang.entity;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/19
 **/
public class User {
    private Integer id;
    private String name;
    private Double salary;
    private Date bir;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bir=" + bir +
                '}';
    }

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

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public User() {
    }

    public User(Integer id, String name, Double salary, Date bir) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bir = bir;
    }
}
