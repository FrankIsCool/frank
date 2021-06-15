package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.Login;
import com.sxmaps.my.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper extends CommonMapper<Login> {

    Login getLoginByUserUid(@Param("userUid") Long userUid);

    Login getLoginByToken(@Param("token") String token);

    List<Login> getLogins();

    List<String> getLoginByUserUids(@Param("userUids") List<Long> userUids);
}