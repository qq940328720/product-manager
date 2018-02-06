package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 职位状态
 * Created by ylj on 17-10-3.
 */
public enum PositionEnum implements BaseEnum<PositionEnum, Integer> {

    SEO(1, "销售总监"),
    REGION(2, "大区总监"),
    PROVINCE(3, "省区总监"),
    CITY(4, "城市经理"),
    AREA(5, "区域经理"),
    BUSINESS(6, "业务主管，金融顾问"),;
    private final Integer status;
    private final String displayName;
    private static Map<Integer, PositionEnum> valueMap;

    PositionEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (PositionEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public PositionEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, PositionEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }

}
