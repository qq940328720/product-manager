package com.aishang.product.facade.dto.out;

import com.aishang.product.common.enums.*;
import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-12-6.
 */
public class ProductInfoResponseDTO extends RuleBaseResponseDTO {
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

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
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

    public YesOrNoEnum getIsSupportAssend() {
        return isSupportAssend;
    }

    public void setIsSupportAssend(YesOrNoEnum isSupportAssend) {
        this.isSupportAssend = isSupportAssend;
    }

    public YesOrNoEnum getIsEnabledLadder() {
        return isEnabledLadder;
    }

    public void setIsEnabledLadder(YesOrNoEnum isEnabledLadder) {
        this.isEnabledLadder = isEnabledLadder;
    }

    public LoanTypeEnum getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeEnum loanType) {
        this.loanType = loanType;
    }
}
