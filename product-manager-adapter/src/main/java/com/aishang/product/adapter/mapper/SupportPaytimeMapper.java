package com.aishang.product.adapter.mapper;

import com.aishang.product.facade.dto.info.SupportTimeInfoDTO;
import com.aishang.product.facade.dto.out.AppSupportTimeInfoDTO;
import com.aishang.product.model.SupportPaytime;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ylj on 17-10-6.
 */
@Component("supportPaytimeMapper")
public class SupportPaytimeMapper extends MyBaseMapper {

    protected void configure(MapperFactory factory) {
        String integerPaytimeUnitConverter = this.integerPaytimeUnitConverter(factory);
        factory.classMap(SupportPaytime.class, SupportTimeInfoDTO.class)
                .field("productCode", "productCode")
                .fieldMap("paytimeUnit", "paytimeUnit").aToB().converter(integerPaytimeUnitConverter).add()
                .byDefault().register();
        factory.classMap(SupportPaytime.class, AppSupportTimeInfoDTO.class)
                .fieldMap("paytimeUnit", "paytimeUnit").aToB().converter(integerPaytimeUnitConverter).add()
                .byDefault().register();
        factory.classMap(SupportPaytime.class, com.aishang.product.facade.dto.out.SupportTimeInfoDTO.class)
                .fieldMap("paytimeUnit", "paytimeUnit").aToB().converter(integerPaytimeUnitConverter).add()
                .byDefault().register();
    }
}
