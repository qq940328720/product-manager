package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import com.aishang.product.facade.dto.info.DictionaryInfoDTO;
import com.aishang.product.facade.dto.info.ProductInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by whb on 17-10-16.
 */
@XmlRootElement(name = "dictonaryResponseDTO")
public class DictonaryResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "总条数", required = false)
    private Integer total;
    @ApiModelProperty(value = "分页列表", required = false)
    private List<DictionaryInfoDTO> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DictionaryInfoDTO> getList() {
        return list;
    }

    public void setList(List<DictionaryInfoDTO> list) {
        this.list = list;
    }
}
