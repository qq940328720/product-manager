package com.aishang.product.facade.dto.response;


import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import com.aishang.product.facade.dto.info.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 查询产品列表的条件的请求实体
 * Created by ylj on 17-10-6.
 */
@ApiModel(description = "查询响应实体")
public class ProductQryResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "产品信息", required = false)
    ProductInfoDTO productInfoDTO;
    @ApiModelProperty(value = "提成方案列表", required = false)
    List<CommissionConfigInfoDTO> commissionConfigInfos;
    @ApiModelProperty(value = "提成方案排序分组列表", required = false)
    List<CommissionArray> commissionArray;
    @ApiModelProperty(value = "分润配置列表", required = false)
    List<RepaymentInfoDTO> repaymentInfoDTO;
    @ApiModelProperty(value = "支持期数列表", required = false)
    List<SupportTimeInfoDTO> supportTimeInfos;
    @ApiModelProperty(value = "经营范围")
    StoreConfigTreeInfoDTO storeConfigInfo;
    @ApiModelProperty(value = "经营范围(Only Checked)")
    StoreConfigTreeInfoDTO storeConfigInfoChecked;

    public StoreConfigTreeInfoDTO getStoreConfigInfoChecked() {
        return storeConfigInfoChecked;
    }

    public void setStoreConfigInfoChecked(StoreConfigTreeInfoDTO storeConfigInfoChecked) {
        this.storeConfigInfoChecked = storeConfigInfoChecked;
    }

    public StoreConfigTreeInfoDTO getStoreConfigInfo() {
        return storeConfigInfo;
    }

    public void setStoreConfigInfo(StoreConfigTreeInfoDTO storeConfigInfo) {
        this.storeConfigInfo = storeConfigInfo;
    }

    public List<CommissionArray> getCommissionArray() {
        return commissionArray;
    }

    public void setCommissionArray(List<CommissionArray> commissionArray) {
        this.commissionArray = commissionArray;
    }

    public List<RepaymentInfoDTO> getRepaymentInfoDTO() {
        return repaymentInfoDTO;
    }

    public void setRepaymentInfoDTO(List<RepaymentInfoDTO> repaymentInfoDTO) {
        this.repaymentInfoDTO = repaymentInfoDTO;
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


    public List<SupportTimeInfoDTO> getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List<SupportTimeInfoDTO> supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }
}
