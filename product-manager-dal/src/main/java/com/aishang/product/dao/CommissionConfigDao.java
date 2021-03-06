package com.aishang.product.dao;

import com.aishang.product.model.CommissionConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品分润配置数据接口
 */
@Service
public interface CommissionConfigDao {

    /**
     * 根据产品编码获取产品分润配置列表
     */
    List<CommissionConfig> getCommissionConfigsByProductCode(@Param("productcode") String productcode);

    /**
     * 添加产品分润配置列表
     */
    int addCommissionConfigs(@Param("adds") List<CommissionConfig> adds);

    /**
     * 根据产品编码删除分润配置
     */
    int deleteCommissionConfigsByProductCode(@Param("productcode") String productcode);
}