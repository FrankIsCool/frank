package com.sxmaps.my.controller.farmers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：场主接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/farmers")
@Api(value = "场主接口", tags = "场主接口")
public class FarmersController {

    /**
     * 场主基本信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "场主基本信息接口", value = "场主基本信息接口")
    public String farmersInfo() {
        return "20";
    }
    /**
     * 修改场主基本信息接口
     * @return
     */
    @PostMapping(value = "update/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改场主基本信息接口", value = "修改场主基本信息接口")
    public String farmersUpdateInfo() {
        return "20";
    }
    /**
     * 场主列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "场主列表接口", value = "场主列表接口")
    public String farmersList() {
        return "20";
    }
    /**
     * 新增场主接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增场主接口", value = "新增场主接口")
    public String farmersCreate() {
        return "20";
    }
    /**
     * 注销场主接口
     * @return
     */
    @PostMapping(value = "cancel",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "注销场主接口", value = "注销场主接口")
    public String farmersCancel() {
        return "20";
    }
}
