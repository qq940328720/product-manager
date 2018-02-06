package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import com.aishang.product.facade.dto.info.ProductInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ylj on 17-10-3.
 */
@XmlRootElement(name = "productInfoDTO")
public class ProductResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "总条数", required = false)
    private Integer total;
    @ApiModelProperty(value = "分页列表", required = false)
    private List<ProductInfoDTO> productInfoDTOS;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ProductInfoDTO> getProductInfoDTOS() {
        return productInfoDTOS;
    }

    public void setProductInfoDTOS(List<ProductInfoDTO> productInfoDTOS) {
        this.productInfoDTOS = productInfoDTOS;
    }

    @Override
    public String toString() {
        return "ProductResponseDTO{" +
                "total=" + total +
                ", productInfoDTOS=" + productInfoDTOS +
                '}';
    }
}
