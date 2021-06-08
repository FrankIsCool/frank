package com.sxmaps.mms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxmaps.mms.client.AuthenticationClient;
import com.sxmaps.mms.exception.MmsBizException;
import com.sxmaps.mms.mapper.OrdersMemberPropMapper;
import com.sxmaps.mms.model.JsonMessage;
import com.sxmaps.mms.model.OrdersMemberProp;
import com.sxmaps.mms.service.IPersonnelService;
import com.sxmaps.mms.utils.ValidatorUtil;
import com.sxmaps.mms.vo.req.DeptIdVO;
import com.sxmaps.mms.vo.req.ReqOrderTypeVO;
import com.sxmaps.mms.vo.req.ReqPersonnelVO;
import com.sxmaps.mms.vo.req.ReqQryOrdersByDeptIdVO;
import com.sxmaps.mms.vo.req.UserIdVO;
import com.sxmaps.mms.vo.resp.RespQryOrdersByDeptIdVO;
import com.sxmaps.mms.vo.resp.RespUserVO;

/**
 * 
 * @author gongqingzhuan
 *
 * @data 
 */
@Service
public class PersonnelServiceImpl implements IPersonnelService {
	@Autowired
	private OrdersMemberPropMapper memberPropMapper;
	@Autowired
	private AuthenticationClient orgStructureClient;

	/**
	 * 根据orderItemId获取人员信息
	 * 
	 * @param personnelVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RespUserVO> queryUserListByUserId(ReqPersonnelVO personnelVO) throws Exception {
		OrdersMemberProp prop = new OrdersMemberProp();
		prop.setOrderItemId(personnelVO.getOrderItemId());
		OrdersMemberProp memberProp = memberPropMapper.selectOne(prop);
		if (null == memberProp) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查orderItemId是否正确");
		}
		// 根据订单ID查询人员信息
		Map<String, String> ordersMeberVO = memberPropMapper.qryOrderItemIdByperson(personnelVO);
		List<UserIdVO> userIds = new ArrayList<UserIdVO>();
		if (ValidatorUtil.isEmpty(ordersMeberVO)) {
			throw new MmsBizException(MmsBizException.DB_CODE, "该学员没有隶属信息");
		}
		// 迭代map
		for (String key : ordersMeberVO.keySet()) {
			UserIdVO userIdVO = new UserIdVO();
			userIdVO.setUserId(ordersMeberVO.get(key));
			userIds.add(userIdVO);
		}
		// 调用人员信息的接口
		JsonMessage result = orgStructureClient.queryUserListByUserIds(userIds);
		if (null == result || null == result.getData()) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "调用auth服务异常,获取人员组织架构信息失败");
		}
		List<RespUserVO> list = JSON.parseArray(JSONObject.toJSONString(result.getData()), RespUserVO.class);
		return list;
	}

	/**
	 * 根据ordersUid获取人员信息
	 * 
	 * @param orderTypeVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RespUserVO> queryUserListByOrderId(ReqOrderTypeVO orderTypeVO) throws Exception {
		// 查询这条数据是否存在
		int qryCountByUid = memberPropMapper.qryCountByUid(orderTypeVO.getUid());
		if (qryCountByUid <= 0) {
			throw new MmsBizException(MmsBizException.DB_CODE, "操作失败，请检查ordersUid是否正确");
		}
		// 获取咨询老师
		Map<String, String> mapOrderVO = memberPropMapper.qryOrderUidByperson(orderTypeVO);
		List<UserIdVO> userIds = new ArrayList<UserIdVO>();
		if (ValidatorUtil.isEmpty(mapOrderVO)) {
			throw new MmsBizException(MmsBizException.DB_CODE, "该学员没有隶属信息");
		}
		// 迭代map
		for (String key : mapOrderVO.keySet()) {
			UserIdVO userIdVO = new UserIdVO();
			userIdVO.setUserId(mapOrderVO.get(key));
			userIds.add(userIdVO);
		}
		// 调用人员信息的接口
		JsonMessage result = orgStructureClient.queryUserListByUserIds(userIds);
		if (null == result || null == result.getData()) {
			throw new MmsBizException(MmsBizException.BIZ_CODE, "调用auth服务异常,获取人员组织架构信息失败");
		}
		List<RespUserVO> list = JSON.parseArray(JSONObject.toJSONString(result.getData()), RespUserVO.class);
		return list;
	}

	@Override
	public List<RespQryOrdersByDeptIdVO> qryOrdersByDeptIdVO(ReqQryOrdersByDeptIdVO req) throws Exception {
		List<String> siteSnList = new ArrayList<>();
		siteSnList.add("530001");
		siteSnList.add("3200666");
		siteSnList.add("h-3301xl");
		siteSnList.add("h-3302xl");
		siteSnList.add("h-zhxl");
		siteSnList.add("h-zsxl");
		siteSnList.add("h-hzxl");
		siteSnList.add("h-fsxl");
		siteSnList.add("h-dgxl");
		siteSnList.add("h-szxl-wz");
		siteSnList.add("44000001");
		siteSnList.add("4403666");
		siteSnList.add("4403777");
		siteSnList.add("cxxmzy2019");
		siteSnList.add("55062");
		siteSnList.add("77008800");
		siteSnList.add("h-fzxl");
		siteSnList.add("h-xmxl");
		siteSnList.add("h-qzxl");
		siteSnList.add("h-cdxl");
		siteSnList.add("h-cqxl");
		siteSnList.add("330666");
		siteSnList.add("h-szxl");
		siteSnList.add("20290");
		siteSnList.add("20029");
		siteSnList.add("20028");
		siteSnList.add("3100666");
		siteSnList.add("ahzy");
		siteSnList.add("xbzy");
		siteSnList.add("gszy");
		siteSnList.add("30233");
		siteSnList.add("88886666");
		siteSnList.add("88889999");
		siteSnList.add("53535353");
		siteSnList.add("66111661");
		siteSnList.add("77218061");
		siteSnList.add("sxy10086");
		siteSnList.add("test001");
		DeptIdVO dept = new DeptIdVO();
		dept.setDeptId(req.getDeptId());
		JsonMessage deptList = orgStructureClient.getDeptBydeptId(dept);
		if(deptList == null || deptList.getCode() != 200) {
			throw new MmsBizException(500, "查询部门列表异常,请稍后再试");
		}
		req.setDeptList(deptList.getData().toString());
		List<RespQryOrdersByDeptIdVO> resp = memberPropMapper.qryOrdersByDeptIdVO(req);
		for(RespQryOrdersByDeptIdVO order:resp) {
			if(order.getIsTouch().equals("2")) {
				order.setCate(2);
			}else if(siteSnList.stream().anyMatch(siteSn -> siteSn.equals(order.getSiteSn()))) {
				order.setCate(1);
			}else {
				order.setCate(3);
			}
		}
		return resp;
	}

}