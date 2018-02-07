package com.aishang.product.facade.dto.info;

import com.aishang.product.common.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品
 * Created by ylj on 17-10-3.
 */
@ApiModel(description = "产品实体信息")
public class ProductInfoDTO {

    @ApiModelProperty(value = "业务ID")
    private String bizid;
    @ApiModelProperty(value = "产品编码")
    private String productCode;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "产品类型1")
    private String level1Code;
    @ApiModelProperty(value = "产品类型2")
    private String level2Code;
    @ApiModelProperty(value = "产品类型3")
    private String level3Code;
    @ApiModelProperty(value = "产品类型1名称")
    private String level1Name;
    @ApiModelProperty(value = "产品类型2名称")
    private String level2Name;
    @ApiModelProperty(value = "产品类型3名称")
    private String level3Name;
    @ApiModelProperty(value = "产品类型")
    private String productType;
    @ApiModelProperty(value = "支持的期数")
    private String supportPayTime;
    @ApiModelProperty(value = "资金渠道")
    private MoneyResourceEnum moneyResource;
    @ApiModelProperty(value = "产品状态")
    private ProductStateEnum state;
    @ApiModelProperty(value = "计息方式")
    private InterestTypeEnum interestType;
    @ApiModelProperty(value = "是否支持爱尚放款")
    private YesOrNoEnum isSupportAssend;
    @ApiModelProperty(value = "是否开启单量阶梯限制")
    private YesOrNoEnum isEnabledLadder;
    @ApiModelProperty(value = "放款类型")
    private LoanTypeEnum loanType;

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name == null ? "" : level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name == null ? "" : level2Name;
        ;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name == null ? "" : level3Name;
    }

    public String getSupportPayTime() {
        return supportPayTime;
    }

    public void setSupportPayTime(String supportPayTime) {
        this.supportPayTime = supportPayTime;
    }

    public YesOrNoEnum getIsSupportAssend() {
        return isSupportAssend;
    }

    public void setIsSupportAssend(YesOrNoEnum isSupportAssend) {
        this.isSupportAssend = isSupportAssend;
    }

    public LoanTypeEnum getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeEnum loanType) {
        this.loanType = loanType;
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
        this.level1Code = level1Code == null ? "" : level1Code;
    }

    public String getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code == null ? "" : level2Code;
    }

    public String getLevel3Code() {
        return level3Code;
    }

    public void setLevel3Code(String level3Code) {
        this.level3Code = level3Code == null ? "" : level3Code;
    }

    public MoneyResourceEnum getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(MoneyResourceEnum moneyResource) {
        this.moneyResource = moneyResource;
    }

    public ProductStateEnum getState() {
        return state;
    }

    public void setState(ProductStateEnum state) {
        this.state = state;
    }

    public InterestTypeEnum getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestTypeEnum interestType) {
        this.interestType = interestType;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public YesOrNoEnum getIsEnabledLadder() {
        return isEnabledLadder;
    }

    public void setIsEnabledLadder(YesOrNoEnum isEnabledLadder) {
        this.isEnabledLadder = isEnabledLadder;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductInfoDTO{" +
                "bizid='" + bizid + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", level1Code='" + level1Code + '\'' +
                ", level2Code='" + level2Code + '\'' +
                ", level3Code='" + level3Code + '\'' +
                ", productType='" + productType + '\'' +
                ", supportPayTime='" + supportPayTime + '\'' +
                ", moneyResource=" + moneyResource +
                ", state=" + state +
                ", interestType=" + interestType +
                ", isSupportAssend=" + isSupportAssend +
                ", isEnabledLadder=" + isEnabledLadder +
                ", loanType=" + loanType +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfoDTO that = (ProductInfoDTO) o;

        if (bizid != null ? !bizid.equals(that.bizid) : that.bizid != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (level1Code != null ? !level1Code.equals(that.level1Code) : that.level1Code != null) return false;
        if (level2Code != null ? !level2Code.equals(that.level2Code) : that.level2Code != null) return false;
        if (level3Code != null ? !level3Code.equals(that.level3Code) : that.level3Code != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (supportPayTime != null ? !supportPayTime.equals(that.supportPayTime) : that.supportPayTime != null)
            return false;
        if (moneyResource != that.moneyResource) return false;
        if (state != that.state) return false;
        if (interestType != that.interestType) return false;
        if (isSupportAssend != that.isSupportAssend) return false;
        if (isEnabledLadder != that.isEnabledLadder) return false;
        return loanType == that.loanType;
    }

    @Override
    public int hashCode() {
        int result = bizid != null ? bizid.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (level1Code != null ? level1Code.hashCode() : 0);
        result = 31 * result + (level2Code != null ? level2Code.hashCode() : 0);
        result = 31 * result + (level3Code != null ? level3Code.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (supportPayTime != null ? supportPayTime.hashCode() : 0);
        result = 31 * result + (moneyResource != null ? moneyResource.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (isSupportAssend != null ? isSupportAssend.hashCode() : 0);
        result = 31 * result + (isEnabledLadder != null ? isEnabledLadder.hashCode() : 0);
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        return result;
    }

    public ProductInfoDTO() {
    }

}
