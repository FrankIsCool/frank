package com.sxmaps.my.service.impl;

import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.enums.UserTypeEnum;
import com.sxmaps.my.mapper.FarmersMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.service.IFarmersService;
import com.sxmaps.my.service.IUserService;
import com.sxmaps.my.vo.req.farmers.ReqFarmersCreateVO;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
    public Integer farmersCancel(ReqFarmersDelVO vo) {
        Farmers farmers = farmersMapper.selectByPrimaryKey(vo.getFarmersUid());
        farmers.setDel(StateEnum.DEL.getState().byteValue());
        farmers.setUpdateTime(new Date());
        farmersMapper.updateByPrimaryKey(farmers);
        return userService.delUsers(vo);
    }
}
