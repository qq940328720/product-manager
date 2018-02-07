package com.aishang.product.dao;

import com.aishang.product.model.StateChangeLog;
import org.springframework.stereotype.Service;

/**
 * 产品状态变更历史数据接口
 */
@Service
public interface StateChangeLogDao {

    /**
     * 添加产品状态变更历史
     */
    int insert(StateChangeLog record);

}