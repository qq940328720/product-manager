package com.aishang.product.facade.dto.response;

/**
 * Created by ylj on 17-10-10.
 */
public class ProductEnumModelDTO {

    private Integer value;
    private String name;
    private String displayName;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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

    public ProductEnumModelDTO(Integer value, String name, String displayName) {
        this.value = value;
        this.name = name;
        this.displayName = displayName;
    }

    public ProductEnumModelDTO(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public ProductEnumModelDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEnumModelDTO that = (ProductEnumModelDTO) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return displayName != null ? displayName.equals(that.displayName) : that.displayName == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductEnumModelDTO{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
