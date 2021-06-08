package com.sxmaps.my.service.impl;

import com.sxmaps.my.service.IResubmitService;
import com.sxmaps.my.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureOrder
public class ResubmitServiceImpl implements IResubmitService {


	@Autowired
	private final RedisUtils redisUtils;

	public ResubmitServiceImpl(RedisUtils redisUtils) {
		this.redisUtils = redisUtils;
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Object getResubmitMember(List<String> memberUids) {
		Map<String, Long> result = new HashMap<>();
		return result;
	}
}