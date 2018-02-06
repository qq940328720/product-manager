package com.aishang.product.web.controller;


import com.aishang.product.facade.service.UserRuleService;
import com.aishang.product.web.controller.base.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.hc.mvc.core.enums.ContentType;
import exception.MyBizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：  获取用户所属菜单信息
 * 类名: UserController
 * 作者: maxing
 * 时间: 2017年9月27日
 */
@Api(value = "/userRule", description = "获取用户所属菜单信息")
@RestController
@RequestMapping( "/userRule" )
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRuleController extends BaseController {

	@Autowired
	private UserRuleService userRuleService;

	@ApiOperation(value = "查询用户所属菜单信息", notes = "查询用户所属菜单信息")
	@RequestMapping(value = "/rule", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
	public JSONObject getSubDepartment() {
		JSONObject jsonObject = null;
		try {
			String adminCode = getLoginUserSession();
			jsonObject = this.userRuleService.getuserRule(adminCode);
		} catch (MyBizException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}


}


