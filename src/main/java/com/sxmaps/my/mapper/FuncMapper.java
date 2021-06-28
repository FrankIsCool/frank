package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Func;
import com.sxmaps.my.vo.resp.function.RespFunctionTreeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FuncMapper extends CommonMapper<Func> {

    List<RespFunctionTreeVO> getFunctionsOrPage(@Param("fatherUid") Long fatherUid,@Param("functionType") Integer functionType);

    RespFunctionTreeVO getSystem(@Param("functionName") String functionName,@Param("functionType") Integer functionType);

}