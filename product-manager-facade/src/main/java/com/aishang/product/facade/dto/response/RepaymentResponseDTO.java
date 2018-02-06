package com.aishang.product.facade.dto.response;

import com.aishang.product.facade.dto.base.RuleBaseResponseDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ylj on 17-10-6.
 */
@XmlRootElement(name = "repaymentResponseDTO")
public class RepaymentResponseDTO extends RuleBaseResponseDTO {

    @ApiModelProperty(value = "还款包源关键字列表", required = false)
    List<RepaymentKeysDTO> repaymentKeys;

    public List<RepaymentKeysDTO> getRepaymentKeys() {
        return repaymentKeys;
    }

    public void setRepaymentKeys(List<RepaymentKeysDTO> repaymentKeys) {
        this.repaymentKeys = repaymentKeys;
    }
}
