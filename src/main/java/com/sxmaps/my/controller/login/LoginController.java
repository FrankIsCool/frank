/**
 *
 */
package com.sxmaps.my.controller.login;

import com.sxmaps.my.service.ILoginService;
import com.sxmaps.my.vo.req.login.ReqLoginVO;
import com.sxmaps.my.vo.resp.login.RespLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 类：登录相关信息
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/9
 */
@RestController
@RequestMapping("/login")
@Api(value = "登录相关接口", tags = "登录相关接口")
public class LoginController {

    @Autowired
    ILoginService loginService;
    /**
     * 登录接口
     * @return
     */
    @PostMapping(value = "logining",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "登录接口", value = "登录接口",response = RespLoginVO.class)
    @ApiImplicitParam(name = "vo", value = "登录接口", dataType = "ReqLoginVO")
    public RespLoginVO login(@RequestBody @Validated ReqLoginVO vo) {
        return loginService.login(vo);
    }
    /**
     * 退出接口
     * @return
     */
    @PostMapping(value = "out",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "退出接口", value = "退出接口",response = Integer.class)
    @ApiImplicitParam(name = "token", value = "登录令牌", dataType = "String")
    public Integer loginOut(@RequestHeader("token") String token) {
        return loginService.loginOut(token);
    }
}
