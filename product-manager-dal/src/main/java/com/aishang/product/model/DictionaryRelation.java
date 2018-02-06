package com.aishang.product.model;

import java.util.Date;

public class DictionaryRelation {
    private Integer id;

    private String dataCode;

    private String parentCode;

    private Byte deleted;

    private Date insertTime;

    private Date updateTime;

    public DictionaryRelation(Integer id, String dataCode, String parentCode, Byte deleted, Date insertTime, Date updateTime) {
        this.id = id;
        this.dataCode = dataCode;
        this.parentCode = parentCode;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public DictionaryRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode == null ? null : dataCode.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}