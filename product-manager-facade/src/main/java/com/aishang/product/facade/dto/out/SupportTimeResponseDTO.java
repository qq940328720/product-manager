package com.aishang.product.facade.dto.out;


import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;

import java.util.List;

/**
 * 支持其数
 * Created by ylj on 17-11-18.
 */
public class SupportTimeResponseDTO extends RuleBaseResponseDTO {

    List<SupportTimeInfoDTO> supportTimes;

    public List<SupportTimeInfoDTO> getSupportTimes() {
        return supportTimes;
    }

    public void setSupportTimes(List<SupportTimeInfoDTO> supportTimes) {
        this.supportTimes = supportTimes;
    }
}
