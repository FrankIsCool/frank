package com.sxmaps.my.service;

import com.sxmaps.my.vo.req.farmers.ReqFarmersCreateVO;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;

/**
 * 类：牧场
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IFarmersService {

    /**
     * 创建牧场信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer createFarmers(ReqFarmersCreateVO vo);
    /**
     * 注销牧场信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer farmersCancel (ReqFarmersDelVO vo);
}
