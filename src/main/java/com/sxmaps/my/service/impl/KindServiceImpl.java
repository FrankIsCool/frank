package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.QueryInfoVO;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.CowStateEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.CowMapper;
import com.sxmaps.my.mapper.KindMapper;
import com.sxmaps.my.mapper.WeightMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.model.Login;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.service.IKindService;
import com.sxmaps.my.vo.req.cow.ReqCowCreateVO;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.req.cow.ReqCowListVO;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListWeigthVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类：种类
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class KindServiceImpl implements IKindService {
    @Resource
    KindMapper kindMapper;

    @Override
    public PageInfo<RespKindVO> getKinds(ReqKindListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(kindMapper.getKinds(vo));
    }

    @Override
    public Integer addKinds(ReqKindCreateVO vo) {
        Kind kind = new Kind();
        kind.setKindName(vo.getKindName());
        kind.setCreateTime(new Date());
        return kindMapper.insert(kind);
    }

    @Override
    public List<RespKindAllVO> getKindsAll() {
        return kindMapper.getKindsAll();
    }
}
