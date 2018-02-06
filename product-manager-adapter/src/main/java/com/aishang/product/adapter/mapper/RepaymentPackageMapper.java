package com.aishang.product.adapter.mapper;

import com.aishang.product.facade.dto.info.RepaymentConfigInfoDTO;
import com.aishang.product.facade.dto.info.RepaymentInfoDTO;
import com.aishang.product.facade.dto.out.OutRepayPackageInfoDTO;
import com.aishang.product.model.RepaymentPackage;
import com.aishang.product.model.RepaymentPackageConfig;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ylj on 17-10-6.
 */
@Component("repaymentPackageMapper")
public class RepaymentPackageMapper extends MyBaseMapper {


    protected void configure(MapperFactory factory) {
        String integerPaytimeTypeEnumConverter = this.integerPaytimeTypeEnumConverter(factory);
        String integerAlgorithmTypeEnumConverter = this.integerAlgorithmTypeEnumConverter(factory);
        String integerYesOrNoConverter = this.integerYesOrNoConverter(factory);
        factory.classMap(RepaymentPackage.class, RepaymentInfoDTO.class)
                /*.field("productCode", "productCode")*/
                .fieldMap("paytimeType", "paytimeType").aToB().converter(integerPaytimeTypeEnumConverter).add()
                .fieldMap("type", "type").aToB().converter(integerAlgorithmTypeEnumConverter).add()
                .fieldMap("isChoice", "isChoice").aToB().converter(integerYesOrNoConverter).add()
                .byDefault().register();
        factory.classMap(RepaymentPackage.class, OutRepayPackageInfoDTO.class)
                /*.field("productCode", "productCode")*/
                .fieldMap("paytimeType", "paytimeType").aToB().converter(integerPaytimeTypeEnumConverter).add()
                .fieldMap("type", "type").aToB().converter(integerAlgorithmTypeEnumConverter).add()
                .fieldMap("isChoice", "isChoice").aToB().converter(integerYesOrNoConverter).add()
                .byDefault().register();
    }
}