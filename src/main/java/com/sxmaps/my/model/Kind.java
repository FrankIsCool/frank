package com.sxmaps.my.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "kind")
public class Kind {
    /**
     * uid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    /**
     * 种类名称
     */
    @Column(name = "kind_name")
    private String kindName;

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
     * 获取种类名称
     *
     * @return kind_name - 种类名称
     */
    public String getKindName() {
        return kindName;
    }

    /**
     * 设置种类名称
     *
     * @param kindName 种类名称
     */
    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
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