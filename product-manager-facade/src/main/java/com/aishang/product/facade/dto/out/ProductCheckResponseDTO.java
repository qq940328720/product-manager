package com.aishang.product.facade.dto.out;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-11-30.
 */
public class ProductCheckResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "是否可用　true：可用　false：不可用")
    boolean isCanUsed;

    public boolean getIsCanUsed() {
        return isCanUsed;
    }

    public void setIsCanUsed(boolean canUsed) {
        isCanUsed = canUsed;
    }
}
