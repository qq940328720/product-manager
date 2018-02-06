package com.aishang.product.facade.dto.out;

import com.aishang.product.common.enums.PaytimeUnitEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-11-21.
 */
public class AppSupportTimeInfoDTO {

    @ApiModelProperty(value = "支持期数")
    private Integer payTime;
    @ApiModelProperty(value = "支持期数单位")
    private PaytimeUnitEnum paytimeUnit;

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public PaytimeUnitEnum getPaytimeUnit() {
        return paytimeUnit;
    }

    public void setPaytimeUnit(PaytimeUnitEnum paytimeUnit) {
        this.paytimeUnit = paytimeUnit;
    }
}
