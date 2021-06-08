package com.sxmaps.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.service.IworkChatService;
import com.sxmaps.mms.vo.resp.RespKafkaMessageVO;

@Service
public class WorkChatSerivceImpl implements IworkChatService{
	
	
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	/**
	 * 推送消息到kafka
	 */
	@Override
	public void sendMessage(RespKafkaMessageVO respKafka) {
		kafkaTemplate.send("workwechat-message",JSONObject.toJSONString(respKafka));
	}
}
