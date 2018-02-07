package com.aishang.product.adapter.impl;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.hc.common.logback.SystemCode;
import com.hc.mvc.core.dto.base.BaseRequestDTO;
import com.hc.mvc.core.dto.base.BaseResponseDTO;
import com.hc.mvc.core.dto.base.ResponseCodeEnums;
import com.hc.mvc.core.service.base.InstantiateUtils;
import com.hc.mvc.core.service.base.Reflections;
import com.hc.mvc.core.service.base.ServiceExecutor;

public abstract class MyServiceExecutor<REQUEST extends BaseRequestDTO, RESPONSE extends BaseResponseDTO>
        extends ServiceExecutor<REQUEST, RESPONSE> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected RESPONSE process(HttpServletRequest request, HttpServletResponse response, REQUEST requestDTO) throws Exception {
        Class<RESPONSE> responseClass = Reflections.getClassGenricType(this.getClass(), 1);
        RESPONSE responseDTO = InstantiateUtils.instantiate(responseClass);
        try {
            return this.myprocess(request, response, requestDTO);
        } catch (Exception e) {
            this.logger.error(SystemCode.EXCEPTION, "process", e);
            responseDTO.setSuccess(true).setExecuted(false).setResponseCode(ResponseCodeEnums.DATABASE_EXCEPTION)
                    .setMessage("数据重复");
            return responseDTO;
        }
    }

    @Override
    protected RESPONSE process(REQUEST requestDTO) throws Exception {
        Class<RESPONSE> responseClass = Reflections.getClassGenricType(this.getClass(), 1);
        RESPONSE responseDTO = InstantiateUtils.instantiate(responseClass);
        try {
            return this.myprocess(requestDTO);
        } catch (Exception e) {
            this.logger.error(SystemCode.EXCEPTION, "process", e);
            responseDTO.setSuccess(true).setExecuted(false).setResponseCode(ResponseCodeEnums.DATABASE_EXCEPTION)
                    .setMessage("数据重复");
            return responseDTO;
        }
    }

    protected RESPONSE myprocess(HttpServletRequest request, HttpServletResponse response, REQUEST requestDTO) throws Exception {
        return null;
    }

    protected RESPONSE myprocess(REQUEST requestDTO) throws Exception {
        return null;
    }

}
