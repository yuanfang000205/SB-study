package com.yuanfang.entity;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/28
 **/
public class Pet {
    private Integer id;
    private String name;
    private Integer age;

    public Pet() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
