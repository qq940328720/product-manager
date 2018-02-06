package com.aishang.product.facade.dto.out;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by ylj on 18-1-2.
 */
public class ProductPrePayResponseDTO extends RuleBaseResponseDTO {

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
}
