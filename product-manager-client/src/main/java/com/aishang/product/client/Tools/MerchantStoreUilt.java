package com.aishang.product.client.Tools;

import com.aishang.product.facade.dto.response.OrganizationTreeResponseDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Lazy(false)
@EnableScheduling
public class MerchantStoreUilt {

    @Value("${merchant.url}")
    private String url;


    public OrganizationTreeResponseDTO getBelongOrgsByAdminCode(String adminCode) {
        if (StringUtils.isBlank(adminCode))
            return null;
        else {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String orgurl = url + adminCode;
                String xmlResult = restTemplate.getForObject(orgurl, String.class);

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//ObjectMapper转换忽略多余字段
                OrganizationTreeResponseDTO tree = objectMapper.readValue(xmlResult, OrganizationTreeResponseDTO.class);
                return tree;
            } catch (Exception e) {
                return null;
            }
        }
    }
}