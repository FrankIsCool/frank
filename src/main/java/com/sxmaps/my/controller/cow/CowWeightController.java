package com.sxmaps.my.controller.cow;

import com.sxmaps.my.vo.req.cow.ReqCowCreateWeightVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类：牛体重信息接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/check/cow/weight")
@Api(value = "牛体重信息接口", tags = "牛体重信息接口")
public class CowWeightController {
    /**
     * 牛体重列表信息接口
     * @return
     */
    @PostMapping(value = "list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛体重列表信息接口", value = "牛体重列表信息接口")
    public String cowWeightList() {
        return "20";
    }
    /**
     * 新增牛基本信息接口
     * @return
     */
    @PostMapping(value = "create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牛体重信息接口", value = "新增牛体重信息接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增牛体重信息接口参数", dataType = "ReqCowCreateWeightVO")
    public Integer cowWeightCreate(@RequestBody @Validated ReqCowCreateWeightVO vo) {
        return 1;
    }
    /**
     * 新增牛基本信息接口
     * @return
     */
    @PostMapping(value = "info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛体重信息接口", value = "牛体重信息接口")
    public String cowWeightInfo() {
        return "20";
    }
    /**
     * 修改牛基本信息接口
     * @return
     */
    @PostMapping(value = "update/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "修改牛体重信息接口", value = "修改牛体重信息接口")
    public String cowWeightUpdateInfo() {
        return "20";
    }
}
