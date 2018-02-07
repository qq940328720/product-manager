package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 产品删除原因
 * Created by ylj on 17-10-13.
 */
public enum ProductDeletedEnum implements BaseEnum<ProductDeletedEnum, Integer> {

    CLOSED(1, "永久关闭"),
    OTHERS(2, "其它"),;
    private final Integer status;
    private final String displayName;
    private static Map<Integer, ProductDeletedEnum> valueMap;

    ProductDeletedEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (ProductDeletedEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ProductDeletedEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ProductDeletedEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }

}
