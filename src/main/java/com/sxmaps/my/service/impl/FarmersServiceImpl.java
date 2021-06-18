package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.mapper.FarmersMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.model.User;
import com.sxmaps.my.service.IFarmersService;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.utils.StringUtil;
import com.sxmaps.my.vo.req.farmers.*;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.resp.farmers.RespFarmersInfoVO;
import com.sxmaps.my.vo.resp.farmers.RespFarmersListVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class FarmersServiceImpl implements IFarmersService {

    @Resource
    FarmersMapper farmersMapper;
    @Resource
    IUserService userService;

    @Override
    @Transactional
    public Integer createFarmers(ReqFarmersCreateVO vo) {
        Farmers farmers = new Farmers();
        farmers.setCreateTime(new Date());
        farmers.setUpdateTime(new Date());
        farmers.setDel(StateEnum.NOTDEL.getState().byteValue());
        farmers.setFarmersName(vo.getFarmersName());
        farmers.setFarmersAddress(vo.getFarmersAddress());
        farmersMapper.insert(farmers);

        ReqUserCreateVO user = new ReqUserCreateVO();
        BeanUtils.copyProperties(vo,user);
        user.setFarmersUid(farmers.getUid());
        user.setUserType(UserTypeEnum.USERTYP_1.getState());
        return userService.createUser(user);
    }

    @Override
    @Transactional
    public Integer farmersCancel(ReqFarmersDelVO vo) {
        Farmers farmers = farmersMapper.selectByPrimaryKey(vo.getFarmersUid());
        farmers.setDel(StateEnum.DEL.getState().byteValue());
        farmers.setUpdateTime(new Date());
        farmersMapper.updateByPrimaryKey(farmers);
        return userService.delUsers(vo);
    }

    @Override
    public RespFarmersInfoVO getFarmersInfo(Long farmersUid) {
        Farmers farmers = farmersMapper.selectByPrimaryKey(farmersUid);
        RespFarmersInfoVO infoVO = new RespFarmersInfoVO();
        infoVO.setFarmersUid(farmers.getUid());
        infoVO.setFarmersName(farmers.getFarmersName());
        infoVO.setFarmersAddress(farmers.getFarmersAddress());
        infoVO.setFarmersCreateTime(farmers.getCreateTime());

        User farmersUser = userService.getFarmersUser(farmers.getUid());
        infoVO.setFarmersUserUid(farmersUser.getUid());
        infoVO.setFarmersUserName(farmersUser.getUserName());
        infoVO.setFarmersUserPhone(farmersUser.getPhone());
        return infoVO;
    }

    @Override
    public Integer farmersUpdate(ReqFarmersUpdateVO vo) {
        if(StringUtils.isEmpty(vo.getFarmersName()) && StringUtils.isEmpty(vo.getFarmerAddress())){
            return 1;
        }
        Farmers farmers = farmersMapper.selectByPrimaryKey(vo.getFarmersUid());
        farmers.setUpdateTime(new Date());
        if(!StringUtils.isEmpty(vo.getFarmerName())){
            farmers.setFarmersName(vo.getFarmerName());
        }
        if(!StringUtils.isEmpty(vo.getFarmerAddress())){
            farmers.setFarmersAddress(vo.getFarmerAddress());
        }
        if(null != vo.getFarmerCreateTime()){
            farmers.setCreateTime(vo.getFarmerCreateTime());
        }
        return farmersMapper.updateByPrimaryKey(farmers);
    }

    @Override
    public PageInfo<RespFarmersListVO> getFarmersList(ReqFarmersListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(farmersMapper.getFarmersList(vo));
    }
}
