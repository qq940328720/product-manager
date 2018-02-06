package com.aishang.product.web.controller.base;

import com.alibaba.fastjson.JSONObject;
import exception.MyBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final static String PATH_PRE_REST = "rest";
    protected final static String ADMIN_SESSION_KEY = "_admin_session_key";


    public String getLoginUserSession() throws MyBizException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("1:"+request.toString());
        Object obj = request.getSession().getAttribute(ADMIN_SESSION_KEY);
        if (obj == null) {
            throw new MyBizException("无登录用户信息");
        }
        String StrObj = JSONObject.toJSONString(obj);
        JSONObject jsonUser = JSONObject.parseObject(StrObj);
        String adminCode = jsonUser.getString("code");
        return adminCode;
    }
}