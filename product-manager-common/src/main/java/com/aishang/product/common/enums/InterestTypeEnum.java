package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 计息方式
 * Created by ylj on 17-10-3.
 */
public enum InterestTypeEnum implements BaseEnum<InterestTypeEnum, Integer> {
    AVERAGEINTEREST(1, "等额本息"),
    AVERAGECAPITAL(2, "等额本金"),
    AVERAGECAPITALINTEREST(3, "等本等息");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, InterestTypeEnum> valueMap;

    InterestTypeEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (InterestTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static InterestTypeEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, InterestTypeEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
