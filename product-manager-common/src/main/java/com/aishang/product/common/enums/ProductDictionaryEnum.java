package com.aishang.product.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 产品字典分类
 * Created by ylj on 17-10-13.
 */
public enum ProductDictionaryEnum implements BaseEnum<ProductDictionaryEnum, Integer> {


    PRODUCT_TYPE(1, "产品分类"),
    PRODUCT_ALGORITHM(2, "算法类型"),
    PRODUCT_COMMISSION(3, "提成方式"),
    PRODUCT_INTEREST(4, "计息方式"),
    PRODUCT_LOAN(5, "放款类型"),
    PRODUCT_MONEYRESOURCE(6, "资金来源"),
    PRODUCT_PAYTIME(7, "还款类型"),
    PRODUCT_SUPPORTUNIT(8, "支持期数单位"),
    PRODUCT_POSITION(9, "职位"),
    PRODUCT_DELREASON(10, "删除原因"),
    PRODUCT_ENABLEDREASON(11, "启用原因"),
    PRODUCT_UNABLEDREASON(12, "禁用原因"),
    PRODUCT_AUDITSTATE(13, "产品状态");


    private final Integer status;
    private final String displayName;
    private static Map<Integer, ProductDictionaryEnum> valueMap;

    ProductDictionaryEnum(Integer status, String displayName) {
        this.status = Integer.valueOf(status);
        this.displayName = displayName;
    }

    static {
        valueMap = Maps.newHashMap();
        for (ProductDictionaryEnum e : values())
            valueMap.put(e.status, e);
    }

    public Integer getValue() {
        return this.status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ProductDictionaryEnum getEnum(Integer key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }
        return valueMap.get(key);
    }

    public Map<Integer, ProductDictionaryEnum> getAllValueMap() {
        return valueMap;
    }

    @Override
    public String getEnumName() {
        return this.name();
    }
}
