package com.aishang.product.dao;

import com.aishang.product.model.StateChangeLog;
import com.hc.support.dal.mybatis.MyBatisDao;

/**
 * 产品状态变更历史数据接口
 */
@MyBatisDao
public interface StateChangeLogDao {

    /**
     * 添加产品状态变更历史
     */
    int insert(StateChangeLog record);

}