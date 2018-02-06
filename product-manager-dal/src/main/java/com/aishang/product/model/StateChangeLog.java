package com.aishang.product.model;

import java.util.Date;

/**
 * 产品状态变更历史表
 */
public class StateChangeLog {
    private Integer id;

    private String productCode;   //产品编码

    private Integer state;   //状态：1.正常2.待审核3.禁用4.驳回

    private String stateRemark;   //状态备注

    private String operationPerson;   //操作人

    private Integer deleted;   //是否删除  1.y  2.n

    private Date insertTime;

    private Date updateTime;

    private String stateCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateChangeLog that = (StateChangeLog) o;

        if (!id.equals(that.id)) return false;
        if (!productCode.equals(that.productCode)) return false;
        if (!state.equals(that.state)) return false;
        if (!stateRemark.equals(that.stateRemark)) return false;
        if (!operationPerson.equals(that.operationPerson)) return false;
        if (!deleted.equals(that.deleted)) return false;
        if (!insertTime.equals(that.insertTime)) return false;
        if (!updateTime.equals(that.updateTime)) return false;
        return stateCode.equals(that.stateCode);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + productCode.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + stateRemark.hashCode();
        result = 31 * result + operationPerson.hashCode();
        result = 31 * result + deleted.hashCode();
        result = 31 * result + insertTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        result = 31 * result + stateCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StateChangeLog{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", state=" + state +
                ", stateRemark='" + stateRemark + '\'' +
                ", operationPerson='" + operationPerson + '\'' +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", stateCode='" + stateCode + '\'' +
                '}';
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
        this.productCode = productCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateRemark() {
        return stateRemark;
    }

    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }

    public String getOperationPerson() {
        return operationPerson;
    }

    public void setOperationPerson(String operationPerson) {
        this.operationPerson = operationPerson;
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

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}