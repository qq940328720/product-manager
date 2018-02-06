package com.aishang.product.facade.dto.out;

import com.aishang.product.common.enums.AlgorithmTypeEnum;
import com.aishang.product.common.enums.PaytimeTypeEnum;
import com.aishang.product.common.enums.YesOrNoEnum;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by ylj on 17-12-26.
 */
public class OutRepayPackageInfoDTO {

    @ApiModelProperty(value = "还款包名编号")
    private String packageCode;
    @ApiModelProperty(value = "还款包名")
    private String name;
    @ApiModelProperty(value = "利息")
    private BigDecimal value;
    @ApiModelProperty(value = "算法类型")
    private AlgorithmTypeEnum type;  //1.乘算法 2.加算法
    @ApiModelProperty(value = "还款类型")
    private PaytimeTypeEnum paytimeType;  //1.年 2.月 3.日
    @ApiModelProperty(value = "是否必选")
    private YesOrNoEnum isChoice;  //是否必选 0.否 1.是

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

    public AlgorithmTypeEnum getType() {
        return type;
    }

    public void setType(AlgorithmTypeEnum type) {
        this.type = type;
    }

    public PaytimeTypeEnum getPaytimeType() {
        return paytimeType;
    }

    public void setPaytimeType(PaytimeTypeEnum paytimeType) {
        this.paytimeType = paytimeType;
    }

    public YesOrNoEnum getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(YesOrNoEnum isChoice) {
        this.isChoice = isChoice;
    }
}
