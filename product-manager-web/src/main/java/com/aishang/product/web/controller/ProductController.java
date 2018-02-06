package com.aishang.product.web.controller;

import com.aishang.product.common.enums.*;
import com.aishang.product.facade.dto.request.*;
import com.aishang.product.facade.dto.response.*;
import com.aishang.product.facade.service.ProductService;
import com.aishang.product.web.controller.base.BaseController;
import com.hc.mvc.core.enums.ContentType;
import exception.MyBizException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品接口
 * Created by ylj on 17-10-3.
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "审核", response = ProductResponseDTO.class, notes = "审核")
    @RequestMapping(value = "/{bizid}/checkproduct", method = RequestMethod.PUT, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO updateAuditProduct(@PathVariable String bizid, @RequestBody UpdProductStateDTO requestDTO) {
        String adminCode = null;
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
            adminCode = getLoginUserSession();
            responseDTO = this.productService.updateAuditProduct(bizid, requestDTO, adminCode);
        } catch (MyBizException e) {
            e.printStackTrace();
            responseDTO.setData(e.getMessage());
        }
        return responseDTO;
    }

    @ApiOperation(value = "启用", response = ProductResponseDTO.class, notes = "启用")
    @RequestMapping(value = "/{bizid}/enableproduct", method = RequestMethod.PUT, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO enableProduct(@PathVariable String bizid, @RequestBody ProductStateDTO requestDTO) {
        String adminCode = null;
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
//            adminCode = getLoginUserSession();
            adminCode = "admin";
            responseDTO = this.productService.updateStartProduct(bizid, requestDTO, adminCode);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setData(e.getMessage());
        }
        return responseDTO;
    }

    @ApiOperation(value = "禁用", response = ProductResponseDTO.class, notes = "禁用")
    @RequestMapping(value = "/{bizid}/unableproduct", method = RequestMethod.PUT, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO unableProduct(@PathVariable String bizid, @RequestBody ProductStateDTO requestDTO) {
        String adminCode = null;
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
            adminCode = getLoginUserSession();
            responseDTO = this.productService.updateForbiddenProduct(bizid, requestDTO, adminCode);
        } catch (MyBizException e) {
            e.printStackTrace();
            responseDTO.setData(e.getMessage());
        }
        return responseDTO;
    }

    @ApiOperation(value = "根据bizid查询信息", response = ProductResponseDTO.class, notes = "根据bizid查询产品信息")
    @RequestMapping(value = "/{bizid}/showproduct", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductQryResponseDTO showProduct(@PathVariable String bizid) {
        ProductQryResponseDTO responseDTO = this.productService.getProductById(bizid);
        return responseDTO;
    }

    @ApiOperation(value = "删除", response = ProductResponseDTO.class, notes = "删除产品信息")
    @RequestMapping(value = "/{bizid}/deleteproduct", method = RequestMethod.DELETE, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO deleteProduct(@PathVariable String bizid, @RequestBody ProductDeleteDTO requestDTO) {
        String adminCode = null;
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
            adminCode = getLoginUserSession();
            responseDTO = this.productService.deleteProduct(bizid, requestDTO, adminCode);
        } catch (MyBizException e) {
            e.printStackTrace();
            responseDTO.setData(e.getMessage());
        }
        return responseDTO;
    }

    @ApiOperation(value = "修改", response = ProductResponseDTO.class, notes = "修改产品信息")
    @RequestMapping(value = "/updateproduct", method = RequestMethod.PUT, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO updateProduct(@RequestBody ProductUpdateDTO productUpdateDTO) throws MyBizException {
//        productUpdateDTO.setOperator(getLoginUserSession());
        productUpdateDTO.setOperator("ylj");
        ProductResponseDTO responseDTO = this.productService.updateProduct(productUpdateDTO);
        return responseDTO;
    }

    @ApiOperation(value = "获取界面枚举", response = ProductResponseDTO.class, notes = "获取界面枚举")
    @RequestMapping(value = "/getuienums", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductEnumDTO getUIEnums() {
        ProductEnumDTO responseDTO = this.productService.getUIEnums();


        return responseDTO;
    }

    @ApiOperation(value = "联动查询还款包源", response = ProductResponseDTO.class, notes = "联动查询还款包源")
    @RequestMapping(value = "/getrepaymentkeysenums", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public RepaymentResponseDTO getRepaymentKeysEnums(RepaymentDTO repaymentDTO) {
        RepaymentResponseDTO repaymentResponseDTO = this.productService.getRepaymentPackagesByConditions(repaymentDTO);
        return repaymentResponseDTO;
    }

    @ApiOperation(value = "分页查询", response = ProductResponseDTO.class, notes = "分页查询")
    @RequestMapping(value = "/getproductsbyconditions", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO getProductsByConditions(ProductConditionDTO conditionDTO) {
        ProductResponseDTO responseDTO = this.productService.getProductsByConditions(conditionDTO);
        return responseDTO;
    }

    @ApiOperation(value = "添加产品", response = ProductResponseDTO.class, notes = "添加产品")
    @RequestMapping(value = "addproduct", method = RequestMethod.POST, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO addProduct(@RequestBody ProductAddDTO productAddDTO) throws MyBizException {
        ProductResponseDTO responseDTO = this.productService.addProduct(productAddDTO);
        return responseDTO;
    }

    @ApiOperation(value = "产品分类联动查询", response = ProductTypeResponseDTO.class, notes = "产品分类联动查询")
    @RequestMapping(value = "/getpruducttypes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductTypeResponseDTO getPruductTypes(ProductTypeRequestDTO typeCode) {

        ProductTypeResponseDTO responseDTO = this.productService.getPruductTypes(typeCode.getTypeCode());
        return responseDTO;
    }

    @ApiOperation(value = "启用原因查询", response = ProductTypeResponseDTO.class, notes = "启用原因查询")
    @RequestMapping(value = "/getenabletypes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public DictonaryResponseDTO getEnableTypeList() {
        DictonaryResponseDTO responseDTO = this.productService.getEnableTypeList();
        return responseDTO;
    }

    @ApiOperation(value = "禁用原因查询", response = ProductTypeResponseDTO.class, notes = "禁用原因查询")
    @RequestMapping(value = "/getunabletypes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public DictonaryResponseDTO getUnableTypeList() {
        DictonaryResponseDTO responseDTO = this.productService.getUnableTypeList();
        return responseDTO;
    }

    @ApiOperation(value = "删除原因查询", response = ProductTypeResponseDTO.class, notes = "删除原因查询")
    @RequestMapping(value = "/getdeletedtypes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public DictonaryResponseDTO getDeletedTypeList() {
        DictonaryResponseDTO responseDTO = this.productService.getDeletedTypeList();
        return responseDTO;
    }

    @ApiOperation(value = "获取经营范围树", response = OrganizationTreeResponseDTO.class, notes = "获取经营范围树")
    @RequestMapping(value = "/getstoreconfigtree", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public OrganizationTreeResponseDTO getStoreConfigTree() {
        OrganizationTreeResponseDTO responseDTO = this.productService.getStoreConfigTree();
        return responseDTO;
    }

    @ApiOperation(value = "获取adminCode和employeeCode", response = AdminCodeAndEmployeeCodeDTO.class, notes = "获取adminCode和employeeCode")
    @RequestMapping(value = "/getadmincodeandemployeecode", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public AdminCodeAndEmployeeCodeDTO getAdminCodeAndEmployeeCode() {
        AdminCodeAndEmployeeCodeDTO responseDTO = this.productService.getAdminCodeAndEmployeeCode();
        return responseDTO;
    }
}
