package com.aishang.product.facade.dto.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylj on 17-10-18.
 */
public class OrganizationTreeNodes {

    @ApiModelProperty(value = "机构编码")
    private String id;
    @ApiModelProperty(value = "上级机构编码")
    private String pId;
    @ApiModelProperty(value = "机构名称")
    private String name;
    @ApiModelProperty(value = "编号")
    private Integer code;
    @ApiModelProperty(value = "所在机构树")
    private String dataCodes;
    @ApiModelProperty(value = "bizid")
    private String bizid;
    @ApiModelProperty(value = "节点类型(1:商区,2:商户,3:门店)")
    private Integer nodeType;
    @ApiModelProperty(value = "节点等级(1:爱尚金服,2:大区,3:省,4:市,5:区,6:商户,7:门店)")
    private Integer level;
    @ApiModelProperty(value = "子节点")
    private List<OrganizationTreeNodes> nodes = new ArrayList<OrganizationTreeNodes>();

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getDataCodes() {
        return dataCodes;
    }

    public void setDataCodes(String dataCodes) {
        this.dataCodes = dataCodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public List<OrganizationTreeNodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<OrganizationTreeNodes> nodes) {
        this.nodes = nodes;
    }

    public OrganizationTreeNodes(String id, String pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public OrganizationTreeNodes() {
    }
}
