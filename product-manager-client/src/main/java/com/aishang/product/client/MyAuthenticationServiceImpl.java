package com.aishang.product.client;

import com.google.common.collect.Lists;
import com.hc.rule.manager.facade.dto.info.AdminGroupInfoDTO;
import com.hc.rule.manager.facade.dto.info.AdminInfoDTO;
import com.hc.rule.manager.facade.dto.request.AdminLoginRequestDTO;
import com.hc.rule.manager.facade.dto.response.AdminLoginResponseDTO;
import com.hc.rule.manager.facade.dto.response.LeafGroupListResponseDTO;
import com.hc.rule.manager.facade.http.SpringSecurityService;
import com.hc.support.springsecurity.service.MyAuthenticationService;
import com.hc.support.springsecurity.service.SecurityUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Service("myAuthenticationService")
public class MyAuthenticationServiceImpl extends MyAuthenticationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SpringSecurityService springSecurityService;
    @Value("${rule.manager.system.baseurl}")
    private String ruleManagerBaseUrl;

    @Override
    public LinkedHashMap<Object, Collection<ConfigAttribute>> loadNodeRole(String appcode) {
        if (super.appcode != null && !super.appcode.isEmpty()) {
            appcode = super.appcode;
        }
        LeafGroupListResponseDTO responseDTO = this.springSecurityService.getLeafGroups(this.ruleManagerBaseUrl, appcode);

        if (responseDTO == null || !responseDTO.isSuccess() || !responseDTO.isExecuted()) {
            logger.warn("load node role failed,appcode:{},response:{}", appcode, responseDTO);
            throw new AuthenticationServiceException(String.format("load node role failed,appcode:%s", appcode));
        }
        LinkedHashMap<Object, Collection<ConfigAttribute>> leaf_group = parseNodeRole(responseDTO.getLeaf_group());
        logger.warn("load node role successfully,appcode:{},noderole:{}", appcode, leaf_group);
        return leaf_group;
    }

    @Override
    public SecurityUser loadByUsername(String appcode, String username) {
        if (super.appcode != null && !super.appcode.isEmpty()) {
            appcode = super.appcode;
        }
        AdminLoginRequestDTO requestDTO = new AdminLoginRequestDTO();
        requestDTO.setAppCode(appcode);
        requestDTO.setLoginname(username);
        requestDTO.setPassword("INIT");
        System.out.println(requestDTO);
        final AdminLoginResponseDTO responseDTO = this.springSecurityService.getAdminByUsername(this.ruleManagerBaseUrl, requestDTO);
        if (!responseDTO.isSuccess() || !responseDTO.isExecuted()) {
            logger.warn("load user by username:{} failed,response:{}", username, responseDTO);
            return null;
        }
        AdminInfoDTO adminDTO = responseDTO.getAdmin();

        List<String> groups = Lists.newArrayList();
        if (adminDTO.getGroups() != null) {
            for (AdminGroupInfoDTO group : adminDTO.getGroups()) {
                groups.add(group.getCode());
            }
        }
        SecurityUser user = new SecurityUser(username, adminDTO.getPassword(), true, true, true, true, this.parseRole(groups));
        user.setBusiUserDetail(adminDTO);
        requestDTO.setPassword("INIT");
        return user;
    }

}
