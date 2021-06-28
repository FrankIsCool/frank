package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.mapper.PayMapper;
import com.sxmaps.my.mapper.PayTypeMapper;
import com.sxmaps.my.model.PayType;
import com.sxmaps.my.service.IPayTypeService;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.pay.ReqPayCollectVO;
import com.sxmaps.my.vo.req.pay.ReqPayListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeCreateVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.pay.*;
import io.swagger.annotations.ApiModelProperty;
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
 * 类：支付分类
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class PayTypeServiceImpl implements IPayTypeService {

    @Resource
    PayTypeMapper payTypeMapper;
    @Resource
    PayMapper payMapper;
    @Override
    public Integer addPayType(ReqPayTypeCreateVO vo) {
        PayType payType = new PayType();
        payType.setPayType(vo.getPayType().byteValue());
        payType.setPayName(vo.getPayName());
        payType.setCreateTime(new Date());
        return payTypeMapper.insert(payType);
    }

    @Override
    public List<RespPayTypeAllVO> getPayTypeAll() {
        return payTypeMapper.getPayTypeAll();
    }

    @Override
    public PageInfo<RespPayTypeListVO> payTypeList(ReqPayTypeListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(payTypeMapper.getPayTypes(vo));
    }

    @Override
    public PageInfo<RespPayListVO> payList(ReqPayListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(payMapper.getPays(vo));
    }

    @Override
    public RespPayCollectVO payCollect(ReqPayCollectVO vo) {
        List<RespPayTypeAllVO> payTypesUids = payTypeMapper.getPayTypesByType(vo.getPayType());

        List<RespPayCollectInfoVO> respPayCollectVOS = payMapper.payCollect(payTypesUids.stream().map(RespPayTypeAllVO::getPayTypeUid).collect(Collectors.toList()),vo.getFarmersUid());

        Map<Long, RespPayCollectInfoVO> respPayCollectVOMap = respPayCollectVOS.stream().collect(Collectors.toMap(RespPayCollectInfoVO::getPayUid,Function.identity()));

        List<RespPayCollectInfoVO> infoVOS = new ArrayList<>();
        payTypesUids.stream().forEach(payType -> {
            if(respPayCollectVOMap.containsKey(payType.getPayTypeUid())){
                RespPayCollectInfoVO infoVO = respPayCollectVOMap.get(payType.getPayTypeUid());
                infoVO.setPayName(payType.getPayName());
                infoVOS.add(infoVO);
            }
            if(!respPayCollectVOMap.containsKey(payType.getPayTypeUid())){
                RespPayCollectInfoVO infoVO = new RespPayCollectInfoVO();
                infoVO.setPayName(payType.getPayName());
                infoVO.setPayUid(payType.getPayTypeUid());
                infoVO.setPayAmount(BigDecimal.ZERO);
                infoVOS.add(infoVO);
            }
        });
        RespPayCollectVO respPayCollectVO = new RespPayCollectVO();
        respPayCollectVO.setInfo(infoVOS);
        return respPayCollectVO;
    }
}
