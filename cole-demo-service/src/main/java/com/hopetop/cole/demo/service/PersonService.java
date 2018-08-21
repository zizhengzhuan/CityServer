package com.hopetop.cole.demo.service;

import com.github.pagehelper.Page;
import com.hopetop.cole.demo.model.Person;

import java.util.List;


public interface PersonService {

    int addPerson(Person person);

    Person selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Person person);

    int insertSelective(Person person);

    int updateByPrimaryKeySelective(Person person);

    Page<Person> queryPersonList(int pageNum, int pageSize);

    List<Person> selectByName(String userName);
}
