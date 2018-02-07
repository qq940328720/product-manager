package com.aishang.product.adapter.impl;

import com.aishang.product.facade.dto.info.ProductInfoDTO;
import com.aishang.product.facade.dto.request.UpdProductStateDTO;
import com.aishang.product.facade.dto.response.ProductResponseDTO;
import com.aishang.product.facade.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by ylj on 17-10-3.
 */

@Service
public class ProductServiceImpl implements ProductService {

    public ProductResponseDTO updateAuditProduct(final String bizid, UpdProductStateDTO requestDTO, final String adminCode) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setTotal(1000);
        responseDTO.setProductInfoDTOS(new ArrayList<ProductInfoDTO>());
        return responseDTO;
    }

    public static void main(String[] args) {
        String maxCode = "XF3CSJ00001C";
//        String numCode = maxCode.substring(6, 11);
//        Integer i = Integer.valueOf(numCode);
//        i++;
        String numCode = maxCode.substring(maxCode.length() - 6, maxCode.length() - 1);
//        String str = Regex.Replace(maxCode, @ "\d{5}(?!\d)", String.Empty);
        System.out.println(numCode);

//        BigDecimal total = new BigDecimal(0);
//
//
//        for (Integer i = 0; i < 10; i++) {
//            total = total.add(new BigDecimal(1.11));
//        }


    }
}
