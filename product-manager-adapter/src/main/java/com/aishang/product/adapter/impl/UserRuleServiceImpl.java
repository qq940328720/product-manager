package com.aishang.product.adapter.impl;


import com.aishang.product.facade.service.UserRuleService;
import com.hc.rule.manager.facade.http.SpringSecurityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserRuleServiceImpl<T> implements UserRuleService {

	@Resource
	private SpringSecurityService springSecurityService;
	@Value("${rule.manager.system.baseurl}")
	private String ruleManagerBaseUrl;
	@Value("${app.code}")
	private String appCode;
	
	
}
