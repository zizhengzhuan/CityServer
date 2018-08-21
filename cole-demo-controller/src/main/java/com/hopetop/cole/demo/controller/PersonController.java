package com.hopetop.cole.demo.controller;

import com.github.pagehelper.Page;
import com.hopetop.cole.common.response.BaseResponse;
import com.hopetop.cole.common.response.PageResponse;
import com.hopetop.cole.common.tool.ResultTool;
import com.hopetop.cole.demo.model.Person;
import com.hopetop.cole.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@Api(value = "人员Controller")
@Slf4j
public class PersonController {

    @Autowired
    PersonService personService;

    @ApiOperation(value = "添加人员", notes = "添加人员")
    @GetMapping("/add")
    @ApiImplicitParams(//非对象参数集
            {
                    @ApiImplicitParam(//非对象参数描述
                            paramType = "query",//查询参数类型---query：直接跟参数完成自动映射赋值
                            dataType = "Long",//参数的数据类型(Long,String)，只作为标志说明，并没有验证
                            name = "personId",//接收参数名
                            value = "personId",//接收参数的意义描述
                            required = true//参数是否必填(true:必填，false:非必填)
                    ),
                    @ApiImplicitParam(paramType = "query",dataType = "String",name = "userName",value = "userName",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "age",value = "age",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "sex",value = "sex",required = true)
            }
    )
    BaseResponse<Integer> add(Person person){
        return ResultTool.success(personService.addPerson(person));
    }

    @ApiOperation(value = "根据主键查找", notes = "根据主键查找")
    @GetMapping("/queryById")
    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "personId",value = "personId",required = true)
    BaseResponse<Person> queryById(Long personId){
        return ResultTool.success( personService.selectByPrimaryKey(personId) );
    }

    @ApiOperation(value = "按主键删除",notes = "按主键删除")
    @GetMapping("/deleteById")
    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "personId",value = "personId",required = true)
    BaseResponse<Integer> deleteById(Long personId){
        return ResultTool.success(personService.deleteByPrimaryKey(personId));
    }

    @ApiOperation(value = "根据主键修改", notes = "根据主键修改")
    @GetMapping("/updateById")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "personId",value = "personId",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "String",name = "userName",value = "userName",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "age",value = "age",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "sex",value = "sex",required = true)
            }
    )
    BaseResponse<Integer> updateById(Person person){
        return ResultTool.success(personService.updateByPrimaryKey(person));
    }

    @ApiOperation(value = "选择添加",notes = "选择添加")
    @GetMapping("/addSelective")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "personId",value = "personId",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "String",name = "userName",value = "userName"),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "age",value = "age"),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "sex",value = "sex")
            }
    )
    BaseResponse<Integer> addSelective(Person person){
        return ResultTool.success(personService.insertSelective(person));
    }

    @ApiOperation(value = "根据主键灵活修改", notes = "根据主键灵活修改")
    @GetMapping("/updateByIdSelective")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "personId",value = "personId",required = true),
                    @ApiImplicitParam(paramType = "query",dataType = "String",name = "userName",value = "userName"),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "age",value = "age"),
                    @ApiImplicitParam(paramType = "query",dataType = "Long",name = "sex",value = "sex")
            }
    )
    BaseResponse<Integer> updateByIdSelective(Person person){
        return ResultTool.success(personService.updateByPrimaryKeySelective(person));
    }

    @ApiOperation(value="查询人员列表",notes="查询人员列表")
    @GetMapping("/queryPerson")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNum",value = "pageNum"),
                    @ApiImplicitParam(name = "pageSize",value = "pageSize")
            }
    )
    PageResponse<List<Person>> queryPerson(@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "3")int pageSize){
        Page<Person> pData = personService.queryPersonList(pageNum, pageSize);
        return ResultTool.success(pData.getResult(),pData.getTotal());
    }

    @ApiOperation(value = "根据姓名查询人员", notes = "根据姓名查询人员")
    @GetMapping("/queryByName")
    @ApiImplicitParam(name = "userName", value = "userName")
    BaseResponse<List<Person>> queryByName(String userName){
        return ResultTool.success(personService.selectByName(userName));
    }
}
