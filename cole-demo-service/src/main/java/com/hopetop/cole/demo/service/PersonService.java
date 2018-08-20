package com.hopetop.cole.demo.service;

import com.github.pagehelper.Page;
import com.hopetop.cole.demo.model.Person;

import java.util.List;

public interface PersonService {
    Page<Person> queryPersonList();
}
