package com.aishang.product.facade.service;


import com.alibaba.fastjson.JSONObject;
import exception.MyBizException;

public interface UserRuleService {	
	
	/**
	 * 动态查询
	 * @param
	 * @return
	 */
	public JSONObject getuserRule(String adminCode) throws MyBizException;


}
