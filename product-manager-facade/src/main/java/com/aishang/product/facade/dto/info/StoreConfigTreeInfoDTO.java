package com.aishang.product.facade.dto.info;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by ylj on 17-10-27.
 */
@ApiModel(description = "经营范围树实体信息")
public class StoreConfigTreeInfoDTO {

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "父ID")
    private String pid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否选中")
    private Boolean isChecked;

    @ApiModelProperty(value = "子节点")
    List<StoreConfigTreeInfoDTO> nodes;

    public List<StoreConfigTreeInfoDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<StoreConfigTreeInfoDTO> nodes) {
        this.nodes = nodes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
