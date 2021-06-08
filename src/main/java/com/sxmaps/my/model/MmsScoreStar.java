package com.sxmaps.mms.model;

import javax.persistence.*;

@Table(name = "mms_score_star")
public class MmsScoreStar {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 分值
     */
    @Column(name = "score_key")
    private Double scoreKey;

    /**
     * 分值名称
     */
    @Column(name = "score_name")
    private String scoreName;

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
     * 获取分值
     *
     * @return score_key - 分值
     */
    public Double getScoreKey() {
        return scoreKey;
    }

    /**
     * 设置分值
     *
     * @param scoreKey 分值
     */
    public void setScoreKey(Double scoreKey) {
        this.scoreKey = scoreKey;
    }

    /**
     * 获取分值名称
     *
     * @return score_name - 分值名称
     */
    public String getScoreName() {
        return scoreName;
    }

    /**
     * 设置分值名称
     *
     * @param scoreName 分值名称
     */
    public void setScoreName(String scoreName) {
        this.scoreName = scoreName == null ? null : scoreName.trim();
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
}