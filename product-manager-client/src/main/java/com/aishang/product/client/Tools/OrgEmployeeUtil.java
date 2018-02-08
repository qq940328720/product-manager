package com.aishang.product.client.Tools;

import com.aishang.product.client.OrgEmployeeResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ylj on 17-10-28.
 */
@Component
public class OrgEmployeeUtil {

    @Value("${organization.url}")
    private String url;


    public OrgEmployeeResponseDTO getEmployeeCode(String adminCode) {
//        adminCode = "ADMIN2017102315234839";
        if (StringUtils.isBlank(adminCode))
            return null;
        else {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String orgurl = url + adminCode + "/getEmployeeCode";
                String xmlResult = restTemplate.getForObject(orgurl, String.class);
                OrgEmployeeResponseDTO responseDTO = new ObjectMapper().readValue(xmlResult, OrgEmployeeResponseDTO.class);
                return responseDTO;
            } catch (Exception e) {
                return null;
            }
        }
    }
}