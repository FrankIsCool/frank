package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "orders_member_feed")
public class OrdersMemberFeed {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 记录id
     */
    @Column(name = "record_id")
    private String recordId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取id
     *
     * @return uid - id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置id
     *
     * @param uid id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取会员id
     *
     * @return member_id - 会员id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员id
     *
     * @param memberId 会员id
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取记录id
     *
     * @return record_id - 记录id
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * 设置记录id
     *
     * @param recordId 记录id
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
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
}