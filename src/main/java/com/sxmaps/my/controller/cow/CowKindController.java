package com.sxmaps.my.controller.cow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：牛生病接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/check/cow/kind")
@Api(value = "牛种类接口", tags = "牛种类接口")
public class CowKindController {
    /**
     * 新增牛品种接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牛品种接口", value = "新增牛品种接口")
    public String cowKindCreate() {
        return "20";
    }
    /**
     * 牛品种信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛品种信息接口", value = "牛品种信息接口")
    public String cowKindInfo() {
        return "20";
    }
    /**
     * 牛品种列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛品种列表接口", value = "牛品种列表接口")
    public String cowKindList() {
        return "20";
    }
    /**
     * 所有牛品种接口
     * @return
     */
    @PostMapping(value = "all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "所有牛品种接口", value = "所有牛品种接口")
    public String cowKindAll() {
        return "20";
    }
    /**
     * 删除牛品种接口
     * @return
     */
    @PostMapping(value = "del",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除牛品种接口", value = "删除牛品种接口")
    public String cowKindDel() {
        return "20";
    }
}
