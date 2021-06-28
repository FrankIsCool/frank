package com.sxmaps.my.controller.function;

import com.sxmaps.my.service.IFunctionService;
import com.sxmaps.my.vo.req.function.ReqFunctionCreateVO;
import com.sxmaps.my.vo.req.function.ReqFunctionDelVO;
import com.sxmaps.my.vo.resp.function.RespFunctionTreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类：功能接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/19
 */
@RestController
@RequestMapping("/check/function")
@Api(value = "功能接口", tags = "功能接口")
public class FunctionController {

    @Resource
    IFunctionService functionService;
    /**
     * 获取功能树
     *
     * @return
     */
    @PostMapping(value = "tree", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "获取功能树", value = "获取功能树", response = RespFunctionTreeVO.class)
    @ApiImplicitParam(name = "vo", value = "获取功能树")
    public RespFunctionTreeVO getAllFunctions() {
        return functionService.getAllFunctions();
    }
    /**
     * 增加功能
     *
     * @return
     */
    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "增加功能", value = "增加功能", response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "增加功能",dataType = "ReqFunctionCreateVO")
    public Integer addFunctions(@RequestBody @Validated ReqFunctionCreateVO vo) {
        return functionService.addFunctions(vo);
    }
    /**
     * 删除功能
     *
     * @return
     */
    @PostMapping(value = "del", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除功能", value = "删除功能", response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "增加功能",dataType = "ReqFunctionDelVO")
    public Integer delFunctions(@RequestBody @Validated ReqFunctionDelVO vo) {
        return functionService.delFunctions(vo);
    }
}

