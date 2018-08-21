package com.hopetop.cole.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hopetop.cole.demo.dao.PersonMapper;
import com.hopetop.cole.demo.model.Person;
import com.hopetop.cole.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public int addPerson(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Person selectByPrimaryKey(Long id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Person person) {
        return personMapper.updateByPrimaryKey(person);
    }

    @Override
    public int insertSelective(Person person) {
        return personMapper.insertSelective(person);
    }

    @Override
    public int updateByPrimaryKeySelective(Person person) {
        return personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public Page<Person> queryPersonList(int pageNum, int pageSize) {
        Page<Person> page=PageHelper.startPage(pageNum, pageSize);
        personMapper.selectPersonList();
        return page;
    }

    @Override
    public List<Person> selectByName(String userName) {
        return personMapper.selectByUserName(userName);
    }
}
