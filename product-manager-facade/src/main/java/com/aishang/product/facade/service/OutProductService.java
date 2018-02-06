package com.aishang.product.facade.service;

import com.aishang.product.facade.dto.out.*;

/**
 * Created by ylj on 17-11-21.
 */
public interface OutProductService {

    /**
     * 通过商品分类获取产品信息
     */
    com.aishang.product.facade.dto.out.ProductResponseDTO getProductInfos(ProductRequestDTO requestDTO);

    /**
     * 通过产品编码获取产品支持期数信息
     */
    SupportTimeResponseDTO getProductSupportTimes(String productCode);

    /**
     * 通过分类获取产品信息含期数(App)
     */
    AppProductResponseDTO getProductWithSupportTimes(ProductRequestDTO requestDTO, Integer condition);

    /**
     * 通过产品编码获取产品信息含期数(App)
     */
    AppPruductInfoResponseDTO getProductByProductCode(String productCode);

    /**
     * 校验产品状态(App)
     */
    ProductCheckResponseDTO getProductStateResult(String productCode, String storeCode);

    /**
     * 获取产品信息
     */
    ProductInfoResponseDTO getProductInfoByProductCode(String productCode);

    /**
     * 获取产品还款包配置
     */
    OutProductResponseDTO getRepaymentPackagesByProductCode(String productCode);

    /**
     * 获取产品提前还款包信息信息
     */
    ProductPrePayResponseDTO getProductPrePayInfoByProductCode(String productCode);
}
