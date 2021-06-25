package com.sxmaps.my.service;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.vo.req.cow.*;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import com.sxmaps.my.vo.resp.home.RespHomeCowVO;

/**
 * 类：牛
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface ICowService {
    /**
     * 牛死亡
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    RespHomeCowVO cowCount(UserInfoVo vo);
    /**
     * 牛死亡
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowDie(ReqCowIdVO vo);
    /**
     * 牛生病
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowIll(ReqCowIdVO vo);
    /**
     * 牛怀孕
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowFetation(ReqCowIdVO vo);
    /**
     * 牛分娩
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowChildbirth(ReqCowChildbirthVO vo);
    /**
     * 牛治愈
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowCure(ReqCowIdVO vo);
    /**
     * 牛售卖
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowSale(ReqCowSaleVO vo);
    /**
     * 牛创建
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowCreate(ReqCowCreateVO vo);
    /**
     * 牛列表
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespCowListVO> cowList(ReqCowListVO vo);
    /**
     * 牛增加体重记录
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer cowCreateWeight(ReqCowCreateWeightVO vo);
}
