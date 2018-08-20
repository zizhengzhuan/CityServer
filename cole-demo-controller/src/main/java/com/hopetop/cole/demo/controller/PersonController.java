package com.hopetop.cole.demo.controller;

import com.github.pagehelper.Page;
import com.hopetop.cole.common.response.PageResponse;
import com.hopetop.cole.common.tool.ResultTool;
import com.hopetop.cole.common.tool.ServiceHelper;
import com.hopetop.cole.demo.model.Person;
import com.hopetop.cole.demo.service.impl.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类的描述
 *
 * @author: kunhour
 * @time: 2018/6/25 15:06
 */
@RestController
@RequestMapping("/api/v1/person")
@Api(value = "人员Controller")
@Slf4j
public class PersonController {
    @Autowired
    PersonServiceImpl personService;
    @Autowired
    ServiceHelper helper;

    @ApiOperation(value="查询人员列表",notes="查询人员列表")
    @GetMapping("queryPerson")
    PageResponse<List<Person>> queryPerson(){
        System.out.println(helper.getBasePath());
        Page<Person> pData = personService.queryPersonList();
        return ResultTool.success(pData.getResult(),pData.getTotal());
    }
}
