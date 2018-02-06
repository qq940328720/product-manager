package com.aishang.product.facade.dto.base;

import com.hc.mvc.core.dto.base.BaseResponseDTO;

public class RuleBaseResponseDTO extends BaseResponseDTO {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

//	private Object resultData;

    public void handleFailed() {
        this.setSuccess(true).setExecuted(false);
    }

    public void successfully() {
        this.setSuccess(true).setExecuted(true);
    }
//	public Object getResultData() {
//		return resultData;
//		//return resultData = resultData == null ? null : resultData.toString(); 
//	}
//	public void setResultData(Object resultData) {
//		this.resultData = resultData;
//	}

}
