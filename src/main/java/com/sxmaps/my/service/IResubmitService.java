package com.sxmaps.my.service;

import java.util.List;

public interface IResubmitService {

	/****
	 * 判断学员是否转续报
	 * @param memberUids
	 * @return
	 */
	public Object getResubmitMember(List<String> memberUids);
}
