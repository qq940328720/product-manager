package com.aishang.product.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品分润配置表
 */
public class CommissionConfig {
    private Integer id;

    private String productCode;    //产品编码

    private Integer position;         //所配置职位1.销售总监2.大区经理

    private Integer commissionType;        //  提成方式1.金额提成2.单量提成

    private BigDecimal commission;        //   提成

    private Integer upperLimit;        // 阶梯上限

    private Integer lowerLimit;        //  阶梯下限

    private Integer deleted;            //  //是否删除：1.y  2.n

    private Date insertTime;

    private Date updateTime;

    public CommissionConfig(Integer id, String productCode, Integer position, Integer commissionType, BigDecimal commission, Integer upperLimit, Integer lowerLimit, Integer deleted, Date insertTime, Date updateTime) {
        this.id = id;
        this.productCode = productCode;
        this.position = position;
        this.commissionType = commissionType;
        this.commission = commission;
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public CommissionConfig() {
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
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

    @Override
    public String toString() {
        return "CommissionConfig{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", position=" + position +
                ", commissionType=" + commissionType +
                ", commission=" + commission +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommissionConfig that = (CommissionConfig) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (commissionType != null ? !commissionType.equals(that.commissionType) : that.commissionType != null)
            return false;
        if (commission != null ? !commission.equals(that.commission) : that.commission != null) return false;
        if (upperLimit != null ? !upperLimit.equals(that.upperLimit) : that.upperLimit != null) return false;
        if (lowerLimit != null ? !lowerLimit.equals(that.lowerLimit) : that.lowerLimit != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (commissionType != null ? commissionType.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        result = 31 * result + (upperLimit != null ? upperLimit.hashCode() : 0);
        result = 31 * result + (lowerLimit != null ? lowerLimit.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

}