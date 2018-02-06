package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ylj on 17-10-11.
 */
@XmlRootElement(name = "productEnumModelDTO")
public class ProductTypeResponseDTO extends RuleBaseResponseDTO {

    List<ProductEnumModelDTO> productEnumModels;

    public List<ProductEnumModelDTO> getProductEnumModels() {
        return productEnumModels;
    }

    public void setProductEnumModels(List<ProductEnumModelDTO> productEnumModels) {
        this.productEnumModels = productEnumModels;
    }
}
