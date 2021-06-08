package com.sxmaps.mms.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespCityVO {
	
	private String regionCode;
	
	private String regionName;
}
