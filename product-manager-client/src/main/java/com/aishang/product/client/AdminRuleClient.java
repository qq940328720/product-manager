package com.aishang.product.client;

import com.google.common.collect.Maps;
import com.hc.rule.manager.facade.dto.info.TreeLeafInfoDTO;
import com.hc.rule.manager.facade.dto.response.AdminResponseDTO;
import com.hc.rule.manager.facade.http.SpringSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("adminRuleClient")
public class AdminRuleClient {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SpringSecurityService springSecurityService;
    @Value("${rule.manager.system.baseurl}")
    private String ruleManagerBaseUrl;
    @Value("${app.code}")
    private String appCode;

    public Map<String, String> getAdminRuleKey(String admincode) {
        AdminResponseDTO responseDTO = this.springSecurityService.getAdminRules(this.ruleManagerBaseUrl, this.appCode, admincode, false);
        if (responseDTO == null || !responseDTO.isSuccess() || !responseDTO.isExecuted() || responseDTO.getAdmin() == null) {
            this.logger.warn("get admin rule request failed,appcode:{},admincode:{},res:{}", this.appCode, admincode, responseDTO);
            return null;
        }

        List<TreeLeafInfoDTO> treeLeafs = responseDTO.getAdmin().getLeafs();
        if (treeLeafs == null || treeLeafs.isEmpty()) {
            this.logger.warn("get admin rule request success but res treeleaf is empty,appcode:{},admincode:{},res:{}", this.appCode,
                    admincode, responseDTO);
            return null;
        }
        Map<String, String> ruleMap = Maps.newHashMap();
        for (TreeLeafInfoDTO dto : treeLeafs) {
            ruleMap.put(dto.getKey(), dto.getCode());
        }
        return ruleMap;

    }

    public AdminResponseDTO getAdminName(String adminCode) {
        AdminResponseDTO responseDTO = this.springSecurityService.getAdminByCode(this.ruleManagerBaseUrl, this.appCode, adminCode);
        if (responseDTO == null || !responseDTO.isSuccess() || !responseDTO.isExecuted() || responseDTO.getAdmin() == null) {
            this.logger.warn("get admin code request failed,appcode:{},admincode:{},res:{}", this.appCode, adminCode, responseDTO);
            return null;
        }
        return responseDTO;
    }

}
