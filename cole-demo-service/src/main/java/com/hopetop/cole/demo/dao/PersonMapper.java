package com.hopetop.cole.demo.dao;

import com.hopetop.cole.demo.model.Person;
import com.hopetop.cole.demo.model.PersonExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类的描述
 * @author : kunhour
 * @version :1.0
 * @since : 2018/6/4 10:25
*/
@Mapper
public interface PersonMapper {
    /**
     *按照条件统计数量
     * @param example 条件
     * @return int
     */
    int countByExample(PersonExample example);
    /**
     * 按照条件删除
     * @param example 条件
     * @return int
     */
    int deleteByExample(PersonExample example);
    /**
     * 删除
     * @param personId id
     * @return int
     */
    int deleteByPrimaryKey(Long personId);
    /**
     * 插入
     * @param record 记录
     * @return int
     * @return int
     */
    int insert(Person record);

    /**
     * 插入
     * @param record 记录
     * @return int
     */
    int insertSelective(Person record);
    /**
     * 按照条件查询
     * @param example 条件
     * @return List
     */

    List<Person> selectByExample(PersonExample example);
    /**
     *根据ID查询
     * @param personId id
     * @return Person
     */
    Person selectByPrimaryKey(Long personId);
    /**
     *按照整行记录更新
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(Person record);
    /**
     *按照主键更新
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(Person record);

}