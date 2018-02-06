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
     * 分页查询产品
     *
     * @param conditionDTO
     * @return
     */
    ProductResponseDTO getProductsByConditions(ProductConditionDTO conditionDTO);

    /**
     * 添加产品
     *
     * @param productAddDTO
     * @return
     */
    ProductResponseDTO addProduct(ProductAddDTO productAddDTO);

    /**
     * 根据bizid查询产品详细信息
     *
     * @param bizid
     * @return
     */
    ProductQryResponseDTO getProductById(String bizid);

    /**
     * 编辑修改产品信息
     *
     * @param productUpdateDTO
     * @return
     */
    ProductResponseDTO updateProduct(ProductUpdateDTO productUpdateDTO);

    /**
     * 审核产品状态
     *
     * @param bizid
     * @return
     */
    ProductResponseDTO updateAuditProduct(String bizid, UpdProductStateDTO requestDTO,String adminCode);

    /**
     * 启用
     *
     * @param bizid
     * @return
     */
    ProductResponseDTO updateStartProduct(String bizid, ProductStateDTO requestDTO,String adminCode);

    /**
     * 禁用
     *
     * @param bizid
     * @return
     */
    ProductResponseDTO updateForbiddenProduct(String bizid, ProductStateDTO requestDTO,String adminCode);


    /**
     * 软删除产品
     *
     * @param bizid
     * @return
     */
    ProductResponseDTO deleteProduct(String bizid,ProductDeleteDTO requestDTO,String adminCode);

    /**
     * 联动查询还款包源
     *
     * @param repaymentDTO
     * @return
     */
    RepaymentResponseDTO getRepaymentPackagesByConditions(RepaymentDTO repaymentDTO);

    /**
     * 联动查询产品分类
     *
     * @param typeCode
     * @return
     */
    ProductTypeResponseDTO getPruductTypes(String typeCode);

    /**
     * 获取界面枚举数据
     *
     * @return
     */
    ProductEnumDTO getUIEnums();

    /**
     * 查询产品启用原因列表
     */
    DictonaryResponseDTO getEnableTypeList();

    /**
     * 查询产禁用原因列表
     */
    DictonaryResponseDTO getUnableTypeList();

    /**
     * 查询产品删除原因列表
     */
    DictonaryResponseDTO getDeletedTypeList();

    /**
     * 获取经营范围树
     */
    OrganizationTreeResponseDTO getStoreConfigTree();

    /**
     * 获取AdminCodeAndEmployeeCode
     */
    AdminCodeAndEmployeeCodeDTO getAdminCodeAndEmployeeCode();
}
