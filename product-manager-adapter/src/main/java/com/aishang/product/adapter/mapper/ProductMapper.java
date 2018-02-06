package com.aishang.product.adapter.mapper;

import com.aishang.product.facade.dto.info.ProductInfoDTO;
import com.aishang.product.facade.dto.out.AppProductInfoDTO;
import com.aishang.product.facade.dto.out.ProductInfoResponseDTO;
import com.aishang.product.model.Product;
import com.aishang.product.model.ProductVo;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ylj on 17-10-3.
 */
@Component("productMapper")
public class ProductMapper extends MyBaseMapper {

    protected void configure(MapperFactory factory) {
        String integerInterestTypeConverter = this.integerInterestTypeConverter(factory);
        String integerMoneyResourceConverter = this.integerMoneyResourceConverter(factory);
        String integerProductStateConverter = this.integerProductStateConverter(factory);
        String integerLoanTypeEnumConverter = this.integerLoanTypeEnumConverter(factory);
        String integerYesOrNoConverter = this.integerYesOrNoConverter(factory);


        factory.classMap(ProductVo.class, ProductInfoDTO.class)
                .field("bizid", "bizid")
                .fieldMap("interestType", "interestType").aToB().converter(integerInterestTypeConverter).add()
                .fieldMap("moneyResource", "moneyResource").aToB().converter(integerMoneyResourceConverter).add()
                .fieldMap("state", "state").aToB().converter(integerProductStateConverter).add()
                .fieldMap("loanType", "loanType").aToB().converter(integerLoanTypeEnumConverter).add()
                .fieldMap("isEnabledLadder", "isEnabledLadder").aToB().converter(integerYesOrNoConverter).add()
                .fieldMap("isSupportAssend", "isSupportAssend").aToB().converter(integerYesOrNoConverter).add()
                .byDefault().register();
        factory.classMap(Product.class, AppProductInfoDTO.class)
                .fieldMap("interestType", "interestType").aToB().converter(integerInterestTypeConverter).add()
                .byDefault().register();
        factory.classMap(Product.class, com.aishang.product.facade.dto.out.ProductInfoDTO.class)
                .fieldMap("interestType", "interestType").aToB().converter(integerInterestTypeConverter).add()
                .byDefault().register();
        factory.classMap(Product.class, ProductInfoResponseDTO.class)
                .fieldMap("interestType", "interestType").aToB().converter(integerInterestTypeConverter).add()
                .fieldMap("moneyResource", "moneyResource").aToB().converter(integerMoneyResourceConverter).add()
                .fieldMap("state", "state").aToB().converter(integerProductStateConverter).add()
                .fieldMap("loanType", "loanType").aToB().converter(integerLoanTypeEnumConverter).add()
                .fieldMap("isEnabledLadder", "isEnabledLadder").aToB().converter(integerYesOrNoConverter).add()
                .fieldMap("isSupportAssend", "isSupportAssend").aToB().converter(integerYesOrNoConverter).add()
                .byDefault().register();
    }

}
