package com.sxmaps.my.service;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.QueryInfoVO;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.model.Login;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.login.ReqLoginVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.login.RespLoginVO;

import java.util.List;

/**
 * 类：种类
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IKindService {
    /**
     * 种类列表
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespKindVO> getKinds(ReqKindListVO vo);
    /**
     * 新增种类
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer addKinds(ReqKindCreateVO vo);
    /**
     * 所有种类
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    List<RespKindAllVO> getKindsAll();
}
