package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.vo.req.cow.ReqCowListVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;

import java.util.List;

public interface KindMapper extends CommonMapper<Kind> {

    List<RespKindVO> getKinds(ReqKindListVO vo);

    List<RespKindAllVO> getKindsAll();

}