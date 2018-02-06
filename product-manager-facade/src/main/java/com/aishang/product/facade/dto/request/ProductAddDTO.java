package com.aishang.product.facade.dto.request;


import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import com.aishang.product.facade.dto.info.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 添加产品的请求实体
 * Created by ylj on 17-10-6.
 */
@ApiModel(description = "添加产品的请求实体")
public class ProductAddDTO extends RuleBaseRequestDTO {

    @ApiModelProperty(value = "产品信息", required = false)
    ProductInfoDTO productInfoDTO;
    @ApiModelProperty(value = "分润配置列表", required = false)
    List<CommissionConfigInfoDTO> commissionConfigInfos;
    @ApiModelProperty(value = "还款包源配置列表", required = false)
    List<RepaymentConfigInfoDTO> repaymentConfigInfos;
    @ApiModelProperty(value = "支持期数列表", required = false)
    List<SupportTimeInfoDTO> supportTimeInfos;
    @ApiModelProperty(value = "经营范围")
    List<StoreConfigInfoDTO> storeConfigInfoS;

    public List<StoreConfigInfoDTO> getStoreConfigInfoS() {
        return storeConfigInfoS;
    }

    public void setStoreConfigInfoS(List<StoreConfigInfoDTO> storeConfigInfoS) {
        this.storeConfigInfoS = storeConfigInfoS;
    }

    public ProductInfoDTO getProductInfoDTO() {
        return productInfoDTO;
    }

    public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
        this.productInfoDTO = productInfoDTO;
    }

    public List<CommissionConfigInfoDTO> getCommissionConfigInfos() {
        return commissionConfigInfos;
    }

    public void setCommissionConfigInfos(List<CommissionConfigInfoDTO> commissionConfigInfos) {
        this.commissionConfigInfos = commissionConfigInfos;
    }

    public List<RepaymentConfigInfoDTO> getRepaymentConfigInfos() {
        return repaymentConfigInfos;
    }

    public void setRepaymentConfigInfos(List<RepaymentConfigInfoDTO> repaymentConfigInfos) {
        this.repaymentConfigInfos = repaymentConfigInfos;
    }

    public List<SupportTimeInfoDTO> getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List<SupportTimeInfoDTO> supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }
}
