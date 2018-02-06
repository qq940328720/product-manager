package com.aishang.product.adapter.impl;


import com.aishang.product.facade.service.UserRuleService;
import com.alibaba.fastjson.JSONObject;
import com.hc.mvc.core.service.base.MyBaseService;
import com.hc.rule.manager.facade.dto.response.AdminResponseDTO;
import com.hc.rule.manager.facade.http.SpringSecurityService;
import exception.MyBizException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserRuleServiceImpl<T> extends MyBaseService implements UserRuleService {

	@Resource
	private SpringSecurityService springSecurityService;
	@Value("${rule.manager.system.baseurl}")
	private String ruleManagerBaseUrl;
	@Value("${app.code}")
	private String appCode;

	
	@Override
	public JSONObject getuserRule(String adminCode) throws MyBizException {
		AdminResponseDTO adminRules = springSecurityService.getAdminRules(ruleManagerBaseUrl, appCode, adminCode, true);
		String StrObj = JSONObject.toJSONString(adminRules);
		JSONObject jsonUser = JSONObject.parseObject(StrObj);
		System.out.println("返回数据:"+jsonUser);
		return jsonUser;
	}
	
	
}
