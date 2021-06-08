package com.sxmaps.mms.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "orders_member_prop")
public class OrdersMemberProp {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 会员uid
     */
    @Column(name = "member_uid")
    private Long memberUid;

    /**
     * 订单uid
     */
    @Column(name = "order_uid")
    private Long orderUid;

    /**
     * 订单号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 子订单uid
     */
    @Column(name = "order_item_id")
    private Long orderItemId;

    /**
     * 子订单号
     */
    @Column(name = "order_item_sn")
    private String orderItemSn;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 订单金额
     */
    @Column(name = "order_pay")
    private BigDecimal orderPay;

    /**
     * 订单实付金额
     */
    @Column(name = "order_act_pay")
    private BigDecimal orderActPay;

    /**
     * 最新订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    @Column(name = "biz_state_new")
    private String bizStateNew;
    
    @Column(name = "service_state")
    private String serviceState;

    /**
     * 上一次订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    @Column(name = "biz_state_old")
    private String bizStateOld;

    /**
     * 最新业务变更类别 0保持不变,1退费,2换专业
     */
    @Column(name = "biz_type_new")
    private String bizTypeNew;

    /**
     * 上一次业务变更类别 0保持不变,1退费,2换专业
     */
    @Column(name = "biz_type_old")
    private String bizTypeOld;

    /**
     * 商品uid
     */
    @Column(name = "product_uid")
    private Long productUid;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品图片
     */
    @Column(name = "product_img")
    private String productImg;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 学校uid
     */
    @Column(name = "college_uid")
    private Long collegeUid;

    /**
     * 学校名称
     */
    @Column(name = "college_name")
    private String collegeName;

    /**
     * 专业uid
     */
    @Column(name = "department_uid")
    private Long departmentUid;

    /**
     * 专业名称
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 学历级别uid
     */
    @Column(name = "level_type_uid")
    private Long levelTypeUid;

    /**
     * 学历级别名称
     */
    @Column(name = "level_type_name")
    private String levelTypeName;

    /**
     * 班型uid
     */
    @Column(name = "class_type_uid")
    private Long classTypeUid;

    /**
     * 班型名称
     */
    @Column(name = "class_type_name")
    private String classTypeName;

    /**
     * 班主任uid
     */
    @Column(name = "teacher_uid")
    private String teacherUid;

    /**
     * 班主任名称
     */
    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 分校接待老师uid
     */
    @Column(name = "station_teacher_uid")
    private String stationTeacherUid;

    /**
     * 分校接待老师名称
     */
    @Column(name = "station_teacher_name")
    private String stationTeacherName;

    /**
     * 前端咨询老师uid
     */
    @Column(name = "seller_uid")
    private String sellerUid;

    /**
     * 前端咨询老师名称
     */
    @Column(name = "seller_name")
    private String sellerName;

    /**
     * 前端电话咨询老师uid
     */
    @Column(name = "call_seller_uid")
    private String callSellerUid;

    /**
     * 前端电话咨询老师名称
     */
    @Column(name = "call_seller_name")
    private String callSellerName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态 1有效,0失效
     */
    private String state;

    /**
     * 获取uid
     *
     * @return uid - uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取会员uid
     *
     * @return member_uid - 会员uid
     */
    public Long getMemberUid() {
        return memberUid;
    }

    /**
     * 设置会员uid
     *
     * @param memberUid 会员uid
     */
    public void setMemberUid(Long memberUid) {
        this.memberUid = memberUid;
    }

    /**
     * 获取订单uid
     *
     * @return order_uid - 订单uid
     */
    public Long getOrderUid() {
        return orderUid;
    }

    /**
     * 设置订单uid
     *
     * @param orderUid 订单uid
     */
    public void setOrderUid(Long orderUid) {
        this.orderUid = orderUid;
    }

    /**
     * 获取订单号
     *
     * @return order_sn - 订单号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置订单号
     *
     * @param orderSn 订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取子订单uid
     *
     * @return order_item_id - 子订单uid
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置子订单uid
     *
     * @param orderItemId 子订单uid
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 获取子订单号
     *
     * @return order_item_sn - 子订单号
     */
    public String getOrderItemSn() {
        return orderItemSn;
    }

    /**
     * 设置子订单号
     *
     * @param orderItemSn 子订单号
     */
    public void setOrderItemSn(String orderItemSn) {
        this.orderItemSn = orderItemSn == null ? null : orderItemSn.trim();
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取订单金额
     *
     * @return order_pay - 订单金额
     */
    public BigDecimal getOrderPay() {
        return orderPay;
    }

    /**
     * 设置订单金额
     *
     * @param orderPay 订单金额
     */
    public void setOrderPay(BigDecimal orderPay) {
        this.orderPay = orderPay;
    }

    /**
     * 获取订单实付金额
     *
     * @return order_act_pay - 订单实付金额
     */
    public BigDecimal getOrderActPay() {
        return orderActPay;
    }

    /**
     * 设置订单实付金额
     *
     * @param orderActPay 订单实付金额
     */
    public void setOrderActPay(BigDecimal orderActPay) {
        this.orderActPay = orderActPay;
    }

    /**
     * 获取最新订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     *
     * @return biz_state_new - 最新订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    public String getBizStateNew() {
        return bizStateNew;
    }

    /**
     * 设置最新订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     *
     * @param bizStateNew 最新订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    public void setBizStateNew(String bizStateNew) {
        this.bizStateNew = bizStateNew == null ? null : bizStateNew.trim();
    }

    /**
     * 获取上一次订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     *
     * @return biz_state_old - 上一次订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    public String getBizStateOld() {
        return bizStateOld;
    }

    /**
     * 设置上一次订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     *
     * @param bizStateOld 上一次订单售后状态 -1驳回,0已申请,1处理中,2审核中,3已完成
     */
    public void setBizStateOld(String bizStateOld) {
        this.bizStateOld = bizStateOld == null ? null : bizStateOld.trim();
    }

    /**
     * 获取最新业务变更类别 0保持不变,1退费,2换专业
     *
     * @return biz_type_new - 最新业务变更类别 0保持不变,1退费,2换专业
     */
    public String getBizTypeNew() {
        return bizTypeNew;
    }

    /**
     * 设置最新业务变更类别 0保持不变,1退费,2换专业
     *
     * @param bizTypeNew 最新业务变更类别 0保持不变,1退费,2换专业
     */
    public void setBizTypeNew(String bizTypeNew) {
        this.bizTypeNew = bizTypeNew == null ? null : bizTypeNew.trim();
    }

    /**
     * 获取上一次业务变更类别 0保持不变,1退费,2换专业
     *
     * @return biz_type_old - 上一次业务变更类别 0保持不变,1退费,2换专业
     */
    public String getBizTypeOld() {
        return bizTypeOld;
    }

    /**
     * 设置上一次业务变更类别 0保持不变,1退费,2换专业
     *
     * @param bizTypeOld 上一次业务变更类别 0保持不变,1退费,2换专业
     */
    public void setBizTypeOld(String bizTypeOld) {
        this.bizTypeOld = bizTypeOld == null ? null : bizTypeOld.trim();
    }

    /**
     * 获取商品uid
     *
     * @return product_uid - 商品uid
     */
    public Long getProductUid() {
        return productUid;
    }

    /**
     * 设置商品uid
     *
     * @param productUid 商品uid
     */
    public void setProductUid(Long productUid) {
        this.productUid = productUid;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取商品图片
     *
     * @return product_img - 商品图片
     */
    public String getProductImg() {
        return productImg;
    }

    /**
     * 设置商品图片
     *
     * @param productImg 商品图片
     */
    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    /**
     * 获取商品价格
     *
     * @return product_price - 商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品价格
     *
     * @param productPrice 商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取学校uid
     *
     * @return college_uid - 学校uid
     */
    public Long getCollegeUid() {
        return collegeUid;
    }

    /**
     * 设置学校uid
     *
     * @param collegeUid 学校uid
     */
    public void setCollegeUid(Long collegeUid) {
        this.collegeUid = collegeUid;
    }

    /**
     * 获取学校名称
     *
     * @return college_name - 学校名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学校名称
     *
     * @param collegeName 学校名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    /**
     * 获取专业uid
     *
     * @return department_uid - 专业uid
     */
    public Long getDepartmentUid() {
        return departmentUid;
    }

    /**
     * 设置专业uid
     *
     * @param departmentUid 专业uid
     */
    public void setDepartmentUid(Long departmentUid) {
        this.departmentUid = departmentUid;
    }

    /**
     * 获取专业名称
     *
     * @return department_name - 专业名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置专业名称
     *
     * @param departmentName 专业名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * 获取学历级别uid
     *
     * @return level_type_uid - 学历级别uid
     */
    public Long getLevelTypeUid() {
        return levelTypeUid;
    }

    /**
     * 设置学历级别uid
     *
     * @param levelTypeUid 学历级别uid
     */
    public void setLevelTypeUid(Long levelTypeUid) {
        this.levelTypeUid = levelTypeUid;
    }

    /**
     * 获取学历级别名称
     *
     * @return level_type_name - 学历级别名称
     */
    public String getLevelTypeName() {
        return levelTypeName;
    }

    /**
     * 设置学历级别名称
     *
     * @param levelTypeName 学历级别名称
     */
    public void setLevelTypeName(String levelTypeName) {
        this.levelTypeName = levelTypeName == null ? null : levelTypeName.trim();
    }

    /**
     * 获取班型uid
     *
     * @return class_type_uid - 班型uid
     */
    public Long getClassTypeUid() {
        return classTypeUid;
    }

    /**
     * 设置班型uid
     *
     * @param classTypeUid 班型uid
     */
    public void setClassTypeUid(Long classTypeUid) {
        this.classTypeUid = classTypeUid;
    }

    /**
     * 获取班型名称
     *
     * @return class_type_name - 班型名称
     */
    public String getClassTypeName() {
        return classTypeName;
    }

    /**
     * 设置班型名称
     *
     * @param classTypeName 班型名称
     */
    public void setClassTypeName(String classTypeName) {
        this.classTypeName = classTypeName == null ? null : classTypeName.trim();
    }

    /**
     * 获取班主任uid
     *
     * @return teacher_uid - 班主任uid
     */
    public String getTeacherUid() {
        return teacherUid;
    }

    /**
     * 设置班主任uid
     *
     * @param teacherUid 班主任uid
     */
    public void setTeacherUid(String teacherUid) {
        this.teacherUid = teacherUid == null ? null : teacherUid.trim();
    }

    /**
     * 获取班主任名称
     *
     * @return teacher_name - 班主任名称
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置班主任名称
     *
     * @param teacherName 班主任名称
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * 获取分校接待老师uid
     *
     * @return station_teacher_uid - 分校接待老师uid
     */
    public String getStationTeacherUid() {
        return stationTeacherUid;
    }

    /**
     * 设置分校接待老师uid
     *
     * @param stationTeacherUid 分校接待老师uid
     */
    public void setStationTeacherUid(String stationTeacherUid) {
        this.stationTeacherUid = stationTeacherUid == null ? null : stationTeacherUid.trim();
    }

    /**
     * 获取分校接待老师名称
     *
     * @return station_teacher_name - 分校接待老师名称
     */
    public String getStationTeacherName() {
        return stationTeacherName;
    }

    /**
     * 设置分校接待老师名称
     *
     * @param stationTeacherName 分校接待老师名称
     */
    public void setStationTeacherName(String stationTeacherName) {
        this.stationTeacherName = stationTeacherName == null ? null : stationTeacherName.trim();
    }

    /**
     * 获取前端咨询老师uid
     *
     * @return seller_uid - 前端咨询老师uid
     */
    public String getSellerUid() {
        return sellerUid;
    }

    /**
     * 设置前端咨询老师uid
     *
     * @param sellerUid 前端咨询老师uid
     */
    public void setSellerUid(String sellerUid) {
        this.sellerUid = sellerUid == null ? null : sellerUid.trim();
    }

    /**
     * 获取前端咨询老师名称
     *
     * @return seller_name - 前端咨询老师名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * 设置前端咨询老师名称
     *
     * @param sellerName 前端咨询老师名称
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    /**
     * 获取前端电话咨询老师uid
     *
     * @return call_seller_uid - 前端电话咨询老师uid
     */
    public String getCallSellerUid() {
        return callSellerUid;
    }

    /**
     * 设置前端电话咨询老师uid
     *
     * @param callSellerUid 前端电话咨询老师uid
     */
    public void setCallSellerUid(String callSellerUid) {
        this.callSellerUid = callSellerUid == null ? null : callSellerUid.trim();
    }

    /**
     * 获取前端电话咨询老师名称
     *
     * @return call_seller_name - 前端电话咨询老师名称
     */
    public String getCallSellerName() {
        return callSellerName;
    }

    /**
     * 设置前端电话咨询老师名称
     *
     * @param callSellerName 前端电话咨询老师名称
     */
    public void setCallSellerName(String callSellerName) {
        this.callSellerName = callSellerName == null ? null : callSellerName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态 1有效,0失效
     *
     * @return state - 状态 1有效,0失效
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 1有效,0失效
     *
     * @param state 状态 1有效,0失效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}
    
    
}