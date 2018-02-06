package com.aishang.product.facade.dto.out;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;

import java.util.List;

/**
 * Created by ylj on 17-11-21.
 */
public class AppProductResponseDTO extends RuleBaseResponseDTO {

    List<AppProductInfoDTO> resultData;

    public List<AppProductInfoDTO> getResultData() {
        return resultData;
    }

    public void setResultData(List<AppProductInfoDTO> resultData) {
        this.resultData = resultData;
    }
}
