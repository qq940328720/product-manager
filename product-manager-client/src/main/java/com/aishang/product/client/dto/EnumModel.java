package com.aishang.product.client.dto;

/**
 * 订单枚举、字典实体信息
 * Created by ylj on 17-11-7.
 */
public class EnumModel {

    private Object value;
    private String name;
    private String displayName;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnumModel() {
    }

    public EnumModel(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
}
