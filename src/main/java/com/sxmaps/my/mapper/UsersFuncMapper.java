package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.UsersFunc;
import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersFuncMapper extends CommonMapper<UsersFunc> {

    List<RespFunctionsVO> getFunctions(@Param("userUid") Long userUid);

}