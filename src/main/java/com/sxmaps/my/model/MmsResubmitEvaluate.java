package com.sxmaps.mms.model;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "mms_resubmit_evaluate")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MmsResubmitEvaluate {
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
     * 学员ID
     */
    @Column(name = "member_uid")
    private String memberUid;

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
     * 评价等级
     */
    @Column(name = "evaluate_rank")
    private Integer evaluateRank;

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
     * 操作人
     */
    @Column(name = "update_by")
    private String updateBy;

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
     * 获取学员ID
     *
     * @return member_uid - 学员ID
     */
    public String getMemberUid() {
        return memberUid;
    }

    /**
     * 设置学员ID
     *
     * @param memberUid 学员ID
     */
    public void setMemberUid(String memberUid) {
        this.memberUid = memberUid == null ? null : memberUid.trim();
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
     * 获取评价等级
     *
     * @return evaluate_rank - 评价等级
     */
    public Integer getEvaluateRank() {
        return evaluateRank;
    }

    /**
     * 设置评价等级
     *
     * @param evaluateRank 评价等级
     */
    public void setEvaluateRank(Integer evaluateRank) {
        this.evaluateRank = evaluateRank;
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
     * 获取操作人
     *
     * @return update_by - 操作人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置操作人
     *
     * @param updateBy 操作人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}