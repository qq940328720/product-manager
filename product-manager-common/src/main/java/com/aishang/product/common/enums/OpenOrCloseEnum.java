package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ylj on 17-10-3.
 */
public enum OpenOrCloseEnum implements BaseEnum<OpenOrCloseEnum, Integer> {
    CLOSE(0, "关闭"),
    OPEN(1, "开启"),;

    private final Integer status;
    private final String displayName;
    private static Map<Integer, OpenOrCloseEnum> valueMap;

    OpenOrCloseEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (OpenOrCloseEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public OpenOrCloseEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, OpenOrCloseEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
