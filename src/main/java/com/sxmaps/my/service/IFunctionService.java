package com.sxmaps.my.service;

import com.sxmaps.my.vo.req.function.ReqFunctionCreateVO;
import com.sxmaps.my.vo.req.function.ReqFunctionDelVO;
import com.sxmaps.my.vo.resp.function.RespFunctionTreeVO;
import com.sxmaps.my.vo.resp.function.RespFunctionsVO;

import java.util.List;

/**
 * 类：功能
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IFunctionService {

    /**
     * 功能树结构
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    RespFunctionTreeVO getAllFunctions();
    /**
     * 新增功能
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer addFunctions(ReqFunctionCreateVO vo);
    /**
     * 删除功能
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer delFunctions(ReqFunctionDelVO vo);
    /**
     * 获取用户的功能
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    List<RespFunctionsVO> getFunctions(Long userUid);
}
