package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 产品状态
 * Created by ylj on 17-10-3.
 */
public enum ProductStateEnum implements BaseEnum<ProductStateEnum, Integer> {

    NORMAL(1, "正常"),
    PENDING_APPROVAL(2, "待审核"),
    DISABLED(3, "已拒绝"),
    REJECT(4, "已驳回"),
    DECLINE(5, "已禁用"),
    DELETED(6, "已删除");
    private final Integer status;
    private final String displayName;
    private static Map<Integer, ProductStateEnum> valueMap;

    ProductStateEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (ProductStateEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ProductStateEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ProductStateEnum> getAllValueMap() {
        return valueMap;
    }


    public String getEnumName() {
        return this.name();
    }

}
