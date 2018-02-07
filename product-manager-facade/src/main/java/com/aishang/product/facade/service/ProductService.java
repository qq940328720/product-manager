package com.aishang.product.facade.service;

import com.aishang.product.facade.dto.request.*;
import com.aishang.product.facade.dto.response.*;
import exception.MyBizException;

import java.util.List;

/**
 * Created by ylj on 17-10-3.
 */
public interface ProductService {

    /**
     * 审核产品状态
     *
     * @param bizid
     * @return
     */
    ProductResponseDTO updateAuditProduct(String bizid, UpdProductStateDTO requestDTO,String adminCode);
}
