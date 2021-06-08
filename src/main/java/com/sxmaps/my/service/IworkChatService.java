package com.sxmaps.mms.service;

import com.sxmaps.mms.vo.resp.RespKafkaMessageVO;

public interface IworkChatService {
	
	
	/**
	 * 推送消息到kafka
	 */
	void sendMessage(RespKafkaMessageVO respKafka);

}
