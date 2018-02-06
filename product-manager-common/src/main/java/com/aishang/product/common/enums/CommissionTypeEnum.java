package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 提成方式
 * Created by ylj on 17-10-3.
 */
public enum CommissionTypeEnum implements BaseEnum<CommissionTypeEnum, Integer> {

    CASH(1, "金额提成"),
    VOLUME(2, "单量提成");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, CommissionTypeEnum> valueMap;

    CommissionTypeEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (CommissionTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public CommissionTypeEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, CommissionTypeEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
