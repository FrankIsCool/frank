package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mms_call_back")
public class MmsCallBack {
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
     * 中端咨询师id
     */
    @Column(name = "consult_id")
    private String consultId;

    /**
     * 中端咨询师
     */
    @Column(name = "consult_name")
    private String consultName;

    /**
     * 下次回访时间
     */
    @Column(name = "next_call_time")
    private Date nextCallTime;

    /**
     * 回访内容
     */
    @Column(name = "call_record")
    private String callRecord;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取中端咨询师id
     *
     * @return consult_id - 中端咨询师id
     */
    public String getConsultId() {
        return consultId;
    }

    /**
     * 设置中端咨询师id
     *
     * @param consultId 中端咨询师id
     */
    public void setConsultId(String consultId) {
        this.consultId = consultId == null ? null : consultId.trim();
    }

    /**
     * 获取中端咨询师
     *
     * @return consult_name - 中端咨询师
     */
    public String getConsultName() {
        return consultName;
    }

    /**
     * 设置中端咨询师
     *
     * @param consultName 中端咨询师
     */
    public void setConsultName(String consultName) {
        this.consultName = consultName == null ? null : consultName.trim();
    }

    /**
     * 获取下次回访时间
     *
     * @return next_call_time - 下次回访时间
     */
    public Date getNextCallTime() {
        return nextCallTime;
    }

    /**
     * 设置下次回访时间
     *
     * @param nextCallTime 下次回访时间
     */
    public void setNextCallTime(Date nextCallTime) {
        this.nextCallTime = nextCallTime;
    }

    /**
     * 获取回访内容
     *
     * @return call_record - 回访内容
     */
    public String getCallRecord() {
        return callRecord;
    }

    /**
     * 设置回访内容
     *
     * @param callRecord 回访内容
     */
    public void setCallRecord(String callRecord) {
        this.callRecord = callRecord == null ? null : callRecord.trim();
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