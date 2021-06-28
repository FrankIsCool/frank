package com.sxmaps.my.service;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.vo.req.earnings.ReqEarningsListVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeCreateVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsCollectVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsListVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeAllVO;
import com.sxmaps.my.vo.resp.earnings.RespEarningsTypeListVO;

import java.util.List;

/**
 * 类：收益
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IEarningsService {
    /**
     * 新增类型
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer addType(ReqEarningsTypeCreateVO vo);
    /**
     * 所有类型
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    List<RespEarningsTypeAllVO> getTypeAll();
    /**
     * 类型列表
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespEarningsTypeListVO> typeList(ReqEarningsTypeListVO vo);
    /**
     * 支付记录列表
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespEarningsListVO> payList(ReqEarningsListVO vo);
    /**
     * 支付统计
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    RespEarningsCollectVO payCollect(UserInfoVo vo);
}
