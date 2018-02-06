package com.aishang.product.facade.dto.request;

import com.aishang.product.common.enums.ProductStateEnum;
import com.aishang.product.facade.dto.base.RuleBaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 查询产品列表的条件的请求实体
 * Created by ylj on 17-10-3.
 */
@ApiModel(description = "查询产品列表的条件的请求实体")
public class ProductConditionDTO extends RuleBaseRequestDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品类型1", required = false)
    private String type1;
    @ApiModelProperty(value = "产品类型2", required = false)
    private String type2;
    @ApiModelProperty(value = "产品类型3", required = false)
    private String type3;
    @ApiModelProperty(value = "产品状态", required = false)
    private ProductStateEnum state;
    @ApiModelProperty(value = "产品名称关键字", required = false)
    private String keyofname;
    @ApiModelProperty(value = "页码", required = false)
    private Integer page;
    @ApiModelProperty(value = "每页行数", required = false)
    private Integer size;

    public ProductConditionDTO() {
        this.page = 1;
        this.size = 20;
    }

    public ProductConditionDTO(Integer page, Integer size) {
        if (1 > page) {
            page = 1;
        }

        if (1 > size) {
            size = 20;
        }
        this.page = page;
        this.size = size;
    }

    public int getOffset() {
        return (this.page - 1) * this.size;
    }


    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getType3() {
        return type3;
    }

    public ProductStateEnum getState() {
        return state;
    }

    public String getKeyofname() {
        return keyofname;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public void setState(ProductStateEnum state) {
        this.state = state;
    }

    public void setKeyofname(String keyofname) {
        this.keyofname = keyofname;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ProductConditionDTO{" +
                "type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", type3='" + type3 + '\'' +
                ", state=" + state +
                ", keyofname='" + keyofname + '\'' +
                ", page=" + page +
                ", size=" + size +
                "} " + super.toString();
    }
}
