package com.sxmaps.my.service;

import com.sxmaps.my.model.Login;
import com.sxmaps.my.vo.req.login.ReqLoginVO;
import com.sxmaps.my.vo.resp.login.RespLoginVO;

import java.util.List;

/**
 * 类：登录
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface ILoginService {
    /**
     * 登录
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    RespLoginVO login(ReqLoginVO vo);
    /**
     * 退出
     * @param token
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer loginOut(String token);

    /**
     * 获取所有登录的用户
     * @param token
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    List<Login> getLogins();
}
