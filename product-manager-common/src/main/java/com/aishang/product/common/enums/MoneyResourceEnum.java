package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 资金来源
 * Created by ylj on 17-10-3.
 */
public enum MoneyResourceEnum implements BaseEnum<MoneyResourceEnum, Integer> {

    XYD(1, "小雨点"),
    XZXT(2, "西藏信托");
    //AS(3, "爱尚"),;
    private final Integer status;
    private final String displayName;
    private static Map<Integer, MoneyResourceEnum> valueMap;

    MoneyResourceEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (MoneyResourceEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public MoneyResourceEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, MoneyResourceEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
