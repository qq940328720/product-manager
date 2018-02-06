package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 支持期数单位
 * Created by ylj on 17-10-6.
 */
public enum PaytimeUnitEnum implements BaseEnum<PaytimeUnitEnum, Integer> {

    //    YEAR(1, "年"),
    MONTH(2, "月");
//    DAY(3, "日"),;

    private final Integer status;
    private final String displayName;
    private static Map<Integer, PaytimeUnitEnum> valueMap;

    PaytimeUnitEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (PaytimeUnitEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public PaytimeUnitEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, PaytimeUnitEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}