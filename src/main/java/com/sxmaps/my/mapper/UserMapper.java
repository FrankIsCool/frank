package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.User;
import com.sxmaps.my.vo.req.user.ReqUserListVO;
import com.sxmaps.my.vo.resp.user.RespUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends CommonMapper<User> {
//  根据手机号获取用户信息
    User getUserByPhone(@Param("phone") String phone);
    //  牧场注销,删除所有用户
    Integer delUsers(@Param("farmersUid") Long farmersUid);
    //  获取牧场下所有用户
    List<User> getUsersByFarmersUid(@Param("farmersUid") Long farmersUid);
    //  获取牧场主信息
    User getFarmersUsersByFarmersUid(@Param("farmersUid") Long farmersUid);
    //  获取牧场下所有用户
    List<RespUserVO> getUsersListByFarmersUid(ReqUserListVO vo);
}