package com.aishang.product.model;

import java.util.Date;

/**
 * 产品支持期数记录表
 */
public class SupportPaytime {
    private Integer id;

    private String productCode;     //产品编号

    private Integer payTime;        //支持期数

    private Integer paytimeUnit;   //期数单位

    private Integer deleted;        //是否删除

    private Date insertTime;

    private Date updateTime;

    public SupportPaytime(Integer id, String productCode, Integer payTime, Integer deleted, Date insertTime, Date updateTime) {
        this.id = id;
        this.productCode = productCode;
        this.payTime = payTime;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public Integer getPaytimeUnit() {
        return paytimeUnit;
    }

    public void setPaytimeUnit(Integer paytimeUunit) {
        this.paytimeUnit = paytimeUunit;
    }

    public SupportPaytime() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        SupportPaytime that = (SupportPaytime) object;

        if (!id.equals(that.id)) return false;
        if (!productCode.equals(that.productCode)) return false;
        if (!payTime.equals(that.payTime)) return false;
        if (!deleted.equals(that.deleted)) return false;
        if (!insertTime.equals(that.insertTime)) return false;
        if (!updateTime.equals(that.updateTime)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + productCode.hashCode();
        result = 31 * result + payTime.hashCode();
        result = 31 * result + deleted.hashCode();
        result = 31 * result + insertTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SupportPaytime{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", payTime=" + payTime +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }

}