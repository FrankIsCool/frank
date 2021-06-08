package com.sxmaps.mms.vo.resp;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespKafkaMessageVO {
	
	private String url;
	
	private String title;
	
	private String content;
	
	private List<String> users;

}
