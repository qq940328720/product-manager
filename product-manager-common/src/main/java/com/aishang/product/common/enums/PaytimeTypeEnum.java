package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 还款类型
 * Created by ylj on 17-10-6.
 */
public enum PaytimeTypeEnum implements BaseEnum<PaytimeTypeEnum, Integer> {

    YEAR(1, "年"),
    MONTH(2, "月"),
    DAY(3, "日");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, PaytimeTypeEnum> valueMap;

    PaytimeTypeEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (PaytimeTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public PaytimeTypeEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, PaytimeTypeEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }

}
