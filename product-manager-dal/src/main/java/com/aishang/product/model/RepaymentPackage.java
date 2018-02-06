package com.aishang.product.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 还款包源
 */
public class RepaymentPackage {
    private Integer id;

    private String packageCode;  //还款包编号

    private String name;  //还款包名

    private BigDecimal value;  //利息

    private Integer type;  //  算法类型1.乘算法2.加算法

    private Integer paytimeType;  //  还款类型 1.年2.月3.日

    private Integer isChoice;  //是否必选 0.否 1.是

    private Integer enabled;  //  是否启用1.开启，2.关闭

    private Integer deleted;  //是否删除：1.y  2.n

    private Date insertTime;

    private Date updateTime;




    @Override
    public String toString() {
        return "RepaymentPackage{" +
                "id=" + id +
                ", packageCode='" + packageCode + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", paytimeType=" + paytimeType +
                ", isChoice=" + isChoice +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepaymentPackage that = (RepaymentPackage) o;

        if (!id.equals(that.id)) return false;
        if (!packageCode.equals(that.packageCode)) return false;
        if (!name.equals(that.name)) return false;
        if (!value.equals(that.value)) return false;
        if (!type.equals(that.type)) return false;
        if (!paytimeType.equals(that.paytimeType)) return false;
        if (!isChoice.equals(that.isChoice)) return false;
        if (!enabled.equals(that.enabled)) return false;
        if (!deleted.equals(that.deleted)) return false;
        if (!insertTime.equals(that.insertTime)) return false;
        return updateTime.equals(that.updateTime);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + packageCode.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + paytimeType.hashCode();
        result = 31 * result + isChoice.hashCode();
        result = 31 * result + enabled.hashCode();
        result = 31 * result + deleted.hashCode();
        result = 31 * result + insertTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPaytimeType() {
        return paytimeType;
    }

    public void setPaytimeType(Integer paytimeType) {
        this.paytimeType = paytimeType;
    }

    public Integer getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(Integer isChoice) {
        this.isChoice = isChoice;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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
}