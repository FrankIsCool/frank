package com.sxmaps.mms.service.impl;

import org.springframework.stereotype.Service;

import com.sxmaps.mms.exception.ApiException;
import com.sxmaps.mms.service.IDemoService;
import com.sxmaps.mms.vo.req.ReqDemoVO;
import com.sxmaps.mms.vo.resp.RespDemoVO;

@Service
public class DemoServiceImpl implements IDemoService {

	@Override
	public String sayHi(String content) throws ApiException {
		return "hello " + content;
	}

	@Override
	public RespDemoVO login(ReqDemoVO reqDemoVO) throws ApiException {
		RespDemoVO respDemoVO = new RespDemoVO();
		respDemoVO.setName("AAA");
		respDemoVO.setAge(23);
		respDemoVO.setSex("男");
		return respDemoVO;
	}

}
