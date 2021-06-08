package com.sxmaps.mms.model;

import javax.persistence.*;

@Table(name = "mms_area")
public class MmsArea {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 区域编号
     */
    @Column(name = "code_id")
    private String codeId;

    /**
     * 区域名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 父编号
     */
    @Column(name = "parent_id")
    private String parentId;

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
     * 获取区域编号
     *
     * @return code_id - 区域编号
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * 设置区域编号
     *
     * @param codeId 区域编号
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    /**
     * 获取区域名称
     *
     * @return area_name - 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名称
     *
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 获取父编号
     *
     * @return parent_id - 父编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}