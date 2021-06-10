package com.sxmaps.my.mapper;

import com.sxmaps.my.common.CommonMapper;
import com.sxmaps.my.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends CommonMapper<User> {

    User getUserByPhone(@Param("phone") String phone);

}