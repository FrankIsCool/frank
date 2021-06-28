package com.sxmaps.my.controller.pay;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.service.IEarningsService;
import com.sxmaps.my.vo.req.earnings.ReqEarningsListVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeCreateVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsCollectVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeAllVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeListVO;
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
 * 类：收益接口
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/check/earnings")
@Api(value = "收益接口", tags = "收益接口")
public class EarningsController {

    @Resource
    IEarningsService earningsService;
    /**
     * 新增收益类型接口
     * @return
     */
    @PostMapping(value = "/type/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "新增收益类型接口", value = "新增收益类型接口",response = Integer.class)
    @ApiImplicitParam(name = "vo", value = "新增收益类型接口", dataType = "ReqEarningsTypeCreateVO")
    public Integer typeCreate(@RequestBody @Validated ReqEarningsTypeCreateVO vo) {
        return earningsService.addType(vo);
    }
    /**
     * 所有收益类型接口
     * @return
     */
    @PostMapping(value = "/type/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "所有收益类型接口", value = "所有收益类型接口",response = RespEarningsTypeAllVO.class)
    @ApiImplicitParam(name = "vo", value = "新增收益类型接口")
    public List<RespEarningsTypeAllVO> typeAll() {
        return earningsService.getTypeAll();
    }
    /**
     * 收益类型列表接口
     * @return
     */
    @PostMapping(value = "/type/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "收益类型列表接口", value = "收益类型列表接口",response = RespEarningsTypeListVO.class)
    @ApiImplicitParam(name = "vo", value = "收益类型列表接口",dataType = "ReqEarningsTypeListVO")
    public PageInfo<RespEarningsTypeListVO> typeList(@RequestBody @Validated ReqEarningsTypeListVO vo) {
        return earningsService.typeList(vo);
    }
    /**
     * 收益记录列表接口
     * @return
     */
    @PostMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "收益记录列表接口", value = "收益记录列表接口",response = RespEarningsListVO.class)
    @ApiImplicitParam(name = "vo", value = "收益记录列表接口",dataType = "ReqEarningsListVO")
    public PageInfo<RespEarningsListVO> payList(@RequestBody @Validated ReqEarningsListVO vo) {
        return earningsService.payList(vo);
    }
    /**
     * 收益统计结果接口
     * @return
     */
    @PostMapping(value = "/collect",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "收益统计结果接口", value = "收益统计结果接口",response = RespEarningsCollectVO.class)
    @ApiImplicitParam(name = "vo", value = "收益统计结果接口",dataType = "UserInfoVo")
    public RespEarningsCollectVO payCollect(@RequestBody @Validated UserInfoVo vo) {
        return earningsService.payCollect(vo);
    }
}
