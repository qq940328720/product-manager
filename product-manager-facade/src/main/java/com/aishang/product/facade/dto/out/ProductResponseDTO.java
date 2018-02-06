package com.aishang.product.facade.dto.out;


import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;

import java.util.List;

/**
 * Created by ylj on 17-11-18.
 */
public class ProductResponseDTO extends RuleBaseResponseDTO {

    private List<ProductInfoDTO> data;

    @Override
    public List<ProductInfoDTO> getData() {
        return data;
    }

    public void setData(List<ProductInfoDTO> data) {
        this.data = data;
    }
}
