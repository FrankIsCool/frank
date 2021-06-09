/**
 *
 */
package com.sxmaps.my.controller;

import com.sxmaps.my.common.JsonMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
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

//    @Autowired
//	private IStudentService iStudentService;

    /**
     * 测试
     *
     * @param stuVO
     * @return
     */
    @PostMapping(value = "test",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "查询联系学员的记录信息", value = "查询联系学员的记录信息")
    public String qryStudent() {
        return "20";
    }

}
