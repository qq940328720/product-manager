package com.aishang.product.model;

import java.util.Date;

/**
 * 产品还款包配置表
 */
public class RepaymentPackageConfig {
    private Integer id;

    private String productCode;  //产品编号

    private String packageCode;  //还款包编号

    private Integer enabled;  //    是否开启1.开启2.关闭

    private Integer deleted;  //  是否删除  1.y  2.n

    private Date insertTime;

    private Date updateTime;

    public RepaymentPackageConfig(Integer id, String productCode, String packageCode, Integer enabled, Integer deleted, Date insertTime, Date updateTime) {
        this.id = id;
        this.productCode = productCode;
        this.packageCode = packageCode;
        this.enabled = enabled;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public RepaymentPackageConfig() {
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

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode == null ? null : packageCode.trim();
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


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        RepaymentPackageConfig that = (RepaymentPackageConfig) object;

        if (!id.equals(that.id)) return false;
        if (!productCode.equals(that.productCode)) return false;
        if (!packageCode.equals(that.packageCode)) return false;
        if (!enabled.equals(that.enabled)) return false;
        if (!deleted.equals(that.deleted)) return false;
        if (!insertTime.equals(that.insertTime)) return false;
        if (!updateTime.equals(that.updateTime)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + productCode.hashCode();
        result = 31 * result + packageCode.hashCode();
        result = 31 * result + enabled.hashCode();
        result = 31 * result + deleted.hashCode();
        result = 31 * result + insertTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RepaymentPackageConfig{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", packageCode='" + packageCode + '\'' +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}