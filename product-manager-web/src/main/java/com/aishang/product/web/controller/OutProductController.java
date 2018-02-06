package com.aishang.product.web.controller;

import com.aishang.product.facade.dto.out.*;
import com.aishang.product.facade.service.OutProductService;
import com.aishang.product.web.controller.base.BaseController;
import com.hc.mvc.core.enums.ContentType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ylj on 17-11-21.
 */
@RestController
@RequestMapping("/outProduct")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OutProductController extends BaseController {

    @Autowired
    OutProductService outProductService;

    @ApiOperation(value = "通过产品分类获取产品信息", response = ProductResponseDTO.class, notes = "通过产品分类获取产品信息")
    @RequestMapping(value = "/getProductInfos", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductResponseDTO getProductInfos(ProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = this.outProductService.getProductInfos(requestDTO);
        return responseDTO;
    }

    @ApiOperation(value = "通过产品编码获取产品支持期数信息", response = SupportTimeResponseDTO.class, notes = "通过产品编码获取产品支持期数信息")
    @RequestMapping(value = "/{productCode}/getProductSupportTimes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public SupportTimeResponseDTO getProductSupportTimes(@PathVariable String productCode) {
        SupportTimeResponseDTO responseDTO = this.outProductService.getProductSupportTimes(productCode);
        return responseDTO;
    }

    @ApiOperation(value = "通过分类获取产品信息含期数(App)", response = AppProductResponseDTO.class, notes = "通过分类获取产品信息含期数(App)")
    @RequestMapping(value = "/{condition}/getProductWithSupportTimes", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public AppProductResponseDTO getProductWithSupportTimes(ProductRequestDTO requestDTO, @PathVariable Integer condition) {
        AppProductResponseDTO responseDTO = this.outProductService.getProductWithSupportTimes(requestDTO, condition);
        return responseDTO;
    }

    @ApiOperation(value = "通过产品编码获取产品信息含期数(App)", response = AppPruductInfoResponseDTO.class, notes = "通过产品编码获取产品信息含期数(App)")
    @RequestMapping(value = "/{productCode}/getProductByProductCode", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public AppPruductInfoResponseDTO getProductByProductCode(@PathVariable String productCode) {
        AppPruductInfoResponseDTO responseDTO = this.outProductService.getProductByProductCode(productCode);
        return responseDTO;
    }

    @ApiOperation(value = "校验产品状态(App)", response = ProductCheckResponseDTO.class, notes = "校验产品状态(App)")
    @RequestMapping(value = "/{productCode}/{storeCode}/getProductStateResult", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductCheckResponseDTO getProductStateResult(@PathVariable String productCode, @PathVariable String storeCode) {
        ProductCheckResponseDTO responseDTO = this.outProductService.getProductStateResult(productCode, storeCode);
        return responseDTO;
    }

    @ApiOperation(value = "获取产品信息", response = ProductInfoResponseDTO.class, notes = "获取产品信息")
    @RequestMapping(value = "/{productCode}/getProductInfoByProductCode", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductInfoResponseDTO getProductInfoByProductCode(@PathVariable String productCode) {
        ProductInfoResponseDTO responseDTO = this.outProductService.getProductInfoByProductCode(productCode);
        return responseDTO;
    }

    @ApiOperation(value = "获取产品还款包配置", response = OutProductResponseDTO.class, notes = "获取产品还款包配置")
    @RequestMapping(value = "/{productCode}/getRepaymentPackagesByProductCode", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public OutProductResponseDTO getRepaymentPackagesByProductCode(@PathVariable String productCode) {
        OutProductResponseDTO responseDTO = this.outProductService.getRepaymentPackagesByProductCode(productCode);
        return responseDTO;
    }

    @ApiOperation(value = "获取产品提前还款包信息", response = ProductPrePayResponseDTO.class, notes = "获取产品提前还款包信息")
    @RequestMapping(value = "/{productCode}/getProductPrePayInfoByProductCode", method = RequestMethod.GET, produces = {ContentType.APPLICATION_JSON_UTF_8})
    public ProductPrePayResponseDTO getProductPrePayInfoByProductCode(@PathVariable String productCode) {
        ProductPrePayResponseDTO responseDTO = this.outProductService.getProductPrePayInfoByProductCode(productCode);
        return responseDTO;
    }
}
