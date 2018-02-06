package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.info.CommissionConfigInfoDTO;

import java.util.List;

/**
 * Created by ylj on 17-10-17.
 */
public class CommissionArray {

    List<CommissionConfigInfoDTO> commission;

    public List<CommissionConfigInfoDTO> getCommission() {
        return commission;
    }

    public void setCommission(List<CommissionConfigInfoDTO> commission) {
        this.commission = commission;
    }
}
