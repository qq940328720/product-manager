package com.aishang.product.model;

import java.util.Date;

public class Dictionary {
    private Integer id;

    private String dataCode;

    private String dataType;

    private String dataName;

    private String dataValue;

    private String dataRemark;

    private String createUserId;

    private Byte deleted;

    private Date insertTime;

    private Date updateTime;

    private String bizid;

    public Dictionary(Integer id, String dataCode, String dataType, String dataName, String dataValue, String dataRemark, String createUserId, Byte deleted, Date insertTime, Date updateTime, String bizid) {
        this.id = id;
        this.dataCode = dataCode;
        this.dataType = dataType;
        this.dataName = dataName;
        this.dataValue = dataValue;
        this.dataRemark = dataRemark;
        this.createUserId = createUserId;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.bizid = bizid;
    }

    public Dictionary() {
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    public String getDataRemark() {
        return dataRemark;
    }

    public void setDataRemark(String dataRemark) {
        this.dataRemark = dataRemark == null ? null : dataRemark.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
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

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid == null ? null : bizid.trim();
    }
}