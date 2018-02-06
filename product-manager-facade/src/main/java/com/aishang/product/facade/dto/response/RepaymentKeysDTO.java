package com.aishang.product.facade.dto.response;

import com.aishang.product.common.enums.YesOrNoEnum;

/**
 * Created by ylj on 17-10-10.
 */
public class RepaymentKeysDTO {

    private String packageCode;
    private String name;
    private String displayName;
    private YesOrNoEnum isChoice;

    @Override
    public String toString() {
        return "RepaymentKeysDTO{" +
                "packageCode='" + packageCode + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", isChoice=" + isChoice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepaymentKeysDTO keysDTO = (RepaymentKeysDTO) o;

        if (packageCode != null ? !packageCode.equals(keysDTO.packageCode) : keysDTO.packageCode != null) return false;
        if (name != null ? !name.equals(keysDTO.name) : keysDTO.name != null) return false;
        if (displayName != null ? !displayName.equals(keysDTO.displayName) : keysDTO.displayName != null) return false;
        return isChoice == keysDTO.isChoice;
    }

    @Override
    public int hashCode() {
        int result = packageCode != null ? packageCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (isChoice != null ? isChoice.hashCode() : 0);
        return result;
    }

    public String getPackageCode() {

        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public YesOrNoEnum getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(YesOrNoEnum isChoice) {
        this.isChoice = isChoice;
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

    public RepaymentKeysDTO(String packageCode, String name, String displayName, YesOrNoEnum isChoice) {
        this.packageCode = packageCode;
        this.name = name;
        this.displayName = displayName;
        this.isChoice = isChoice;
    }

    public RepaymentKeysDTO() {
    }

}
