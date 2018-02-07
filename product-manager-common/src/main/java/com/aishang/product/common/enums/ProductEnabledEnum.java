package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 产品启用原因
 * Created by ylj on 17-10-13.
 */
public enum ProductEnabledEnum implements BaseEnum<ProductEnabledEnum, Integer> {

    NORMAL_OPENING(1, "正常开通"),
    LIFT_BAN(2, "风险解禁"),
    UNLAWFUL_BAN(3, "违规解禁"),
    OTHERS(4, "其它"),;
    private final Integer status;
    private final String displayName;
    private static Map<Integer, ProductEnabledEnum> valueMap;

    ProductEnabledEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (ProductEnabledEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ProductEnabledEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ProductEnabledEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }

}