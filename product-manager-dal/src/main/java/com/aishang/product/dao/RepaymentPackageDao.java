package com.aishang.product.dao;

import com.aishang.product.model.RepaymentPackage;
import com.hc.support.dal.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 还款包源数据接口
 */
@MyBatisDao
public interface RepaymentPackageDao {

    /**
     * 根据产品编码获取还款包源
     */
    List<RepaymentPackage> getRepaymentPackagesByCode(String productCode);

    /**
     * 根据条件获取还款包源
     */
    List<RepaymentPackage> getRepaymentPackagesByConditions(@Param("name") String name, @Param("type") Integer type, @Param("paytimetype") Integer paytimeType);

    /**
     * 根据还款包源编码列表获取还款包源
     */
    List<RepaymentPackage> getRepaymentPackagesByCodes(@Param("codes") List<String> packageCodes);

    /**
     * 根据还款包源编码获取还款包源
     */
    RepaymentPackage getRepaymentPackageByCode(@Param("packageCode") String packageCode);
}