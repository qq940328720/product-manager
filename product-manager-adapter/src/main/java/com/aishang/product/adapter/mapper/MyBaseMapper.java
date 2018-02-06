package com.aishang.product.adapter.mapper;

import com.aishang.product.common.enums.*;
import com.hc.mvc.core.enums.ISDeleteEnum;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.Type;

public class MyBaseMapper extends ConfigurableMapper {

    protected String integerInterestTypeConverter(MapperFactory factory) {
        String converterId = "integerInterestTypeConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, InterestTypeEnum>() {
            @Override
            public InterestTypeEnum convert(Integer source, Type<? extends InterestTypeEnum> destinationType) {
                return InterestTypeEnum.AVERAGEINTEREST.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerMoneyResourceConverter(MapperFactory factory) {
        String converterId = "integerMoneyResourceConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, MoneyResourceEnum>() {
            @Override
            public MoneyResourceEnum convert(Integer source, Type<? extends MoneyResourceEnum> destinationType) {
                return MoneyResourceEnum.XYD.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerProductStateConverter(MapperFactory factory) {
        String converterId = "integerProductStateConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, ProductStateEnum>() {
            @Override
            public ProductStateEnum convert(Integer source, Type<? extends ProductStateEnum> destinationType) {
                return ProductStateEnum.NORMAL.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerYesOrNoConverter(MapperFactory factory) {
        String converterId = "integerYesOrNoConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, YesOrNoEnum>() {
            @Override
            public YesOrNoEnum convert(Integer source, Type<? extends YesOrNoEnum> destinationType) {
                return YesOrNoEnum.YES.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerOpenOrCloseEnumConverter(MapperFactory factory) {
        String converterId = "integerOpenOrCloseEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, OpenOrCloseEnum>() {
            @Override
            public OpenOrCloseEnum convert(Integer source, Type<? extends OpenOrCloseEnum> destinationType) {
                return OpenOrCloseEnum.OPEN.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerPaytimeTypeEnumConverter(MapperFactory factory) {
        String converterId = "integerPaytimeTypeEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, PaytimeTypeEnum>() {
            @Override
            public PaytimeTypeEnum convert(Integer source, Type<? extends PaytimeTypeEnum> destinationType) {
                return PaytimeTypeEnum.YEAR.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerMoneyResourceEnumConverter(MapperFactory factory) {
        String converterId = "integerMoneyResourceEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, MoneyResourceEnum>() {
            @Override
            public MoneyResourceEnum convert(Integer source, Type<? extends MoneyResourceEnum> destinationType) {
                return MoneyResourceEnum.XYD.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerPositionEnumConverter(MapperFactory factory) {
        String converterId = "integerPositionEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, PositionEnum>() {
            @Override
            public PositionEnum convert(Integer source, Type<? extends PositionEnum> destinationType) {
                return PositionEnum.PROVINCE.getEnum(source);
            }
        });
        return converterId;
    }


    protected String integerCommissionTypeEnumConverter(MapperFactory factory) {
        String converterId = "integerCommissionTypeEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, CommissionTypeEnum>() {
            @Override
            public CommissionTypeEnum convert(Integer source, Type<? extends CommissionTypeEnum> destinationType) {
                return CommissionTypeEnum.CASH.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerLoanTypeEnumConverter(MapperFactory factory) {
        String converterId = "integerLoanTypeEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, LoanTypeEnum>() {
            @Override
            public LoanTypeEnum convert(Integer source, Type<? extends LoanTypeEnum> destinationType) {
                return LoanTypeEnum.PERSONAL.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerAlgorithmTypeEnumConverter(MapperFactory factory) {
        String converterId = "integerAlgorithmTypeEnumConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, AlgorithmTypeEnum>() {
            @Override
            public AlgorithmTypeEnum convert(Integer source, Type<? extends AlgorithmTypeEnum> destinationType) {
                return AlgorithmTypeEnum.ADD.getEnum(source);
            }
        });
        return converterId;
    }

    protected String integerPaytimeUnitConverter(MapperFactory factory) {
        String converterId = "integerPaytimeUnitConverter";
        factory.getConverterFactory().registerConverter(converterId, new CustomConverter<Integer, PaytimeUnitEnum>() {
            @Override
            public PaytimeUnitEnum convert(Integer source, Type<? extends PaytimeUnitEnum> destinationType) {
                return PaytimeUnitEnum.MONTH.getEnum(source);
            }
        });
        return converterId;
    }
}
