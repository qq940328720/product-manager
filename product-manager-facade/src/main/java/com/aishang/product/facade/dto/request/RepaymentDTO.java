package com.aishang.product.facade.dto.request;

import com.aishang.product.common.enums.AlgorithmTypeEnum;
import com.aishang.product.common.enums.PaytimeTypeEnum;
import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-10-6.
 */
public class RepaymentDTO extends RuleBaseRequestDTO {

    @ApiModelProperty(value = "还款包名")
    private String name;
    @ApiModelProperty(value = "算法类型")
    private AlgorithmTypeEnum type;  //1.乘算法 2.加算法
    @ApiModelProperty(value = "还款类型")
    private PaytimeTypeEnum paytimeType;  //1.年 2.月 3.日

    public RepaymentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
