package com.aishang.product.client.Tools;

import java.util.List;

/**
 * @Author 李通
 * @Data 17-11-15 下午7:04
 */
public class DictionaryRelations {
    private String success;
    private String executed;
    private String message;
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        private String dataCode;
        private String message;
        private String dataType;
        private String dataName;
        private String dataValue;
        private String dataRemark;
        private String createUserId;
        private String insertTime;
        private String updateTime;
        private String bizid;
        private String parentCode;
        private IsDelete isDelete;
        private TreeType treeType;

        public String getDataCode() {
            return dataCode;
        }

        public void setDataCode(String dataCode) {
            this.dataCode = dataCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getDataName() {
            return dataName;
        }

        public void setDataName(String dataName) {
            this.dataName = dataName;
        }

        public String getDataValue() {
            return dataValue;
        }

        public void setDataValue(String dataValue) {
            this.dataValue = dataValue;
        }

        public String getDataRemark() {
            return dataRemark;
        }

        public void setDataRemark(String dataRemark) {
            this.dataRemark = dataRemark;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getInsertTime() {
            return insertTime;
        }

        public void setInsertTime(String insertTime) {
            this.insertTime = insertTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getBizid() {
            return bizid;
        }

        public void setBizid(String bizid) {
            this.bizid = bizid;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public IsDelete getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(IsDelete isDelete) {
            this.isDelete = isDelete;
        }

        public TreeType getTreeType() {
            return treeType;
        }

        public void setTreeType(TreeType treeType) {
            this.treeType = treeType;
        }
    }

    public static class IsDelete {
        private String value;
        private String name;
        private String displayName;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private static class TreeType {
        private String value;
        private String name;
        private String displayName;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
