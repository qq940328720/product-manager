package com.aishang.product.dao;

import com.aishang.product.model.RepaymentPackageConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 还款包源配置数据接口
 */
@Service
public interface RepaymentPackageConfigDao {

    /**
     * 根据产品编码获取产品分润配置列表
     */
    List<RepaymentPackageConfig> getRepaymentPackageConfigsByProductCode(@Param("productcode") String productcode);

    /**
     * 添加产品分润配置列表
     */
    int addRepaymentPackageConfigs(@Param("adds") List<RepaymentPackageConfig> adds);

    /**
     * 根据产品编码删除还款包源配置
     */
    int deleteRepaymentConfigsByProductCode(@Param("productcode") String productcode);
}