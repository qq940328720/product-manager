package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 放款类型
 * Created by ylj on 17-10-6.
 */
public enum LoanTypeEnum implements BaseEnum<LoanTypeEnum, Integer> {

    PERSONAL(1, "客户本人账户"),
    STORE(2, "所属门店银行账户");

    private final Integer status;
    private final String displayName;
    private static Map<Integer, LoanTypeEnum> valueMap;

    LoanTypeEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (LoanTypeEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public LoanTypeEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, LoanTypeEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }
}
