package com.aishang.product.common.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public interface BaseEnum<ENUM extends Enum<?>, KEYTYPE> {

    KEYTYPE getValue();

    String getDisplayName();

    String getEnumName();


}