package com.aishang.product.dao;

import com.aishang.product.model.SupportPaytime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品支持期数数据接口
 */
@Service
public interface SupportPaytimeDao {

    /**
     * 根据产品编码获取产品支持期数列表
     */
    List<SupportPaytime> getSupportPaytimesByProductCode(String productcode);

    /**
     * 添加支持期数列表
     */
    int addSupportPaytimes(@Param("adds") List<SupportPaytime> adds);

    /**
     * 根据产品编码删除支持期数
     */
    int deleteSupportPaytimesByProductCode(@Param("productcode") String productcode);

    /**
     * 通过产品编码列表获取期数(App)
     */
    List<SupportPaytime> getSupportPaytimesByType(@Param("productcodes") List<String> productCodes);
}