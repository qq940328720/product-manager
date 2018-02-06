package com.aishang.product.facade.dto.request;

import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 删除产品状态的请求实体
 * Created by ylj on 17-10-3.
 */
@ApiModel(description = "启用禁用请求实体")
public class ProductDeleteDTO extends RuleBaseRequestDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原因", required = false)
    private String dataValue;
    @ApiModelProperty(value = "当前状态备注", required = false)
    private String stateRemarks;

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getStateRemarks() {
        return stateRemarks;
    }

    public void setStateRemarks(String stateRemarks) {
        this.stateRemarks = stateRemarks;
    }
}
