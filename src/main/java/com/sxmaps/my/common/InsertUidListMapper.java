package com.sxmaps.mms.common;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

public interface InsertUidListMapper<T> {
	
	/**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`uid`属性并且必须为自增列
     *
     * @author chengfan
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertListAndUid(List<T> recordList);
}
