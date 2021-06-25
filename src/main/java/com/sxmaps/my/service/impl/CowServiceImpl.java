package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.common.UserInfoVo;
import com.sxmaps.my.enums.*;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.*;
import com.sxmaps.my.model.*;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.vo.req.cow.*;
import com.sxmaps.my.vo.resp.cow.RespCowListVO;
import com.sxmaps.my.vo.resp.cow.RespCowListWeigthVO;
import com.sxmaps.my.vo.resp.home.RespHomeCowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    EarningsMapper earningsMapper;
    @Resource
    EarningsTypeMapper earningsTypeMapper;
    @Resource
    CowIllLogMapper cowIllLogMapper;
    @Resource
    WeightMapper weightMapper;
    @Resource
    KindMapper kindMapper;

    @Override
    public RespHomeCowVO cowCount(UserInfoVo vo) {
        RespHomeCowVO cowVO = new RespHomeCowVO();
        cowVO.setCowCount(cowMapper.getCowAllCount(vo.getFarmersUid()));
        cowVO.setCowSaleCount(cowMapper.getCowLifeCount(CowLifeEnum.LIFE_3.getState(), vo.getFarmersUid()));
        cowVO.setCowDieCount(cowMapper.getCowLifeCount(CowLifeEnum.LIFE_2.getState(), vo.getFarmersUid()));
        cowVO.setCowFetationCount(cowMapper.getCowFetationCount(CowFetationEnum.FETATION_2.getState(), vo.getFarmersUid()));
        cowVO.setCowNormalCount(cowMapper.getCowNormalCount(vo.getFarmersUid()));
        cowVO.setCowIllCount(cowMapper.getCowIllCount(CowIllEnum.ILL_2.getState(), vo.getFarmersUid()));

        cowVO.setCowLivestockNum(cowMapper.getCowLivestockNum(vo.getFarmersUid()));
        cowVO.setCowManCount(cowMapper.getCowCountBySex(SexEnum.MAN.getState(), vo.getFarmersUid()));
        cowVO.setCowWomanCount(cowMapper.getCowCountBySex(SexEnum.WOMAN.getState(), vo.getFarmersUid()));
        return cowVO;
    }

    @Override
    public Integer cowDie(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowLife(CowLifeEnum.LIFE_2.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    @Transactional
    public Integer cowIll(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        CowIllLog log = new CowIllLog();
        log.setCowUid(cow.getUid());
        log.setCreateTime(new Date());
        log.setUpdateTime(new Date());
        log.setIllTime(new Date());
        cowIllLogMapper.insert(log);
        cow.setIllState(CowIllEnum.ILL_2.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }
    @Override
    @Transactional
    public Integer cowCure(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        CowIllLog illLog = cowIllLogMapper.getIllLog(cow.getUid());
        if (null == illLog) {
            throw new ApiException(ApiExceptionEnum.DB);
        }
        illLog.setCureTime(new Date());
        illLog.setUpdateTime(new Date());
        cowIllLogMapper.updateByPrimaryKey(illLog);
        cow.setIllState(CowIllEnum.ILL_1.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }
    @Override
    public Integer cowFetation(ReqCowIdVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setFetationState(CowFetationEnum.FETATION_2.getState().byteValue());
        cow.setUpdateTime(new Date());
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    @Transactional
    public Integer cowChildbirth(ReqCowChildbirthVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setFetationState(CowFetationEnum.FETATION_1.getState().byteValue());
        cow.setUpdateTime(new Date());
        ReqCowCreateVO cowCreateVO = new ReqCowCreateVO();
        BeanUtils.copyProperties(vo,cowCreateVO);
        cowCreateVO.setCowKindUid(cow.getKindUid());
        cowCreateVO.setCowBirth(new Date());
        cowCreateVO.setCowFaNum(vo.getCowFaNum());
        cowCreateVO.setCowMonNum(cow.getNum());
        cowCreateVO.setCowNum(vo.getCowNum());
        cowCreateVO.setSex(vo.getSex());
        cowCreateVO.setWeigth(vo.getWeigth());
        cowCreate(cowCreateVO);
        return cowMapper.updateByPrimaryKey(cow);
    }

    @Override
    public Integer cowSale(ReqCowSaleVO vo) {
        Cow cow = cowMapper.getCow(vo.getCowUid(),vo.getFarmersUid());
        if (null == cow) {
            throw new ApiException(ApiExceptionEnum.NOTCOW);
        }
        cow.setCowLife(CowLifeEnum.LIFE_3.getState().byteValue());
        cow.setUpdateTime(new Date());
        EarningsType earningsType = earningsTypeMapper.getEarningsTypeBySaleCow();
        Earnings earnings = new Earnings();
        earnings.setEarningsUid(earningsType.getUid());
        earnings.setCreateTime(new Date());
        earnings.setFarmersUid(vo.getFarmersUid());
        earnings.setAmount(vo.getSaleAmount());
        earningsMapper.insert(earnings);
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
        cow.setCowLife(CowLifeEnum.LIFE_1.getState().byteValue());
        cow.setIllState(CowIllEnum.ILL_1.getState().byteValue());
        cow.setFetationState(CowFetationEnum.FETATION_1.getState().byteValue());
        cow.setSex(vo.getSex().byteValue());
        cow.setDel(StateEnum.NOTDEL.getState().byteValue());
        cow.setFarmersUid(vo.getFarmersUid());
        cow.setBirthTime(vo.getCowBirth());
        cow.setFaNum(vo.getCowFaNum());
        cow.setKindUid(vo.getCowKindUid());
        cow.setKind(kind.getKindName());
        cow.setMonNum(vo.getCowMonNum());
        cow.setLairageTime(new Date());

        Weight weight = new Weight();
        weight.setWeight(vo.getWeigth());
        weight.setCowUid(cow.getUid());
        weight.setCreateTime(new Date());
        weightMapper.insert(weight);
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
        if (cow.getCowLife().intValue()== CowLifeEnum.LIFE_3.getState()) {
            throw new ApiException(ApiExceptionEnum.COWSALE);
        }
        if (cow.getCowLife().intValue()== CowLifeEnum.LIFE_2.getState()) {
            throw new ApiException(ApiExceptionEnum.COWDIE);
        }
        cow.setWeight(vo.getWeigth().toString());
        cow.setUpdateTime(new Date());
        cowMapper.updateByPrimaryKey(cow);
        Weight weight = new Weight();
        weight.setWeight(vo.getWeigth());
        weight.setCowUid(cow.getUid());
        weight.setCreateTime(vo.getMeasureTime());
        return weightMapper.insert(weight);
    }
}
