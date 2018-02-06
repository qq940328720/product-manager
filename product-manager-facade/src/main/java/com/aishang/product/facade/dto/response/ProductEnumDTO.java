package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ylj on 17-10-6.
 */
@XmlRootElement(name = "productEnumDTO")
public class ProductEnumDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "产品状态", required = false)
    List<ProductEnumModelDTO> productStates;
    @ApiModelProperty(value = "支持期数单位", required = false)
    List<ProductEnumModelDTO> supportTimes;
    @ApiModelProperty(value = "职位", required = false)
    List<ProductEnumModelDTO> positions;
    @ApiModelProperty(value = "提成方式", required = false)
    List<ProductEnumModelDTO> commissions;
    @ApiModelProperty(value = "计息方式", required = false)
    List<ProductEnumModelDTO> interests;
    @ApiModelProperty(value = "资金渠道", required = false)
    List<ProductEnumModelDTO> moneyresources;
    @ApiModelProperty(value = "放款类型", required = false)
    List<ProductEnumModelDTO> loantypes;
    @ApiModelProperty(value = "启用原因", required = false)
    List<ProductEnumModelDTO> enableds;
    @ApiModelProperty(value = "禁用原因", required = false)
    List<ProductEnumModelDTO> unableds;
    @ApiModelProperty(value = "删除原因", required = false)
    List<ProductEnumModelDTO> deleteds;
//    @ApiModelProperty(value = "业务范围", required = false)
//    List<ProductEnumModelDTO> businessareas;

    public List<ProductEnumModelDTO> getProductStates() {
        return productStates;
    }

    public void setProductStates(List<ProductEnumModelDTO> productStates) {
        this.productStates = productStates;
    }

    public List<ProductEnumModelDTO> getEnableds() {
        return enableds;
    }

    public void setEnableds(List<ProductEnumModelDTO> enableds) {
        this.enableds = enableds;
    }

    public List<ProductEnumModelDTO> getUnableds() {
        return unableds;
    }

    public void setUnableds(List<ProductEnumModelDTO> unableds) {
        this.unableds = unableds;
    }

    public List<ProductEnumModelDTO> getDeleteds() {
        return deleteds;
    }

    public void setDeleteds(List<ProductEnumModelDTO> deleteds) {
        this.deleteds = deleteds;
    }

    public List<ProductEnumModelDTO> getSupportTimes() {
        return supportTimes;
    }

    public void setSupportTimes(List<ProductEnumModelDTO> supportTimes) {
        this.supportTimes = supportTimes;
    }

    public List<ProductEnumModelDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<ProductEnumModelDTO> positions) {
        this.positions = positions;
    }

    public List<ProductEnumModelDTO> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<ProductEnumModelDTO> commissions) {
        this.commissions = commissions;
    }

    public List<ProductEnumModelDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<ProductEnumModelDTO> interests) {
        this.interests = interests;
    }

    public List<ProductEnumModelDTO> getMoneyresources() {
        return moneyresources;
    }

    public void setMoneyresources(List<ProductEnumModelDTO> moneyresources) {
        this.moneyresources = moneyresources;
    }

    public List<ProductEnumModelDTO> getLoantypes() {
        return loantypes;
    }

    public void setLoantypes(List<ProductEnumModelDTO> loantypes) {
        this.loantypes = loantypes;
    }
}
