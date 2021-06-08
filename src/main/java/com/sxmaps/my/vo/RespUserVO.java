package com.sxmaps.mms.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name = "auth_user")
@ApiModel(description = "用户返回vo")
public class RespUserVO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    @Column(name = "dept_id")
    private String deptId;

    @ApiModelProperty("升学部门数据查看权限Id")
    @Column(name = "dept_id_sx")
    private String sxDeptId;

    /**
     * 外部机构名称
     */
    @ApiModelProperty("外部机构名称")
    @Column(name = "ex_dept_name")
    private String exDeptName;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 父部门ID
     */
    @ApiModelProperty("父部门ID")
    private String parentDetpId;
    
    
    @ApiModelProperty("完整部门名称")
    private String completeDeptName;
    
    @ApiModelProperty("用户所有的角色")
    private String roleNames;
    /**
     * 父部门名称
     */
    @ApiModelProperty("父部门名称")
    private String parentDetpName;

    /**
     * 用户状态(1启用，2禁用)
     */
    @ApiModelProperty("用户状态(1启用，2禁用)")
    private Integer state;

    /**
     * 性别(男:1，女:2)
     */
    @ApiModelProperty("性别(男:1，女:2)")
    private Integer sex;

    /**
     * 出生日期
     */
    @ApiModelProperty(value="出生日期",example = "2019-01-09")
    private String birthday;

    /**
     * 办公室电话
     */
    @ApiModelProperty("办公室电话")
    @Column(name = "office_phone")
    private String officePhone;

    /**
     * 分机号
     */
    @ApiModelProperty("分机号")
    @Column(name = "ext_number")
    private String extNumber;

    /**
     * 手机号号
     */
    @ApiModelProperty("手机号")
    private String phone;
    /**
     * 服务专业
     */
    @ApiModelProperty("服务专业")
    @Column(name = "service_sector")
    private String serviceSector;

    /**
     * 员工描述
     */
    @ApiModelProperty("员工描述")
    private String descn;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("数据来源（0:默认;1:SHR）")
    private Integer source;
    /**
     * 通讯地址
     */
    @ApiModelProperty("通讯地址")
    private String address;

    /**
     * 最后登录IP
     */
    @ApiModelProperty("最近登录IP")
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 入职时间
     */
    @ApiModelProperty("入职时间")
    @Column(name = "enter_date")
    private String enterDate;

    /**
     * 用户所拥有的角色列表
     */
    @ApiModelProperty("用户所拥有的角色列表")
    private List<AuthRole> roleList;
    /**
     * 岗位id
     */
    @ApiModelProperty("岗位id")
    @Column(name = "post_id")
    private String postId;
    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    @Column(name = "post_name")
    private String postName;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    @Column(name = "last_signin_time")
    private String lastSigninTime;
    
    @ApiModelProperty("禁止登录时间")
    @Column(name ="ban_signin_time")
    private String banSigninTime;
    
    @ApiModelProperty("记录密码错误次数")
    @Column(name = "signin_error_num")
    private Integer signinErrorNum;
    
    @ApiModelProperty("办公地址id")
    @Column(name = "office_space_id")
    private String officeSpaceId;
    
    /*
     * 最后修改密码时间
     */
    @ApiModelProperty("最后修改密码时间")
    @Column(name="last_updatePwd_date")
    private String lastUpdatePwdDate;
    
    
    @ApiModelProperty("小能账号")
    @Column(name = "xiao_neng_id")
    private String xiaoNengId;
    
    @ApiModelProperty("udesk账户")
    @Column(name = "udesk_id")
    private String udeskId;

    @ApiModelProperty("坐席ID")
    @Column(name = "zuo_xi_id")
    private String zuoXiId;

    @ApiModelProperty(value = "用户token")
    private String token;

    @ApiModelProperty(value = "返回用户绑定的坐席")
    private String bindingZuoXi;

    @ApiModelProperty(value = "返回被占用的用户名称")
    private String occupyName;

    @ApiModelProperty(value = "返回被占用的坐席")
    private String extension;

    @ApiModelProperty(value = "返回是否登录过的分机号")
    private String loginDevice;

    @ApiModelProperty("角色类型")
    private String manger;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("即时通讯接口Http")
    private String callPhone;

    @ApiModelProperty("即时通讯接口Https")
    private String httpsCallPhone;
    
    @ApiModelProperty("切换线路地址")
    private String deviceUrl;
    
    @ApiModelProperty("切换线路地址https")
    private String deviceHttps;
    
    @ApiModelProperty("修改线路地址http")
    private String switchlieHttp;
    
    @ApiModelProperty("修改线路地址https")
    private String switchlieHttps;
    
    @ApiModelProperty("七鱼ID")
    public String sevenFishId;
    

    @ApiModelProperty("螳螂ID")
    private String mantisId;

    @ApiModelProperty("坐席号类型(0:老呼叫系统,1:新呼叫系统)")
    private String zuoXiType;
    
    public String getMantisId() {
		return mantisId;
	}

	public void setMantisId(String mantisId) {
		this.mantisId = mantisId;
	}

	public String getSevenFishId() {
		return sevenFishId;
	}

	public void setSevenFishId(String sevenFishId) {
		this.sevenFishId = sevenFishId;
	}
    public String getUdeskId() {
        return udeskId;
    }

    public void setUdeskId(String udeskId) {
        this.udeskId = udeskId;
    }

    /**
     * IM账号
     */
    @Column(name = "im_accid")
    private String imAccid;
    /**
     * IM token
     */
    @Column(name = "im_token")
    private String imToken;
    /**
     * IM 昵称
     */
    @Column(name = "im_nickname")
    private String imNickname;

    /**
     * 头像
     */
    @Column(name = "head_portrait")
    public String headPortrait;
    
    /*
     * 1:修改
     * 2：不修改
     */
    @ApiModelProperty(name = "是否修改密码")
    public Integer isUpdatePwd;
    
    /*
     * 个性签名
     */
    @Column(name = "signature")
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取用户登录账号(员工编号)
     *
     * @return user_id - 用户登录账号(员工编号)
     */
    public String getUserId() {
        return userId;
    }

    public String getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }
    
    
    public String getHttpsCallPhone() {
        return httpsCallPhone;
    }

    public void setHttpsCallPhone(String httpsCallPhone) {
        this.httpsCallPhone = httpsCallPhone;
    }

    public String getDeviceHttps() {
        return deviceHttps;
    }

    public void setDeviceHttps(String deviceHttps) {
        this.deviceHttps = deviceHttps;
    }

    /**
     * 设置用户登录账号(员工编号)
     *
     * @param userId
     *            用户登录账号(员工编号)
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName
     *            用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password
     *            用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取部门ID
     *
     * @return dept_Id - 部门ID
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门ID
     *
     * @param deptId
     *            部门ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取用户状态(1启用，2禁用)
     *
     * @return state - 用户状态(1启用，2禁用)
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置用户状态(1启用，2禁用)
     *
     * @param state
     *            用户状态(1启用，2禁用)
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取性别(男:1，女:2)
     *
     * @return sex - 性别(男:1，女:2)
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别(男:1，女:2)
     *
     * @param sex
     *            性别(男:1，女:2)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取办公室电话
     *
     * @return office_phone - 办公室电话
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * 设置办公室电话
     *
     * @param officePhone
     *            办公室电话
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    /**
     * 获取分机号
     *
     * @return extension_phone - 分机号
     */
    public String getExtNumber() {
        return extNumber;
    }

    /**
     * 设置分机号
     *
     * @param extNumber
     *            分机号
     */
    public void setExtNumber(String extNumber) {
        this.extNumber = extNumber == null ? null : extNumber.trim();
    }

    /**
     * 获取服务专业
     *
     * @return service_sector - 服务专业
     */
    public String getServiceSector() {
        return serviceSector;
    }

    /**
     * 设置服务专业
     *
     * @param serviceSector
     *            服务专业
     */
    public void setServiceSector(String serviceSector) {
        this.serviceSector = serviceSector == null ? null : serviceSector.trim();
    }

    /**
     * 获取员工描述
     *
     * @return descn - 员工描述
     */
    public String getDescn() {
        return descn;
    }

    /**
     * 设置员工描述
     *
     * @param descn
     *            员工描述
     */
    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email
     *            电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取通讯地址
     *
     * @return address - 通讯地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置通讯地址
     *
     * @param address
     *            通讯地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public List<AuthRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<AuthRole> roleList) {
        this.roleList = roleList;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getParentDetpId() {
        return parentDetpId;
    }

    public void setParentDetpId(String parentDetpId) {
        this.parentDetpId = parentDetpId;
    }

    public String getParentDetpName() {
        return parentDetpName;
    }

    public void setParentDetpName(String parentDetpName) {
        this.parentDetpName = parentDetpName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getXiaoNengId() {
        return xiaoNengId;
    }

    public void setXiaoNengId(String xiaoNengId) {
        this.xiaoNengId = xiaoNengId;
    }

    public String getZuoXiId() {
        return zuoXiId;
    }

    public void setZuoXiId(String zuoXiId) {
        this.zuoXiId = zuoXiId;
    }

    public String getImAccid() {
        return imAccid;
    }

    public void setImAccid(String imAccid) {
        this.imAccid = imAccid;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }

    public String getImNickname() {
        return imNickname;
    }

    public void setImNickname(String imNickname) {
        this.imNickname = imNickname;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getExDeptName() {
        return exDeptName;
    }

    public void setExDeptName(String exDeptName) {
        this.exDeptName = exDeptName;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getBindingZuoXi() {
        return bindingZuoXi;
    }

    public void setBindingZuoXi(String bindingZuoXi) {
        this.bindingZuoXi = bindingZuoXi;
    }

    public String getOccupyName() {
        return occupyName;
    }

    public void setOccupyName(String occupyName) {
        this.occupyName = occupyName;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getSxDeptId() {
        return sxDeptId;
    }

    public void setSxDeptId(String sxDeptId) {
        this.sxDeptId = sxDeptId;
    }

    public String getManger() {
        return manger;
    }

    public void setManger(String manger) {
        this.manger = manger;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
    }

    public String getSwitchlieHttp() {
        return switchlieHttp;
    }

    public void setSwitchlieHttp(String switchlieHttp) {
        this.switchlieHttp = switchlieHttp;
    }

    public String getSwitchlieHttps() {
        return switchlieHttps;
    }

    public void setSwitchlieHttps(String switchlieHttps) {
        this.switchlieHttps = switchlieHttps;
    }

    public Integer getIsUpdatePwd() {
        return isUpdatePwd;
    }

    public void setIsUpdatePwd(Integer isUpdatePwd) {
        this.isUpdatePwd = isUpdatePwd;
    }

    public Integer getSigninErrorNum() {
        return signinErrorNum;
    }

    public void setSigninErrorNum(Integer signinErrorNum) {
        this.signinErrorNum = signinErrorNum;
    }

    public String getOfficeSpaceId() {
        return officeSpaceId;
    }

    public void setOfficeSpaceId(String officeSpaceId) {
        this.officeSpaceId = officeSpaceId;
    }

    public String getCompleteDeptName() {
        return completeDeptName;
    }

    public void setCompleteDeptName(String completeDeptName) {
        this.completeDeptName = completeDeptName;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getZuoXiType() {
        return zuoXiType;
    }

    public void setZuoXiType(String zuoXiType) {
        this.zuoXiType = zuoXiType;
    }
}