package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.mapper.PayMapper;
import com.sxmaps.my.mapper.PayTypeMapper;
import com.sxmaps.my.model.PayType;
import com.sxmaps.my.service.IPayTypeService;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.req.pay.ReqPayListVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeCreateVO;
import com.sxmaps.my.vo.req.pay.ReqPayTypeListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import com.sxmaps.my.vo.resp.pay.RespPayListVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeAllVO;
import com.sxmaps.my.vo.resp.pay.RespPayTypeListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
        List<RespPayTypeAllVO> payTypesUids = payTypeMapper.getPayTypesUid(vo.getPayType());
        if(null == payTypesUids || payTypesUids.size()<1){
            return new PageInfo<>();
        }
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        vo.setPayTypeUids(payTypesUids.stream().map(RespPayTypeAllVO::getPayTypeUid).collect(Collectors.toList()));
        return new PageInfo<>(payMapper.getPays(vo));
    }
}
