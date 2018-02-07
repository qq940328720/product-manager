package com.aishang.product.model;

/**
 * 产品
 */
public class ProductVo extends Product {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    private String supportPayTime;//支持期数

    private String productType;

    private String level1Name;    // 分类1名称

    private String level2Name;    // 分类2名称

    private String level3Name;    // 分类3名称

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSupportPayTime() {
        return supportPayTime;
    }

    public void setSupportPayTime(String supportPayTime) {
        this.supportPayTime = supportPayTime;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public ProductVo() {
    }
}