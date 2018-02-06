package com.aishang.product.facade.dto.out;

import com.aishang.product.common.enums.InterestTypeEnum;
import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ylj on 17-11-23.
 */
public class AppPruductInfoResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "计息方式")
    private InterestTypeEnum interestType;
    @ApiModelProperty(value = "总利率")
    private BigDecimal totalRate;
    @ApiModelProperty(value = "支持期数")
    List<AppSupportTimeInfoDTO> supportTimeInfos;
    @ApiModelProperty(value = "是否有提前还款包 0:没有 １:有")
    private Integer isPrePay;
    @ApiModelProperty(value = "提前还款包值(元)")
    private BigDecimal prePayValue;

    public Integer getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(Integer isPrePay) {
        this.isPrePay = isPrePay;
    }

    public BigDecimal getPrePayValue() {
        return prePayValue;
    }

    public void setPrePayValue(BigDecimal prePayValue) {
        this.prePayValue = prePayValue;
    }

    public List<AppSupportTimeInfoDTO> getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List<AppSupportTimeInfoDTO> supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        this.totalRate = totalRate;
    }

    public InterestTypeEnum getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestTypeEnum interestType) {
        this.interestType = interestType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
