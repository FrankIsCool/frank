package com.sxmaps.mms.model;

import javax.persistence.*;

@Table(name = "mms_score_opinion_map")
public class MmsScoreOpinionMap {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 分值uid
     */
    @Column(name = "score_uid")
    private Long scoreUid;

    /**
     * 点评uid
     */
    @Column(name = "opinion_uid")
    private Long opinionUid;

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
     * 获取分值uid
     *
     * @return score_uid - 分值uid
     */
    public Long getScoreUid() {
        return scoreUid;
    }

    /**
     * 设置分值uid
     *
     * @param scoreUid 分值uid
     */
    public void setScoreUid(Long scoreUid) {
        this.scoreUid = scoreUid;
    }

    /**
     * 获取点评uid
     *
     * @return opinion_uid - 点评uid
     */
    public Long getOpinionUid() {
        return opinionUid;
    }

    /**
     * 设置点评uid
     *
     * @param opinionUid 点评uid
     */
    public void setOpinionUid(Long opinionUid) {
        this.opinionUid = opinionUid;
    }
}