package com.aishang.product.facade.dto.out;

public class ProductRequestDTO {

    private String level1Name;//级别1 对应字典表产品类目描述
    private String level2Name;//级别2 对应字典表产品类目描述
    private String level3Name;//级别3 对应字典表产品类目描述

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = "".equals(level1Name) ? null : level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = "".equals(level2Name) ? null : level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = "".equals(level3Name) ? null : level3Name;
    }
}
