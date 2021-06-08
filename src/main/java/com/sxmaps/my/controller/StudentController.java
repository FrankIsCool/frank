/**
 *
 */
package com.sxmaps.my.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gongqingzhuan
 *
 * @data 2018年5月2日
 */
@RestController
@RequestMapping("/user")
@Api(value = "联系学员记录管理", tags = "联系学员记录管理")
public class StudentController {

    @Autowired
//	private IStudentService iStudentService;

    /**
     * 查询联系学员的记录信息
     *
     * @param stuVO
     * @return
     */
    @PostMapping(value = "qryStudent")
    @ApiOperation(notes = "查询联系学员的记录信息", value = "查询联系学员的记录信息", response = Object.class)
    public Object qryStudent() {
        return null;

    }

}
