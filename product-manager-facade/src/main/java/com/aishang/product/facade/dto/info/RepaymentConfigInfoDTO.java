package com.aishang.product.facade.dto.info;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 还款包源配置
 * Created by ylj on 17-10-6.
 */
@ApiModel(description = "还款包源配置实体信息")
public class RepaymentConfigInfoDTO {

    @ApiModelProperty(value = "产品编号")
    private String productCode;
    @ApiModelProperty(value = "还款包编号")
    private String packageCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }


}
