package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.mapper.EarningsMapper;
import com.sxmaps.my.mapper.EarningsTypeMapper;
import com.sxmaps.my.model.EarningsType;
import com.sxmaps.my.service.IEarningsService;
import com.sxmaps.my.vo.req.earnings.ReqEarningsListVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeCreateVO;
import com.sxmaps.my.vo.req.earnings.ReqEarningsTypeListVO;
import com.sxmaps.my.vo.resp.earnings.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 类：收益
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class EarningsServiceImpl implements IEarningsService {

    @Resource
    EarningsTypeMapper earningsTypeMapper;
    @Resource
    EarningsMapper earningsMapper;
    @Override
    public Integer addType(ReqEarningsTypeCreateVO vo) {
        EarningsType payType = new EarningsType();
        payType.setEarningsName(vo.getEarningsName());
        payType.setCreateTime(new Date());
        return earningsTypeMapper.insert(payType);
    }

    @Override
    public List<RespEarningsTypeAllVO> getTypeAll() {
        return earningsTypeMapper.getTypeAll();
    }

    @Override
    public PageInfo<RespEarningsTypeListVO> typeList(ReqEarningsTypeListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(earningsTypeMapper.getTypes(vo));
    }

    @Override
    public PageInfo<RespEarningsListVO> payList(ReqEarningsListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(earningsMapper.getEarnings(vo));
    }

    @Override
    public RespEarningsCollectVO payCollect(UserInfoVo vo) {
        List<RespEarningsTypeAllVO> payTypesUids = earningsTypeMapper.getTypeAll();

        List<RespEarningsCollectInfoVO> respPayCollectVOS = earningsMapper.earningsCollect(payTypesUids.stream().map(RespEarningsTypeAllVO::getEarningsTypeUid).collect(Collectors.toList()),vo.getFarmersUid());

        Map<Long, RespEarningsCollectInfoVO> respPayCollectVOMap = respPayCollectVOS.stream().collect(Collectors.toMap(RespEarningsCollectInfoVO::getEarningsUid,Function.identity()));

        List<RespEarningsCollectInfoVO> infoVOS = new ArrayList<>();
        payTypesUids.stream().forEach(payType -> {
            if(respPayCollectVOMap.containsKey(payType.getEarningsTypeUid())){
                RespEarningsCollectInfoVO infoVO = respPayCollectVOMap.get(payType.getEarningsTypeUid());
                infoVO.setEarningsName(payType.getEarningsName());
                infoVOS.add(infoVO);
            }
            if(!respPayCollectVOMap.containsKey(payType.getEarningsTypeUid())){
                RespEarningsCollectInfoVO infoVO = new RespEarningsCollectInfoVO();
                infoVO.setEarningsName(payType.getEarningsName());
                infoVO.setEarningsUid(payType.getEarningsTypeUid());
                infoVO.setEarningsAmount(BigDecimal.ZERO);
                infoVOS.add(infoVO);
            }
        });
        RespEarningsCollectVO respPayCollectVO = new RespEarningsCollectVO();
        respPayCollectVO.setInfo(infoVOS);
        return respPayCollectVO;
    }
}
