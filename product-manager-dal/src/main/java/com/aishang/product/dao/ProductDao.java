package com.aishang.product.dao;

import com.aishang.product.model.Product;
import com.aishang.product.model.ProductVo;
import exception.MyBizException;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品数据接口
 */
@Service
public interface ProductDao {

    /**
     * 添加产品
     */
    int insert(Product record);

    /**
     * 更新产品状态
     */
    int updateProductState(Product record);

    /**
     * 分页查询产品列表
     */
    List<ProductVo> getProductsByCondition(@Param("type1") String type1, @Param("type2") String type2, @Param("type3") String type3, @Param("state") Integer state, @Param("name") String name, @Param("offset") Integer offset, @Param("rowscount") Integer rowscount);

    /**
     * 查询符合条件的产品的总条数
     */
    Integer getProductsCountByCondition(@Param("type1") String type1, @Param("type2") String type2, @Param("type3") String type3, @Param("state") Integer state, @Param("name") String name);

    /**
     * 更新产品
     */
    Integer updateProduct(Product product);

    /**
     * param bizid
     * 根据bizid查询是否有该产品
     */
    int selectByBizid(String bizid);

    /**
     * param bizid
     * 根据bizid查询是否有该产品
     */
    ProductVo selectProductByBizid(String bizid);

    /**
     * param bizid
     * 根据bizid删除产品
     */
    int updateProductEnabled(String bizid) throws MyBizException;

    /**
     * 查询同名产品
     */
    List<ProductVo> selectProductByTypeAndName(@Param("type1") String type1, @Param("type2") String type2, @Param("type3") String type3, @Param("name") String name);

    /**
     * 获取产品最大的productCode
     */
    String getMaxCode();

    /**
     * 通过分类获取产品信息含期数(App)
     */
    List<Product> getProductsByType(@Param("type1") String level1Name, @Param("type2") String level2Name, @Param("type3") String level3Name, @Param("condition") Integer condition);

    /**
     * 通过产品编码获取产品信息含期数(App)
     */
    Product getProductByProductCode(@Param("productCode") String productCode);
}