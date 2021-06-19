package com.sxmaps.my.controller.cow;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.QueryInfoVO;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.service.IKindService;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import io.swagger.annotations.Api;
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
 * 类：牛生病接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@Api(value = "牛种类接口", tags = "牛种类接口")
public class CowKindController {
    @Resource
    IKindService kindService;
    /**
     * 新增牛品种接口
     * @return
     */
    @PostMapping(value = "/check/kind/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增牛品种接口", value = "新增牛品种接口")
    public Integer cowKindCreate(@RequestBody @Validated ReqKindCreateVO vo) {
        return kindService.addKinds(vo);
    }
    /**
     * 牛品种信息接口
     * @return
     */
    @PostMapping(value = "/check/kind/info",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛品种信息接口", value = "牛品种信息接口")
    public String cowKindInfo() {
        return "20";
    }
    /**
     * 牛品种列表接口
     * @return
     */
    @PostMapping(value = "/check/kind/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "牛品种列表接口", value = "牛品种列表接口")
    public PageInfo<RespKindVO> cowKindList(@RequestBody @Validated ReqKindListVO vo) {
        return kindService.getKinds(vo);
    }
    /**
     * 所有牛品种接口
     * @return
     */
    @PostMapping(value = "/check/kind/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "所有牛品种接口", value = "所有牛品种接口")
    public List<RespKindAllVO> cowKindAll() {
        return kindService.getKindsAll();
    }
    /**
     * 删除牛品种接口
     * @return
     */
    @PostMapping(value = "/check/kind/del",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除牛品种接口", value = "删除牛品种接口")
    public String cowKindDel() {
        return "20";
    }
}
