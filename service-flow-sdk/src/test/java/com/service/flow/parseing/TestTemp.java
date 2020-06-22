package com.service.flow.parseing;


import com.service.flow.model.BaseTemp;

/**
 * @author zhangcb
 * @ClassName TestComponent.java
 * @Description TODO
 * @createTime 2020年06月17日 17:06:00
 */
public class TestTemp extends BaseTemp {

    private String name;

    private Integer age;

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

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
