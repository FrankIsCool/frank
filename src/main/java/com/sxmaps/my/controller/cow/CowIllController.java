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
@RequestMapping("/cow/ill")
@Api(value = "牛生病接口", tags = "牛生病接口")
public class CowIllController {
    /**
     * 牛增加生病信息接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛增加生病信息接口", value = "牛增加生病信息接口")
    public String cowIllCreate() {
        return "20";
    }
    /**
     * 牛生病信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛生病信息接口", value = "牛生病信息接口")
    public String cowIllInfo() {
        return "20";
    }
    /**
     * 牛生病信息列表接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛生病信息列表接口", value = "牛生病信息列表接口")
    public String cowIllList() {
        return "20";
    }
}
