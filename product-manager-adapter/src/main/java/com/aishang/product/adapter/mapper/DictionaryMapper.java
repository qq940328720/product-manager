package com.aishang.product.adapter.mapper;

import com.aishang.product.facade.dto.info.DictionaryInfoDTO;
import com.aishang.product.facade.dto.info.ProductInfoDTO;
import com.aishang.product.model.Dictionary;
import com.aishang.product.model.ProductVo;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

/**
 * Created by whb on 17-10-16.
 */
@Component("dictionaryMapper")
public class DictionaryMapper extends MyBaseMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Dictionary.class, DictionaryInfoDTO.class)
                .field("dataCode", "dataCode")
                .byDefault().register();
    }

}
