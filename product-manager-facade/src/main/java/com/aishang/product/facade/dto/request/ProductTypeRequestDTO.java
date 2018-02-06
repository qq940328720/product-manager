package com.aishang.product.facade.dto.request;

import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 17-10-11.
 */
@ApiModel(description = "查询产品分类的请求实体")
public class ProductTypeRequestDTO extends RuleBaseRequestDTO {

    @ApiModelProperty(value = "分类编码")
    private String typeCode;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
