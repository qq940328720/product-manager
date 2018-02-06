package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-10-18.
 */
public class OrganizationTreeResponseDTO extends RuleBaseResponseDTO {

//
//    private Boolean success;
//    private Boolean executed;
//    private String message;

    @ApiModelProperty(value = "数据")
    OrganizationTreeNodes data;

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Boolean getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Boolean success) {
//        this.success = success;
//    }
//
//    public Boolean getExecuted() {
//        return executed;
//    }
//
//    public void setExecuted(Boolean executed) {
//        this.executed = executed;
//    }

    public OrganizationTreeNodes getData() {
        return data;
    }

    public void setData(OrganizationTreeNodes data) {
        this.data = data;
    }
}
