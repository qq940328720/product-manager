package com.aishang.product.dao;

import com.aishang.product.model.ProductStoreLimitConfig;
import com.hc.support.dal.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface ProductStoreLimitConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductStoreLimitConfig record);

    int insertSelective(ProductStoreLimitConfig record);

    ProductStoreLimitConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductStoreLimitConfig record);

    int updateByPrimaryKey(ProductStoreLimitConfig record);

    /**
     * 根据产品编码获取经营范围
     */
    List<ProductStoreLimitConfig> getStoreConfigsByProductCode(@Param("productcode") String productCode);

    /**
     * 根据产品编码删除经营范围
     */
    Integer deleteStoreConfigsByProductCode(@Param("productcode") String productCode);

    /**
     * 添加产品经营范围
     */
    Integer addStoreConfigs(@Param("adds") List<ProductStoreLimitConfig> adds);

    /**
     * 通过产品类型查询经营范围
     */
    List<ProductStoreLimitConfig> getStoreConfigsByProductType(@Param("type1") String type1, @Param("type2") String type2, @Param("type3") String type3);
}