package com.aishang.product.client;

import java.util.List;

/**
 * Created by ylj on 17-10-28.
 */
public class OrgEmployeeResponseDTO {


    private Boolean success;
    private Boolean executed;

    private List<OrgEmployeeInfoDTO> code;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getExecuted() {
        return executed;
    }

    public void setExecuted(Boolean executed) {
        this.executed = executed;
    }

    public List<OrgEmployeeInfoDTO> getCode() {
        return code;
    }

    public void setCode(List<OrgEmployeeInfoDTO> code) {
        this.code = code;
    }
}
