package com.hopetop.cole.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hopetop.cole.demo.dao.PersonMapper;
import com.hopetop.cole.demo.model.Person;
import com.hopetop.cole.demo.model.PersonExample;
import com.hopetop.cole.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类的描述
 *
 * @author: kunhour
 * @time: 2018/7/2 15:39
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public Page<Person> queryPersonList(){
        Page<Person> page=PageHelper.startPage(1,2);
        personMapper.selectByExample(new PersonExample());
        return  page;
    }

}
