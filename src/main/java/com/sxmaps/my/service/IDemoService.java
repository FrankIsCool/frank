package com.sxmaps.mms.service;

import com.sxmaps.mms.exception.ApiException;
import com.sxmaps.mms.vo.req.ReqDemoVO;
import com.sxmaps.mms.vo.resp.RespDemoVO;

/**
 * demo
 * 
 * @author chendehua
 *
 */
public interface IDemoService {

	/**
	 * 模拟用户登录
	 * 
	 * @param reqDemoVO
	 * @return
	 * @throws ApiException
	 */
	RespDemoVO login(ReqDemoVO reqDemoVO) throws ApiException;

	/**
	 * 简单的demo
	 * 
	 * @param content
	 * @return
	 * @throws ApiException
	 */
	String sayHi(String content) throws ApiException;
}
