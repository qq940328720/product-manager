package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 算法类型
 * Created by ylj on 17-10-6.
 */
public enum AlgorithmTypeEnum implements BaseEnum<AlgorithmTypeEnum, Integer> {


    MUTIPLY(1, "乘算型"),
    ADD(2, "加算型");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, AlgorithmTypeEnum> valueMap;

    AlgorithmTypeEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (AlgorithmTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public AlgorithmTypeEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, AlgorithmTypeEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
