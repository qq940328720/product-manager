package com.aishang.product.client.Tools;

import com.aishang.product.client.dto.DictionaryInfo;
import com.aishang.product.client.dto.DictionaryResponse;
import com.aishang.product.client.dto.DictionaryTreeResponse;
import com.aishang.product.dao.DictionaryDao;
import com.aishang.product.dao.DictionaryRelationDao;
import com.aishang.product.model.Dictionary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Lazy(false)
@EnableScheduling
public class DictionryUilt {
    private static final Logger log = Logger.getLogger(DictionryUilt.class);

    @Autowired
    private DictionaryDao dictionaryMapper;
    @Autowired
    private DictionaryRelationDao relationMapper;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Value("${dictionary.url}")
    private String dicUrl;

    /**
     * 定时同步字段表数据（定时时间为晚上12点执行）
     *
     * @throws Exception
     */
    @PostConstruct
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateDictionary() throws Exception {
        System.out.print("实例化完成。。。。。");

        executorService.submit(new Runnable() {
            
            public void run() {

                //同步银行
                RestTemplate restTemplate = new RestTemplate();
                ObjectMapper objectMapper = new ObjectMapper();
//                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//ObjectMapper转换忽略多余字段
//                String urlable = dicUrl + "/dictionarys/getDataGrid?dataType=" + DicType.PROD_ENABLE_REASON.getEnumName();
//                DictionryUilt.this.updateDictionary(restTemplate, objectMapper, urlable);
//                String urldisable = dicUrl + "/dictionarys/getDataGrid?dataType=" + DicType.PROD_DISABLE_REASON.getEnumName();
//                DictionryUilt.this.updateDictionary(restTemplate, objectMapper, urldisable);
//                String urldel = dicUrl + "/dictionarys/getDataGrid?dataType=" + DicType.PROD_DEL_REASON.getEnumName();
//                DictionryUilt.this.updateDictionary(restTemplate, objectMapper, urldel);
//                String urlrole = dicUrl + "/dictionarys/getDataGrid?dataType=" + DicType.PROD_ROLE.getEnumName();
//                DictionryUilt.this.updateDictionary(restTemplate, objectMapper, urlrole);
//                //同步产品类型
//                String urlProduct = dicUrl + "/dictionarys/tree/getDataGrid?treeType=" + DicTreeType.PRODUCT.getEnumName();
//                String xmlResultProduct = restTemplate.getForObject(urlProduct, String.class);
                DictionaryTreeResponse treeResponse = null;
//                if (!StringUtils.isBlank(xmlResultProduct)) {
//                    try {
//                        treeResponse = objectMapper.readValue(xmlResultProduct, DictionaryTreeResponse.class);
//                    } catch (IOException e) {
//                        log.error("ObjectMapper转换字段异常(同步产品类型字典)");
//                    }
//                    if (treeResponse != null && treeResponse.getData() != null && treeResponse.getData().size() > 0) {
//                        for (DictionaryTreeInfo info : treeResponse.getData()) {
//                            Dictionary dictionary = new Dictionary();
//                            dictionary.setDataCode(info.getDataCode());
//                            dictionary.setDataName(info.getDataName());
//                            dictionary.setDataValue(info.getDataValue());
//                            dictionary.setCreateUserId(info.getCreateUserId());
//                            dictionary.setBizid(info.getBizid());
//                            dictionary.setDataRemark(info.getDataRemark());
//                            dictionary.setDataType(info.getDataType());
//                            dictionary.setDeleted(Byte.valueOf("0"));
//                            try {
//                                Integer count = dictionaryMapper.getDataCountByCode(dictionary.getDataCode());
//                                if (count == 0)
//                                    dictionaryMapper.insert(dictionary);
//                                else
//                                    dictionaryMapper.updateByPrimaryKey(dictionary);
//                            } catch (Exception e) {
//                                log.error("同步字典异常" + info.getDataCode() + e.getMessage());
//                            }
//                            DictionaryRelation relation = new DictionaryRelation();
//                            relation.setDataCode(info.getDataCode());
//                            relation.setParentCode(info.getParentCode());
//                            relation.setDeleted(Byte.valueOf("0"));
//                            try {
//                                Integer count = relationMapper.getDataCountByCode(relation.getDataCode(), relation.getParentCode());
//                                if (count == 0)
//                                    relationMapper.insert(relation);
//                                else
//                                    relationMapper.updateByPrimaryKey(relation);
//                            } catch (Exception e) {
//                                log.error("同步字典关系异常" + info.getDataCode() + e.getMessage());
//                            }
//                        }
//                    }
//                }
            }
        });
        executorService.shutdown();

    }

    private void updateDictionary(RestTemplate restTemplate, ObjectMapper objectMapper, String urlBank) {
        String xmlResultBank = null;
        try {
            xmlResultBank = restTemplate.getForObject(urlBank, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        DictionaryResponse dictionaryResponse = null;
        if (!StringUtils.isBlank(xmlResultBank)) {
            try {
                dictionaryResponse = objectMapper.readValue(xmlResultBank, DictionaryResponse.class);
            } catch (IOException e) {
                log.error("ObjectMapper转换字段异常(同步字典)");
            }
            if (dictionaryResponse != null && dictionaryResponse.getData() != null && dictionaryResponse.getData().size() > 0) {
                for (DictionaryInfo info : dictionaryResponse.getData()) {
                    Dictionary dictionary = new Dictionary();
                    dictionary.setDataCode(info.getDataCode());
                    dictionary.setDataName(info.getDataName());
                    dictionary.setDataValue(info.getDataValue());
                    dictionary.setCreateUserId(info.getCreateUserId());
                    dictionary.setBizid(info.getBizid());
                    dictionary.setDataRemark(info.getDataRemark());
                    dictionary.setDataType(info.getDataType());
                    dictionary.setDeleted(Byte.valueOf("0"));
                    try {
                        Integer count = dictionaryMapper.getDataCountByCode(dictionary.getDataCode());
                        if (count == 0)
                            dictionaryMapper.insert(dictionary);
                        else
                            dictionaryMapper.updateByPrimaryKey(dictionary);
                    } catch (Exception e) {
                        log.error("同步字典异常(添加)" + info.getDataCode() + e.getMessage());
                    }
                }
            }
        }
    }
}
