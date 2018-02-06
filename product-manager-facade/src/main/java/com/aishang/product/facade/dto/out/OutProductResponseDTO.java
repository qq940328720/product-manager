package com.aishang.product.facade.dto.out;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;

/**
 * Created by ylj on 17-12-26.
 */
public class OutProductResponseDTO extends RuleBaseResponseDTO {

    private Object resultData;

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
