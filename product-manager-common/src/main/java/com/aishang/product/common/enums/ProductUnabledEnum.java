package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 产品禁用原因
 * Created by ylj on 17-10-13.
 */
public enum ProductUnabledEnum implements BaseEnum<ProductUnabledEnum, Integer> {

    ADJUSTMENT(1, "政策调整"),
    HIGHER_RISK(2, "风险超标"),
    UNLAWFUL_ACT(3, "违规操作"),
    OTHERS(4, "其它"),;
    private final Integer status;
    private final String displayName;
    private static Map<Integer, ProductUnabledEnum> valueMap;

    ProductUnabledEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (ProductUnabledEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ProductUnabledEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ProductUnabledEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }

}
