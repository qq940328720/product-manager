package com.aishang.product.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品
 */
public class Product {

//    /**
//     * @Fields serialVersionUID : TODO
//     */
//    private static final long serialVersionUID = 1L;

    private Integer id;

    private String productCode;    // 产品编号

    private String productName;   //  产品名称

    private String level1Code;   //  级别1：对应字典表产品级别code

    private String level2Code;   //     级别2：对应字典表产品级别code

    private String level3Code;   //     级别3：对应字典表产品级别code

    private Integer moneyResource;   // 资金通道：1.爱尚2.小雨点

    private Integer state;   //   状态：1.正常2.待审核3.禁用4.驳回

    private Integer interestType;   //  计息方式：1.等额本息2.等额本金3.等本等息

    private Integer isSupportAssend;   //是否允许爱尚放款  1.允许2.不允许

    private Integer isEnabledLadder;        //是否开启单量阶梯限制

    private Integer enabled;   //是否启用   1.允许2.不允许

    private Integer deleted;   //是否删除：1.y  2.n

    private Integer loanType;   //放款类型：1.客户本人账户  2.所属门店银行账户

    private BigDecimal totalRate;   //总利率

    private Date insertTime;

    private Date updateTime;

    private String bizid;


    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", level1Code='" + level1Code + '\'' +
                ", level2Code='" + level2Code + '\'' +
                ", level3Code='" + level3Code + '\'' +
                ", moneyResource=" + moneyResource +
                ", state=" + state +
                ", interestType=" + interestType +
                ", isSupportAssend=" + isSupportAssend +
                ", isEnabledLadder=" + isEnabledLadder +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", loanType=" + loanType +
                ", totalRate=" + totalRate +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                ", bizid='" + bizid + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (level1Code != null ? !level1Code.equals(product.level1Code) : product.level1Code != null) return false;
        if (level2Code != null ? !level2Code.equals(product.level2Code) : product.level2Code != null) return false;
        if (level3Code != null ? !level3Code.equals(product.level3Code) : product.level3Code != null) return false;
        if (moneyResource != null ? !moneyResource.equals(product.moneyResource) : product.moneyResource != null)
            return false;
        if (state != null ? !state.equals(product.state) : product.state != null) return false;
        if (interestType != null ? !interestType.equals(product.interestType) : product.interestType != null)
            return false;
        if (isSupportAssend != null ? !isSupportAssend.equals(product.isSupportAssend) : product.isSupportAssend != null)
            return false;
        if (isEnabledLadder != null ? !isEnabledLadder.equals(product.isEnabledLadder) : product.isEnabledLadder != null)
            return false;
        if (enabled != null ? !enabled.equals(product.enabled) : product.enabled != null) return false;
        if (deleted != null ? !deleted.equals(product.deleted) : product.deleted != null) return false;
        if (loanType != null ? !loanType.equals(product.loanType) : product.loanType != null) return false;
        if (totalRate != null ? !totalRate.equals(product.totalRate) : product.totalRate != null) return false;
        if (insertTime != null ? !insertTime.equals(product.insertTime) : product.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(product.updateTime) : product.updateTime != null) return false;
        return bizid != null ? bizid.equals(product.bizid) : product.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (level1Code != null ? level1Code.hashCode() : 0);
        result = 31 * result + (level2Code != null ? level2Code.hashCode() : 0);
        result = 31 * result + (level3Code != null ? level3Code.hashCode() : 0);
        result = 31 * result + (moneyResource != null ? moneyResource.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (isSupportAssend != null ? isSupportAssend.hashCode() : 0);
        result = 31 * result + (isEnabledLadder != null ? isEnabledLadder.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        result = 31 * result + (totalRate != null ? totalRate.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        this.totalRate = totalRate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLevel1Code() {
        return level1Code;
    }

    public void setLevel1Code(String level1Code) {
        this.level1Code = level1Code;
    }

    public String getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code;
    }

    public String getLevel3Code() {
        return level3Code;
    }

    public void setLevel3Code(String level3Code) {
        this.level3Code = level3Code;
    }

    public Integer getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(Integer moneyResource) {
        this.moneyResource = moneyResource;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getInterestType() {
        return interestType;
    }

    public void setInterestType(Integer interestType) {
        this.interestType = interestType;
    }

    public Integer getIsSupportAssend() {
        return isSupportAssend;
    }

    public void setIsSupportAssend(Integer isSupportAssend) {
        this.isSupportAssend = isSupportAssend;
    }

    public Integer getIsEnabledLadder() {
        return isEnabledLadder;
    }

    public void setIsEnabledLadder(Integer isEnabledLadder) {
        this.isEnabledLadder = isEnabledLadder;
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

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
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
        this.bizid = bizid;
    }
}