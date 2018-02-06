package com.aishang.product.adapter.impl;

import com.aishang.product.adapter.mapper.ProductMapper;
import com.aishang.product.adapter.mapper.RepaymentPackageMapper;
import com.aishang.product.adapter.mapper.SupportPaytimeMapper;
import com.aishang.product.common.enums.AlgorithmTypeEnum;
import com.aishang.product.common.enums.InterestTypeEnum;
import com.aishang.product.common.enums.ProductStateEnum;
import com.aishang.product.dao.ProductDao;
import com.aishang.product.dao.ProductStoreLimitConfigDao;
import com.aishang.product.dao.RepaymentPackageDao;
import com.aishang.product.dao.SupportPaytimeDao;
import com.aishang.product.facade.dto.out.*;
import com.aishang.product.facade.service.OutProductService;
import com.aishang.product.model.Product;
import com.aishang.product.model.ProductStoreLimitConfig;
import com.aishang.product.model.RepaymentPackage;
import com.aishang.product.model.SupportPaytime;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylj on 17-11-21.
 */
@Service
public class OutProductServiceImpl implements OutProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    SupportPaytimeDao supportPaytimeDao;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    SupportPaytimeMapper supportPaytimeMapper;
    @Autowired
    ProductStoreLimitConfigDao limitConfigDao;
    @Autowired
    RepaymentPackageDao repaymentPackageDao;
    @Autowired
    RepaymentPackageMapper repaymentPackageMapper;

    @Override
    public ProductResponseDTO getProductInfos(ProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        try {
            List<Product> products = productDao.getProductsByType(requestDTO.getLevel1Name(), requestDTO.getLevel2Name(), requestDTO.getLevel3Name(), 0);
            if (products != null && products.size() > 0) {
                List<ProductInfoDTO> infoDTOS = productMapper.mapAsList(products, ProductInfoDTO.class);
                //提前还款包
                for (ProductInfoDTO infoDTO : infoDTOS) {
                    infoDTO.setIsPrePay(0);
                    infoDTO.setPrePayValue(new BigDecimal("0"));
                    List<RepaymentPackage> packages = repaymentPackageDao.getRepaymentPackagesByCode(infoDTO.getProductCode());
                    if (packages != null && packages.size() > 0) {
                        for (RepaymentPackage repaymentPackage : packages) {
                            if (repaymentPackage.getType() == AlgorithmTypeEnum.ADD.getValue()) {
                                infoDTO.setIsPrePay(1);
                                infoDTO.setPrePayValue(repaymentPackage.getValue());
                                break;
                            }
                        }
                    }
                }
                responseDTO.setData(infoDTOS);
            }
        } catch (Exception e) {
            responseDTO.setMessage("获取异常！");
            System.out.println(e.getMessage());
            return responseDTO;
        }
        responseDTO.successfully();
        responseDTO.setMessage("获取成功！");
        return responseDTO;
    }

    @Override
    public SupportTimeResponseDTO getProductSupportTimes(String productCode) {
        SupportTimeResponseDTO responseDTO = new SupportTimeResponseDTO();
        if (StringUtils.isBlank(productCode)) {
            responseDTO.setMessage("产品编码不能为空");
            return responseDTO;
        }
        try {
            List<String> productCodes = new ArrayList<>();
            productCodes.add(productCode);
            List<SupportPaytime> supportPaytimes = supportPaytimeDao.getSupportPaytimesByType(productCodes);
            if (supportPaytimes != null && supportPaytimes.size() > 0) {
                List<SupportTimeInfoDTO> infoDTOS = supportPaytimeMapper.mapAsList(supportPaytimes, SupportTimeInfoDTO.class);
                responseDTO.setSupportTimes(infoDTOS);
            }
        } catch (Exception e) {
            responseDTO.setMessage("获取异常！");
            System.out.println(e.getMessage());
            return responseDTO;
        }
        responseDTO.successfully();
        responseDTO.setMessage("获取成功！");
        return responseDTO;
    }

    //通过分类获取产品信息含期数(App)
    @Override
    public AppProductResponseDTO getProductWithSupportTimes(ProductRequestDTO requestDTO, Integer condition) {
        AppProductResponseDTO responseDTO = new AppProductResponseDTO();

        try {
            List<Product> products = productDao.getProductsByType(requestDTO.getLevel1Name(), requestDTO.getLevel2Name(), requestDTO.getLevel3Name(), condition);
            if (products != null && products.size() > 0) {

                //通过产品编码列表－获取支持期数
                List<String> productCodes = new ArrayList<>();
                for (Product product : products) {
                    productCodes.add(product.getProductCode());
                }
                List<SupportPaytime> supportPaytimes = supportPaytimeDao.getSupportPaytimesByType(productCodes);

                boolean haveSupportTime = false;
                if (supportPaytimes != null && supportPaytimes.size() > 0)
                    haveSupportTime = true;
                List<AppProductInfoDTO> appProductInfoDTOS = new ArrayList<>();
                for (Product product : products) {
                    AppProductInfoDTO infoDTO = productMapper.map(product, AppProductInfoDTO.class);
                    //支持期数
                    if (haveSupportTime) {
                        List<AppSupportTimeInfoDTO> supportTimeInfoDTOS = new ArrayList<>();
                        for (SupportPaytime paytime : supportPaytimes) {
                            if (paytime.getProductCode().equals(product.getProductCode())) {
                                AppSupportTimeInfoDTO supportTimeInfoDTO = supportPaytimeMapper.map(paytime, AppSupportTimeInfoDTO.class);
                                supportTimeInfoDTOS.add(supportTimeInfoDTO);
                            }
                        }
                        infoDTO.setSupportTimeInfos(supportTimeInfoDTOS);
                    }
                    //提前还款包
                    infoDTO.setIsPrePay(0);
                    infoDTO.setPrePayValue(new BigDecimal("0"));
                    List<RepaymentPackage> packages = repaymentPackageDao.getRepaymentPackagesByCode(infoDTO.getProductCode());
                    if (packages != null && packages.size() > 0) {
                        for (RepaymentPackage repaymentPackage : packages) {
                            if (repaymentPackage.getType() == AlgorithmTypeEnum.ADD.getValue()) {
                                infoDTO.setIsPrePay(1);
                                infoDTO.setPrePayValue(repaymentPackage.getValue());
                                break;
                            }
                        }
                    }
                    appProductInfoDTOS.add(infoDTO);
                }
                responseDTO.setResultData(appProductInfoDTOS);
            }
        } catch (Exception e) {
            responseDTO.setMessage("获取异常！");
            System.out.println(e.getMessage());
            return responseDTO;
        }
        responseDTO.successfully();
        responseDTO.setMessage("获取成功！");
        return responseDTO;
    }

    @Override
    public AppPruductInfoResponseDTO getProductByProductCode(String productCode) {
        AppPruductInfoResponseDTO responseDTO = new AppPruductInfoResponseDTO();

        if (StringUtils.isBlank(productCode)) {
            responseDTO.setMessage("产品编号不能为空");
            return responseDTO;
        }

        try {
            Product product = productDao.getProductByProductCode(productCode);
            if (product == null) {
                responseDTO.setMessage("产品不存在");
                return responseDTO;
            }

            responseDTO.setInterestType(InterestTypeEnum.getEnum(product.getInterestType()));
            responseDTO.setProductName(product.getProductName());
            responseDTO.setTotalRate(product.getTotalRate());

            List<String> productCodes = new ArrayList<>();
            productCodes.add(productCode);
            List<SupportPaytime> supportPaytimes = supportPaytimeDao.getSupportPaytimesByType(productCodes);
            //支持期数
            if (supportPaytimes != null && supportPaytimes.size() > 0) {
                List<AppSupportTimeInfoDTO> supportTimeInfoDTOS = new ArrayList<>();
                for (SupportPaytime paytime : supportPaytimes) {
                    AppSupportTimeInfoDTO supportTimeInfoDTO = supportPaytimeMapper.map(paytime, AppSupportTimeInfoDTO.class);
                    supportTimeInfoDTOS.add(supportTimeInfoDTO);
                }
                responseDTO.setSupportTimeInfos(supportTimeInfoDTOS);
            }
            //提前还款包
            responseDTO.setIsPrePay(0);
            responseDTO.setPrePayValue(new BigDecimal("0"));
            List<RepaymentPackage> packages = repaymentPackageDao.getRepaymentPackagesByCode(productCode);
            if (packages != null && packages.size() > 0) {
                for (RepaymentPackage repaymentPackage : packages) {
                    if (repaymentPackage.getType() == AlgorithmTypeEnum.ADD.getValue()) {
                        responseDTO.setIsPrePay(1);
                        responseDTO.setPrePayValue(repaymentPackage.getValue());
                        break;
                    }
                }
            }
            responseDTO.successfully();
            responseDTO.setMessage("获取数据成功");
        } catch (Exception e) {
            responseDTO.setMessage("获取数据异常");
            System.out.println(e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ProductCheckResponseDTO getProductStateResult(String productCode, String storeCode) {

        ProductCheckResponseDTO responseDTO = new ProductCheckResponseDTO();
        if (StringUtils.isBlank(productCode)) {
            responseDTO.setMessage("产品编码不能为空");
            return responseDTO;
        }
        if (StringUtils.isBlank(storeCode)) {
            responseDTO.setMessage("门店编码不能为空");
            return responseDTO;
        }
        try {
            responseDTO.setIsCanUsed(false);
            Product productVo = productDao.getProductByProductCode(productCode);
            if (productVo != null) {
                if (productVo.getState() == ProductStateEnum.NORMAL.getValue()) {
                    List<ProductStoreLimitConfig> configs = limitConfigDao.getStoreConfigsByProductCode(productCode);
                    if (configs != null && configs.size() > 0) {
                        for (ProductStoreLimitConfig config : configs) {
                            if (config.getStoreCode().equals(storeCode)) {
                                responseDTO.setIsCanUsed(true);
                                break;
                            }
                        }
                    }
                }
            }
            responseDTO.successfully();
        } catch (Exception e) {
            responseDTO.setMessage("产品校验异常");
            System.out.println("产品校验异常" + e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ProductInfoResponseDTO getProductInfoByProductCode(String productCode) {
        ProductInfoResponseDTO responseDTO = new ProductInfoResponseDTO();

        if (StringUtils.isBlank(productCode)) {
            responseDTO.setMessage("产品编码不能为空");
            return responseDTO;
        }
        Product product = null;
        try {
            product = productDao.getProductByProductCode(productCode);
        } catch (Exception e) {
            responseDTO.setMessage("查询产品信息异常");
            System.out.println("查询产品信息异常" + e.getMessage());
            return responseDTO;
        }
        if (product != null) {
            try {
                responseDTO = productMapper.map(product, ProductInfoResponseDTO.class);
                responseDTO.successfully();
                responseDTO.setMessage("查询成功");
                return responseDTO;
            } catch (Exception e) {
                responseDTO.setMessage("mapper转换产品数据异常");
                System.out.println("mapper转换产品数据异常" + e.getMessage());
                return responseDTO;
            }
        } else {
            responseDTO.setMessage("查询无数据");
            return responseDTO;
        }
    }

    @Override
    public OutProductResponseDTO getRepaymentPackagesByProductCode(String productCode) {
        OutProductResponseDTO responseDTO = new OutProductResponseDTO();

        try {
            Product product = productDao.getProductByProductCode(productCode);
            if (product == null) {
                responseDTO.setMessage("产品不存在");
                return responseDTO;
            }
        } catch (Exception e) {
            responseDTO.setMessage("查询产品异常");
            System.out.println("查询产品异常" + e.getMessage());
            return responseDTO;
        }

        try {
            List<RepaymentPackage> packages = repaymentPackageDao.getRepaymentPackagesByCode(productCode);
            if (packages != null && packages.size() > 0) {
                List<OutRepayPackageInfoDTO> infoDTOS = repaymentPackageMapper.mapAsList(packages, OutRepayPackageInfoDTO.class);
                responseDTO.setResultData(infoDTOS);
            } else
                responseDTO.setResultData(new ArrayList<OutRepayPackageInfoDTO>());
            responseDTO.successfully();
        } catch (Exception e) {
            responseDTO.setMessage("获取产品还款包配置异常");
            System.out.println("获取产品还款包配置异常" + e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ProductPrePayResponseDTO getProductPrePayInfoByProductCode(String productCode) {
        ProductPrePayResponseDTO responseDTO = new ProductPrePayResponseDTO();

        try {
            Product product = productDao.getProductByProductCode(productCode);
            if (product == null) {
                responseDTO.setMessage("产品不存在");
                return responseDTO;
            }
        } catch (Exception e) {
            responseDTO.setMessage("查询产品异常");
            System.out.println("查询产品异常" + e.getMessage());
            return responseDTO;
        }

        try {
            responseDTO.setIsPrePay(0);
            responseDTO.setPrePayValue(new BigDecimal("0"));
            List<RepaymentPackage> packages = repaymentPackageDao.getRepaymentPackagesByCode(productCode);
            if (packages != null && packages.size() > 0) {
                for (RepaymentPackage repaymentPackage : packages) {
                    if (repaymentPackage.getType() == AlgorithmTypeEnum.ADD.getValue()) {
                        responseDTO.setIsPrePay(1);
                        responseDTO.setPrePayValue(repaymentPackage.getValue());
                        break;
                    }
                }
            }
            responseDTO.successfully();
        } catch (Exception e) {
            responseDTO.setMessage("获取产品还款包配置异常");
            System.out.println("获取产品还款包配置异常" + e.getMessage());
        }
        return responseDTO;
    }
}
