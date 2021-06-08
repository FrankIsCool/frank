package com.sxmaps.mms.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "mms_member_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MmsMemberType {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * mms_resubmit_member表主键
     */
    @Column(name = "resubmit_uid")
    private Long resubmitUid;

    /**
     * mms_call_back表主键
     */
    @Column(name = "call_back_uid")
    private Long callBackUid;

    /**
     * 类型id
     */
    @Column(name = "member_type")
    private Integer memberType;

    /**
     * 类型名称
     */
    @Column(name = "member_type_name")
    private String memberTypeName;

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
     * 获取mms_resubmit_member表主键
     *
     * @return resubmit_uid - mms_resubmit_member表主键
     */
    public Long getResubmitUid() {
        return resubmitUid;
    }

    /**
     * 设置mms_resubmit_member表主键
     *
     * @param resubmitUid mms_resubmit_member表主键
     */
    public void setResubmitUid(Long resubmitUid) {
        this.resubmitUid = resubmitUid;
    }

    /**
     * 获取mms_call_back表主键
     *
     * @return call_back_uid - mms_call_back表主键
     */
    public Long getCallBackUid() {
        return callBackUid;
    }

    /**
     * 设置mms_call_back表主键
     *
     * @param callBackUid mms_call_back表主键
     */
    public void setCallBackUid(Long callBackUid) {
        this.callBackUid = callBackUid;
    }

    /**
     * 获取类型id
     *
     * @return member_type - 类型id
     */
    public Integer getMemberType() {
        return memberType;
    }

    /**
     * 设置类型id
     *
     * @param memberType 类型id
     */
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    /**
     * 获取类型名称
     *
     * @return member_type_name - 类型名称
     */
    public String getMemberTypeName() {
        return memberTypeName;
    }

    /**
     * 设置类型名称
     *
     * @param memberTypeName 类型名称
     */
    public void setMemberTypeName(String memberTypeName) {
        this.memberTypeName = memberTypeName == null ? null : memberTypeName.trim();
    }
}