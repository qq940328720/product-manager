package com.aishang.product.adapter.mapper;

import com.aishang.product.facade.dto.info.CommissionConfigInfoDTO;
import com.aishang.product.model.CommissionConfig;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ylj on 17-10-6.
 */
@Component("commissionConfigMapper")
public class CommissionConfigMapper extends MyBaseMapper {

    protected void configure(MapperFactory factory) {
        String integerPositionConverter = this.integerPositionEnumConverter(factory);
        String integerCommissionTypeConverter = this.integerCommissionTypeEnumConverter(factory);
        factory.classMap(CommissionConfig.class, CommissionConfigInfoDTO.class)
//                .field("productCode", "productCode")
                .fieldMap("position", "position").aToB().converter(integerPositionConverter).add()
                .fieldMap("commissionType", "commissionType").aToB().converter(integerCommissionTypeConverter).add()
                .byDefault().register();
    }

}
