package com.aishang.product.facade.dto.base;

import com.hc.mvc.core.dto.base.BaseRequestDTO;

public abstract class RuleBaseRequestDTO extends BaseRequestDTO {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    protected static final String YYYY_MM_DDSTR = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";

    @Override
    public void valid() {
        super.validate(this);
    }

    @Override
    protected boolean isValidGid() {
        // TODO Auto-generated method stub
        return false;
    }


}
