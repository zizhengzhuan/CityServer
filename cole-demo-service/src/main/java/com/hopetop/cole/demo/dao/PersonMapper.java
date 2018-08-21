package com.hopetop.cole.demo.dao;

import com.hopetop.cole.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonMapper {

    /**
     * 添加人员
     * @param person
     * @return
     */
    int insert(Person person);

    /**
     * 根据主键查找记录
     * @param personId
     * @return
     */
    Person selectByPrimaryKey(Long personId);

    /**
     * 根据主键删除记录
     * @param personId
     * @return
     */
    int deleteByPrimaryKey(Long personId);

    /**
     * 根据主键修改
     * @param personId
     * @return
     */
    int updateByPrimaryKey(Person personId);

    /**
     * 可选择插入
     * @param person
     * @return
     */
    int insertSelective(Person person);

    /**
     * 可选择修改
     * @param person
     * @return
     */
    int updateByPrimaryKeySelective(Person person);

    /**
     * 查询所有人员
     * @return
     */
    List<Person> selectPersonList();

    /**
     * 根据姓名查询
     * @param userName
     * @return
     */
    List<Person> selectByUserName(@Param("userName") String userName);

}
