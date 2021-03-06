package com.aishang.product.adapter.impl;


import com.aishang.product.facade.service.UserRuleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UserRuleServiceImpl<T> implements UserRuleService {

    @Value("${rule.manager.system.baseurl}")
    private String ruleManagerBaseUrl;
    @Value("${app.code}")
    private String appCode;


}
