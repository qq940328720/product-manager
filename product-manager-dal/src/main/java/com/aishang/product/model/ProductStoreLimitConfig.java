package com.aishang.product.model;

import com.hc.common.redis.pojo.RedisBaseDTO;
import com.hc.support.dal.model.BaseModel;

import java.util.Date;

public class ProductStoreLimitConfig extends BaseModel<Integer> implements RedisBaseDTO {
    private Integer id;

    private String productCode;

    private String storeCode;

    private Integer enabled;

    private Integer deleted;

    private Date insertTime;

    private Date updateTime;

    public ProductStoreLimitConfig(Integer id, String productCode, String storeCode, Integer enabled, Integer deleted, Date insertTime, Date updateTime) {
        this.id = id;
        this.productCode = productCode;
        this.storeCode = storeCode;
        this.enabled = enabled;
        this.deleted = deleted;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public ProductStoreLimitConfig() {
        super();
    }

    @Override
    public boolean isValid() {
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}