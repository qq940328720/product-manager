package com.aishang.product.facade.dto.request;

import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改产品状态的请求实体
 * Created by ylj on 17-10-3.
 */
@ApiModel(description = "修改产品状态的请求实体")
public class UpdProductStateDTO extends RuleBaseRequestDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品状态", required = false)
    private String proState;
    @ApiModelProperty(value = "当前状态备注", required = false)
    private String stateRemarks;

    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    public String getStateRemarks() {
        return stateRemarks;
    }

    public void setStateRemarks(String stateRemarks) {
        this.stateRemarks = stateRemarks;
    }
}
