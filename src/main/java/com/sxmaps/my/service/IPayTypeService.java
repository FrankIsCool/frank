package com.sxmaps.my.service;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.pay.ReqPayCollectVO;
import com.sxmaps.my.vo.req.pay.ReqPayListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeCreateVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.pay.RespPayCollectVO;
import com.sxmaps.my.vo.resp.pay.RespPayListVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeAllVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeListVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 类：种类
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IPayTypeService {
    /**
     * 新增类型
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer addPayType(ReqPayTypeCreateVO vo);
    /**
     * 所有类型
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    List<RespPayTypeAllVO> getPayTypeAll();
    /**
     * 类型列表
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespPayTypeListVO> payTypeList(ReqPayTypeListVO vo);
    /**
     * 支付记录列表
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespPayListVO> payList(ReqPayListVO vo);
    /**
     * 支付统计
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    RespPayCollectVO payCollect(ReqPayCollectVO vo);
}
