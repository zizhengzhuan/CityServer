package com.hopetop.cole.demo.model;

import org.springframework.stereotype.Component;

/**
 * 实体类
 */
public class Person {

    private Long personId;

    private String userName;

    private Integer age;

    private Integer sex;

    public Person() {
    }

    public Person(Long personId, String userName, Integer age, Integer sex) {
        this.personId = personId;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
