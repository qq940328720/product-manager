package com.aishang.product.facade.dto.info;

import com.aishang.product.common.enums.PaytimeUnitEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支持期数
 * Created by ylj on 17-10-6.
 */
@ApiModel(description = "支持期数实体信息")
public class SupportTimeInfoDTO {

    @ApiModelProperty(value = "产品编号")
    private String productCode;
    @ApiModelProperty(value = "支持期数")
    private Integer payTime;
    @ApiModelProperty(value = "支持期数单位")
    private PaytimeUnitEnum paytimeUnit;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

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
