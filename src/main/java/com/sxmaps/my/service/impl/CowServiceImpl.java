package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.CowStateEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.CowMapper;
import com.sxmaps.my.mapper.KindMapper;
import com.sxmaps.my.mapper.WeightMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.model.Weight;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.utils.DateUtil;
import com.sxmaps.my.vo.req.cow.ReqCowCreateVO;
import com.sxmaps.my.vo.req.cow.ReqCowCreateWeightVO;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import com.sxmaps.my.vo.req.cow.ReqCowListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListWeigthVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 类：牛
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class CowServiceImpl implements ICowService {
    @Resource
    CowMapper cowMapper;
    @Resource
    WeightMapper weightMapper;
    @Resource
    KindMapper kindMapper;
    @Override
    public Integer cowDie(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo);
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowState(CowStateEnum.COWSTATEENUM_4.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowIll(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo);
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowState(CowStateEnum.COWSTATEENUM_3.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowFetation(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo);
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowState(CowStateEnum.COWSTATEENUM_2.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowNormal(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo);
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowState(CowStateEnum.COWSTATEENUM_1.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowSale(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo);
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowState(CowStateEnum.COWSTATEENUM_5.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowCreate(ReqCowCreateVO vo) {
        Cow cow = cowMapper.getCowByNum(vo.getCowNum(),vo.getFarmersUid());
        if (null != cow) {
            throw new ApiException(ApiExceptionEnum.COWNUM);
        }
        Kind kind = kindMapper.selectByPrimaryKey(vo.getCowKindUid());
        if(null == kind){
            throw new ApiException(ApiExceptionEnum.COWNUM);
        }
        cow = new Cow();
        cow.setNum(vo.getCowNum());
        cow.setWeight(vo.getWeigth().toString());
        cow.setCreateTime(new Date());
        cow.setUpdateTime(new Date());
        cow.setCowState(CowStateEnum.COWSTATEENUM_1.getState().byteValue());
        cow.setSex(vo.getSex().byteValue());
        cow.setDel(StateEnum.NOTDEL.getState().byteValue());
        cow.setFarmersUid(vo.getFarmersUid());
        cow.setBirthTime(vo.getCowBirth());
        cow.setFaNum(vo.getCowFaNum());
        cow.setKindUid(vo.getCowKindUid());
        cow.setKind(kind.getKindName());
        cow.setMonNum(vo.getCowMonNum());
        cow.setLairageTime(new Date());
        return cowMapper.insert(cow);
    }

    @Override
    public PageInfo<RespCowListVO> cowList(ReqCowListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<RespCowListVO> cows = cowMapper.getCows(vo);
        List<Long> cowUids = cows.stream().map(RespCowListVO::getCowUid).collect(Collectors.toList());
        if(null == cowUids || cowUids.size()<1){
            return new PageInfo<>(cows);
        }
        List<RespCowListWeigthVO> weights = weightMapper.getWeights(cowUids);
        Map<Long, List<RespCowListWeigthVO>> weightMap = weights.stream().collect(Collectors.groupingBy(RespCowListWeigthVO::getCowUid));
        cows.stream().forEach(cow->{
            if(weightMap.containsKey(cow.getCowUid())){
                cow.setWeigthVOS(weightMap.get(cow.getCowUid()));
            }
        });
        return new PageInfo<>(cows);
    }

    @Override
    @Transactional
    public Integer cowCreateWeight(ReqCowCreateWeightVO vo) {
        Cow cow = cowMapper.selectByPrimaryKey(vo.getCowUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        if (cow.getFarmersUid()!=vo.getFarmersUid()) {
            throw new ApiException(ApiExceptionEnum.NOTGETCOW);
        }
        if (cow.getCowState().intValue()==CowStateEnum.COWSTATEENUM_4.getState()) {
            throw new ApiException(ApiExceptionEnum.COEDIE);
        }
        if (cow.getCowState().intValue()==CowStateEnum.COWSTATEENUM_5.getState()) {
            throw new ApiException(ApiExceptionEnum.COEDIE);
        }
        cow.setWeight(vo.getWeigth().toString());
        cow.setUpdateTime(new Date());
        cowMapper.updateByPrimaryKey(cow);
        Weight weight = new Weight();
        weight.setWeight(vo.getWeigth());
        weight.setCowUid(cow.getUid());
        weight.setCreateTime(new Date());
        weight.setCreateTime(vo.getMeasureTime());
        return weightMapper.insert(weight);
    }
}
