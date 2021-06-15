package com.sxmaps.my.service.impl;

import com.sxmaps.my.enums.ApiExceptionEnum;
import com.sxmaps.my.enums.CowStateEnum;
import com.sxmaps.my.exception.ApiException;
import com.sxmaps.my.mapper.CowMapper;
import com.sxmaps.my.model.Cow;
import com.sxmaps.my.service.ICowService;
import com.sxmaps.my.vo.req.cow.ReqCowIdVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}