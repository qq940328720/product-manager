package com.aishang.product.web.controller;

import com.aishang.product.facade.dto.request.UpdProductStateDTO;
import com.aishang.product.facade.dto.response.ProductResponseDTO;
import com.aishang.product.facade.service.ProductService;
import com.aishang.product.web.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/{bizid}/checkproduct", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ProductResponseDTO updateAuditProduct(@PathVariable String bizid, @RequestBody UpdProductStateDTO requestDTO) {
        String adminCode = null;
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
            adminCode = "16465";
            responseDTO = this.productService.updateAuditProduct(bizid, requestDTO, adminCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }
}
