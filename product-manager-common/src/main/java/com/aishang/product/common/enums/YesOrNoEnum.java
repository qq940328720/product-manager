package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ylj on 17-10-3.
 */
public enum YesOrNoEnum implements BaseEnum<YesOrNoEnum, Integer> {
    YES(1, "是"),
    NO(0, "否"),;

    private final Integer status;
    private final String displayName;
    private static Map<Integer, YesOrNoEnum> valueMap;

    YesOrNoEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (YesOrNoEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public YesOrNoEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, YesOrNoEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
