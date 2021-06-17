package com.sxmaps.my.service;

import com.github.pagehelper.PageInfo;
import com.sxmaps.my.model.User;
import com.sxmaps.my.vo.req.farmers.ReqFarmersDelVO;
import com.sxmaps.my.vo.req.user.ReqUserCreateVO;
import com.sxmaps.my.vo.req.user.ReqUserListVO;
import com.sxmaps.my.vo.req.user.ReqUsersUidVO;
import com.sxmaps.my.vo.resp.user.RespUserVO;

/**
 * 类：用户
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
public interface IUserService {

    /**
     * 创建用户信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer createUser(ReqUserCreateVO vo);
    /**
     * 注销牧场-删除用户信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer delUsers(ReqFarmersDelVO vo);
    /**
     * 恢复子账户
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer recoverUser(ReqUsersUidVO vo);
    /**
     * 注销子账户信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    Integer delUser(ReqUsersUidVO vo);
    /**
     * 获取牧场主信息
     * @param farmersUid
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    User getFarmersUser(Long farmersUid);
    /**
     * 账户列表信息
     * @param vo
     * @return
     * @author frank(付帅)
     * @date 2021/6/10
     **/
    PageInfo<RespUserVO> getFarmersUsers(ReqUserListVO vo);
}
