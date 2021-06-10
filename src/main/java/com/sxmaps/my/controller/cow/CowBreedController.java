package com.sxmaps.my.controller.cow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：牛繁殖接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/cow")
@Api(value = "牛繁殖接口", tags = "牛繁殖接口")
public class CowBreedController {
    /**
     * 牛繁殖接口
     * @return
     */
    @PostMapping(value = "breed",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛繁殖接口", value = "牛繁殖接口")
    public String cowBreed() {
        return "20";
    }
    /**
     * 牛繁殖信息修改接口
     * @return
     */
    @PostMapping(value = "breed/update",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛繁殖信息修改接口", value = "牛繁殖信息修改接口")
    public String cowBreedUpdate() {
        return "20";
    }
    /**
     * 繁殖记录列表接口
     * @return
     */
    @PostMapping(value = "breed/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "繁殖记录列表接口", value = "繁殖记录列表接口")
    public String cowBreedList() {
        return "20";
    }
}
