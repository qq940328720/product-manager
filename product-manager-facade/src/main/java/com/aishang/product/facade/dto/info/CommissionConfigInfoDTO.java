package com.aishang.product.facade.dto.info;

import com.aishang.product.common.enums.CommissionTypeEnum;
import com.aishang.product.common.enums.PositionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 分润配置
 * Created by ylj on 17-10-6.
 */
@ApiModel(description = "分润配置实体信息")
public class CommissionConfigInfoDTO {

    @ApiModelProperty(value = "产品编号")
    private String productCode;

    @ApiModelProperty(value = "所配置职位")
    private PositionEnum position;          //1 销售总监 2 大区总监 3 省区总监 4 城市经理 5 区域经理 6 业务主管、金融顾问

    @ApiModelProperty(value = "提成方式")
    private CommissionTypeEnum commissionType;         //1.金额提成 2.单量提成

    @ApiModelProperty(value = "提成")
    private BigDecimal commission;

    @ApiModelProperty(value = "阶梯上限")
    private Integer upperLimit;

    @ApiModelProperty(value = "阶梯下限")
    private Integer lowerLimit;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public CommissionTypeEnum getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionTypeEnum commissionType) {
        this.commissionType = commissionType;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

}
