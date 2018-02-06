package com.aishang.product.adapter.impl;

import com.aishang.dictionary.common.client.UserInfoClient;
import com.aishang.product.adapter.mapper.*;
import com.aishang.product.client.OrgEmployeeInfoDTO;
import com.aishang.product.client.OrgEmployeeResponseDTO;
import com.aishang.product.client.Tools.MerchantStoreUilt;
import com.aishang.product.client.Tools.OrgEmployeeUtil;
import com.aishang.product.common.enums.*;
import com.aishang.product.dao.*;
import com.aishang.product.facade.dto.info.*;
import com.aishang.product.facade.dto.request.*;
import com.aishang.product.facade.dto.response.*;
import com.aishang.product.facade.service.ProductService;
import com.aishang.product.model.*;
import com.aishang.product.model.Dictionary;
import com.hc.mvc.core.dto.base.ResponseCodeEnums;
import com.hc.mvc.core.service.base.MyBaseService;
import exception.MyBizException;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ylj on 17-10-3.
 */

@Service
public class ProductServiceImpl extends MyBaseService implements ProductService {

    @Autowired
    private StateChangeLogDao stateChangeLogDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private SupportPaytimeDao supportPaytimeDao;
    @Autowired
    private CommissionConfigDao commissionConfigDao;
    @Autowired
    private RepaymentPackageConfigDao repaymentPackageConfigDao;
    @Autowired
    private RepaymentPackageDao repaymentPackageDao;
    @Autowired
    private DictionaryDao dictionaryDao;
    @Autowired
    private ProductStoreLimitConfigDao storeLimitConfigDao;
    @Autowired
    private MerchantStoreUilt merchantStoreUilt;
    @Autowired
    private OrgEmployeeUtil orgEmployeeUtil;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private SupportPaytimeMapper supportPaytimeMapper;
    @Autowired
    private CommissionConfigMapper commissionConfigMapper;
    @Autowired
    private RepaymentPackageMapper repaymentPackageMapper;
    @Autowired
    private UserInfoClient userInfoClient;

    /**
     * 分页获取产品
     */
    @Override
    public ProductResponseDTO getProductsByConditions(ProductConditionDTO conditionDTO) {

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        //获取符合条件的产品总条数
        Integer state = conditionDTO.getState() == null ? null : conditionDTO.getState().getValue();
        try {
            Integer total = productDao.getProductsCountByCondition(conditionDTO.getType1(), conditionDTO.getType2(), conditionDTO.getType3(), state, conditionDTO.getKeyofname());
            if (total == null) total = 0;
            if (total > 0) {
                //获取指定页码的产品列表
                List<ProductVo> products = productDao.getProductsByCondition(conditionDTO.getType1(), conditionDTO.getType2(), conditionDTO.getType3(), state, conditionDTO.getKeyofname(), conditionDTO.getOffset(), conditionDTO.getSize());
                if (products != null && products.size() > 0) {
                    List<ProductInfoDTO> productInfoDTOS = productMapper.mapAsList(products, ProductInfoDTO.class);
                    responseDTO.setProductInfoDTOS(productInfoDTOS);

                    responseDTO.setMessage("查询产品列表成功!");
                }
            } else {
                responseDTO.setMessage("查询产品列表成功,但数据为空!");
            }
            responseDTO.setTotal(total);
            responseDTO.successfully();
        } catch (Exception ex) {

            System.out.println("查询产品列表异常");
            responseDTO.setMessage("查询产品列表异常!");
        }
        return responseDTO;

    }

    /**
     * 添加产品
     */
    @Override
    public ProductResponseDTO addProduct(ProductAddDTO productAddDTO) {

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        ProductInfoDTO productInfoDTO = productAddDTO.getProductInfoDTO();
//        if (StringUtils.isBlank(productInfoDTO.getLevel1Code()) || StringUtils.isBlank(productInfoDTO.getLevel2Code()) || StringUtils.isBlank(productInfoDTO.getLevel3Code())) {
//            responseDTO.setMessage("产品分类不能为空!");
//            return responseDTO;
//        }
//        if (StringUtils.isBlank(productInfoDTO.getLevel1Code())) {
//            responseDTO.setMessage("产品分类1不能为空!");
//            return responseDTO;
//        }
        if (StringUtils.isBlank(productInfoDTO.getProductName())) {
            responseDTO.setMessage("产品名称不能为空!");
            return responseDTO;
        } else if (productAddDTO.getSupportTimeInfos() == null || productAddDTO.getSupportTimeInfos().size() < 1) {
            responseDTO.setMessage("支持期数不能为空!");
            return responseDTO;
        } else if (productAddDTO.getSupportTimeInfos().size() > 0) {
            Map<String, Integer> maps = new HashedMap();
            for (SupportTimeInfoDTO infoDTO : productAddDTO.getSupportTimeInfos()) {
                if (infoDTO.getPaytimeUnit() != null) {
                    String key = infoDTO.getPaytimeUnit().getEnumName() + "-" + infoDTO.getPayTime().toString();
                    Integer integer = maps.get(key);
                    if (integer != null) {
                        responseDTO.setMessage("同一日期单位下的支持期数不能重复!");
                        return responseDTO;
                    } else
                        maps.put(key, infoDTO.getPayTime());
                }
            }
        } else if (productAddDTO.getCommissionConfigInfos() == null || productAddDTO.getCommissionConfigInfos().size() < 1) {
            responseDTO.setMessage("提成方案不能为空!");
            return responseDTO;
        } /*else if (productAddDTO.getCommissionConfigInfos().size() > 0) {
            if (productAddDTO.getProductInfoDTO().getIsEnabledLadder() == YesOrNoEnum.YES) {
                Map<String, List<CommissionConfigInfoDTO>> maps = new HashedMap();
                for (CommissionConfigInfoDTO infoDTO : productAddDTO.getCommissionConfigInfos()) {
                    if (infoDTO.getPosition() != null) {
                        String key = infoDTO.getPosition().getEnumName();
                        List<CommissionConfigInfoDTO> infoDTOS = maps.get(key);
                        if (infoDTOS == null) infoDTOS = new ArrayList<>();
                        infoDTOS.add(infoDTO);
                        maps.put(key, infoDTOS);
                    }
                }
                for (List<CommissionConfigInfoDTO> infoDTOS : maps.values()) {
                    for (Integer i = 0; i < infoDTOS.size(); i++) {

                    }
                }
            }
//            responseDTO.setMessage("提成方案不能为空!");
//            return responseDTO;
        } */ else if (productAddDTO.getRepaymentConfigInfos() == null || productAddDTO.getRepaymentConfigInfos().size() < 1) {
            responseDTO.setMessage("利率配置不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getInterestType() == null) {
            responseDTO.setMessage("计息方式不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getMoneyResource() == null) {
            responseDTO.setMessage("资金来源不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getLoanType() == null) {
            responseDTO.setMessage("放款对象不能为空!");
            return responseDTO;
        }
//        String name = this.checkStoreConfigsIsExist(productInfoDTO.getLevel1Code(), productInfoDTO.getLevel2Code(), productInfoDTO.getLevel3Code(), productAddDTO.getStoreConfigInfoS());
//        if (!StringUtils.isBlank(name)) {
//            responseDTO.setMessage("名称为:" + name + "的商区已经关联了改产品类型,请重新选择!");
//            return responseDTO;
//        }
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//        String productCode = "AS" + df.format(new Date());

        List<ProductVo> exists = productDao.selectProductByTypeAndName(productInfoDTO.getLevel1Code(), productInfoDTO.getLevel2Code(), productInfoDTO.getLevel3Code(), productInfoDTO.getProductName());
        if (exists != null && exists.size() > 0) {
            responseDTO.setMessage("该分类下已存在同名产品!");
            return responseDTO;
        }

        BigDecimal total = getTotalRate(productAddDTO.getRepaymentConfigInfos());

        String productCode = this.getProductCode(productInfoDTO.getLevel1Code(), productInfoDTO.getLevel2Code(), productInfoDTO.getLevel3Code());
        try {
            //添加产品
            Product addProduct = productMapper.map(productAddDTO.getProductInfoDTO(), Product.class);
            addProduct = this.dtoToModel(addProduct, productAddDTO.getProductInfoDTO());
            //设置业务id
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            addProduct.setBizid(uuid);
            //设置产品编码
            addProduct.setProductCode(productCode);
            //设置产品状态
            addProduct.setDeleted(0);
            addProduct.setState(ProductStateEnum.PENDING_APPROVAL.getValue());
            addProduct.setTotalRate(total);
            if (StringUtils.isBlank(addProduct.getLevel1Code()))
                addProduct.setLevel1Code(null);
            if (StringUtils.isBlank(addProduct.getLevel2Code()))
                addProduct.setLevel2Code(null);
            if (StringUtils.isBlank(addProduct.getLevel3Code()))
                addProduct.setLevel3Code(null);
            int productCount = productDao.insert(addProduct);
            if (productCount > 0) {

                addSupportPaytimes(productAddDTO.getSupportTimeInfos(), responseDTO, productCode);
                addCommissionConfigs(productAddDTO.getCommissionConfigInfos(), responseDTO, productCode);
                addRepaymentPackageConfigs(productAddDTO.getRepaymentConfigInfos(), responseDTO, productCode);
                addStoreConfigs(productAddDTO.getStoreConfigInfoS(), responseDTO, productCode);
                System.out.println("添加产品成功!");
                responseDTO.successfully();
                responseDTO.setMessage("添加产品成功!");
            } else {
                System.out.println("添加产品失败!");
                responseDTO.setMessage("添加产品失败!");
            }
        } catch (Exception ex) {
            System.out.println("添加产品异常!" + ex.getMessage());
            responseDTO.setMessage("添加产品异常!");
        }
        return responseDTO;
    }

    private BigDecimal getTotalRate(List<RepaymentConfigInfoDTO> infoDTOS) {
        BigDecimal total = new BigDecimal(0);
        try {
            for (RepaymentConfigInfoDTO config : infoDTOS) {
                RepaymentPackage repaymentPackage = repaymentPackageDao.getRepaymentPackageByCode(config.getPackageCode());
                if (repaymentPackage.getType() == AlgorithmTypeEnum.MUTIPLY.getValue())
                    total = total.add(repaymentPackage.getValue());
            }
        } catch (Exception ex) {
            System.out.println("计算总利率异常!" + ex.getMessage());
        }
        return total;
    }

    private Product dtoToModel(Product product, ProductInfoDTO infoDTO) {

        product.setProductName(infoDTO.getProductName());
        if (infoDTO.getInterestType() != null)
            product.setInterestType(infoDTO.getInterestType().getValue());
        if (infoDTO.getLoanType() != null)
            product.setLoanType(infoDTO.getLoanType().getValue());
        if (infoDTO.getMoneyResource() != null)
            product.setMoneyResource(infoDTO.getMoneyResource().getValue());
        if (infoDTO.getState() != null)
            product.setState(infoDTO.getState().getValue());
        if (infoDTO.getIsEnabledLadder() != null)
            product.setIsEnabledLadder(infoDTO.getIsEnabledLadder().getValue());
        if (infoDTO.getIsSupportAssend() != null)
            product.setIsSupportAssend(infoDTO.getIsSupportAssend().getValue());
        return product;
    }

    //添加还款包源配置
    private boolean addRepaymentPackageConfigs(List<RepaymentConfigInfoDTO> addList, ProductResponseDTO responseDTO, String productCode) {
        boolean ret = false;
        try {
            if (addList != null && addList.size() > 0) {
                //添加还款包源配置
                List<RepaymentPackageConfig> addRepaymentPackageConfigs = new ArrayList<>();
                for (RepaymentConfigInfoDTO packageConfig : addList) {
                    RepaymentPackageConfig addModel = new RepaymentPackageConfig();
                    addModel.setProductCode(productCode);
                    addModel.setPackageCode(packageConfig.getPackageCode());
                    addModel.setDeleted(0);
                    addRepaymentPackageConfigs.add(addModel);
                }
                int pageCount = repaymentPackageConfigDao.addRepaymentPackageConfigs(addRepaymentPackageConfigs);
                if (pageCount == addList.size()) {
                    System.out.println("添加还款包源配置成功!");
                    responseDTO.successfully();
                    responseDTO.setMessage("添加还款包源配置成功!");
                    ret = true;
                } else {
                    System.out.println("添加还款包源配置失败!");
                    responseDTO.setMessage("添加还款包源配置失败!");
                }
            } else {
                System.out.println("还款包源配置数据为空!");
                responseDTO.successfully();
                ret = true;
            }
        } catch (Exception ex) {
            System.out.println("添加还款包源配置异常!" + ex.getMessage());
            responseDTO.setMessage("添加还款包源配置异常!");
        }
        return ret;
    }

    //添加分润配置
    private boolean addCommissionConfigs(List<CommissionConfigInfoDTO> addList, ProductResponseDTO responseDTO, String productCode) {
        boolean ret = false;
        try {
            if (addList != null && addList.size() > 0) {
                //添加分润配置
//                List<CommissionConfig> addCommissionConfigs = commissionConfigMapper.mapAsList(addList, CommissionConfig.class);
                List<CommissionConfig> addCommissionConfigs = new ArrayList<>();
                for (CommissionConfigInfoDTO packageConfig : addList) {
                    CommissionConfig addModel = new CommissionConfig();
                    addModel.setProductCode(productCode);
                    addModel.setCommission(packageConfig.getCommission());
                    addModel.setLowerLimit(packageConfig.getLowerLimit());
                    addModel.setUpperLimit(packageConfig.getUpperLimit());
                    if (packageConfig.getCommissionType() != null)
                        addModel.setCommissionType(packageConfig.getCommissionType().getValue());
                    if (packageConfig.getPosition() != null)
                        addModel.setPosition(packageConfig.getPosition().getValue());
                    addModel.setDeleted(0);
                    addCommissionConfigs.add(addModel);
                }
                for (CommissionConfig commissionConfig : addCommissionConfigs) {
                    commissionConfig.setProductCode(productCode);
                    commissionConfig.setDeleted(0);
                }
                int commissionCount = commissionConfigDao.addCommissionConfigs(addCommissionConfigs);
                if (commissionCount == addList.size()) {
                    System.out.println("添加分润配置成功!");
                    responseDTO.successfully();
                    responseDTO.setMessage("添加分润配置成功!");
                    ret = true;
                } else {
                    System.out.println("添加分润配置失败!");
                    responseDTO.setMessage("添加分润配置失败!");
                }
            } else {
                System.out.println("分润配置数据为空!");
                responseDTO.successfully();
                ret = true;
            }
        } catch (Exception ex) {
            System.out.println("添加分润配置异常!" + ex.getMessage());
            responseDTO.setMessage("添加分润配置异常!");
        }
        return ret;
    }

    //添加支持期数
    private boolean addSupportPaytimes(List<SupportTimeInfoDTO> addList, ProductResponseDTO responseDTO, String productCode) {
        boolean ret = false;
        try {
            if (addList != null && addList.size() > 0) {
                //添加支持期数
//                List<SupportPaytime> addSupportPaytimes = supportPaytimeMapper.mapAsList(addList, SupportPaytime.class);
//                for (SupportPaytime supportPaytime : addSupportPaytimes) {
//                    supportPaytime.setProductCode(productCode);
//                    supportPaytime.setDeleted(0);
//                }
                List<SupportPaytime> addSupportPaytimes = new ArrayList<>();
                for (SupportTimeInfoDTO infoDTO : addList) {
                    SupportPaytime addModel = new SupportPaytime();
                    addModel.setPayTime(infoDTO.getPayTime());
                    if (infoDTO.getPaytimeUnit() != null)
                        addModel.setPaytimeUnit(infoDTO.getPaytimeUnit().getValue());
                    addModel.setProductCode(productCode);
                    addModel.setDeleted(0);
                    addSupportPaytimes.add(addModel);
                }
                int supportCount = supportPaytimeDao.addSupportPaytimes(addSupportPaytimes);
                if (supportCount == addList.size()) {
                    System.out.println("添加支持期数成功!");
                    responseDTO.successfully();
                    responseDTO.setMessage("添加支持期数成功!");
                    ret = true;
                } else {
                    System.out.println("添加支持期数失败!");
                    responseDTO.setMessage("添加支持期数失败!");
                }
            } else {
                System.out.println("支持期数数据为空!");
                responseDTO.successfully();
                ret = true;
            }
        } catch (Exception ex) {
            System.out.println("添加支持期数异常!" + ex.getMessage());
            responseDTO.setMessage("添加支持期数异常!");
        }
        return ret;
    }

    //添加经营范围
    private boolean addStoreConfigs(List<StoreConfigInfoDTO> addList, ProductResponseDTO responseDTO, String productCode) {
        boolean ret = false;
        try {
            if (addList != null && addList.size() > 0) {
                List<ProductStoreLimitConfig> adds = new ArrayList<>();
                for (StoreConfigInfoDTO infoDTO : addList) {
                    ProductStoreLimitConfig addModel = new ProductStoreLimitConfig();
                    addModel.setStoreCode(infoDTO.getStoreCode());
                    addModel.setProductCode(productCode);
                    addModel.setDeleted(0);
                    addModel.setEnabled(1);
                    adds.add(addModel);
                }
                int supportCount = storeLimitConfigDao.addStoreConfigs(adds);
                if (supportCount == addList.size()) {
                    System.out.println("添加经营范围成功!");
                    responseDTO.successfully();
                    responseDTO.setMessage("添加经营范围成功!");
                    ret = true;
                } else {
                    System.out.println("添加经营范围失败!");
                    responseDTO.setMessage("添加经营范围失败!");
                }
            } else {
                System.out.println("经营范围数据为空!");
                responseDTO.successfully();
                ret = true;
            }
        } catch (Exception ex) {
            System.out.println("添加经营范围异常!" + ex.getMessage());
            responseDTO.setMessage("添加经营范围异常!");
        }
        return ret;
    }

//    private String checkStoreConfigsIsExist(String type1, String type2, String type3, List<StoreConfigInfoDTO> addList) {
//        String ret = "";
//        List<ProductStoreLimitConfig> configs = storeLimitConfigDao.getStoreConfigsByProductType(type1, type2, type3);
//        if (addList != null && addList.size() > 0 && configs != null && configs.size() > 0) {
//
//            for (StoreConfigInfoDTO infoDTO : addList) {
//                if (infoDTO.getNodeType() != null && infoDTO.getNodeType() == 1) {
//                    for (ProductStoreLimitConfig config : configs) {
//                        if (config.getStoreCode().equals(infoDTO.getStoreCode())) {
//                            ret = infoDTO.getName();
//                            break;
//                        }
//                    }
//                    if (!StringUtils.isBlank(ret))
//                        break;
//                }
//            }
//        }
//        return ret;
//    }

    @Override
    public ProductQryResponseDTO getProductById(String bizid) {

        ProductQryResponseDTO responseDTO = new ProductQryResponseDTO();
        List<CommissionConfigInfoDTO> commissionConfigInfoDTO = null;
        //查找产品
        ProductVo product = this.productDao.selectProductByBizid(bizid);
        if (product != null) {
            String accountKey = this.getAccountKey();
            ProductInfoDTO productInfoDTO = productMapper.map(product, ProductInfoDTO.class);
            responseDTO.setProductInfoDTO(productInfoDTO);

            //查找支持期数
            List<SupportPaytime> listsp = supportPaytimeDao.getSupportPaytimesByProductCode(product.getProductCode());
            if (listsp != null && listsp.size() > 0) {
                List<SupportTimeInfoDTO> supportTimeInfoDTOS = supportPaytimeMapper.mapAsList(listsp, SupportTimeInfoDTO.class);
                responseDTO.setSupportTimeInfos(supportTimeInfoDTOS);
            }
            //查找还款包源
            List<RepaymentPackage> listrp = repaymentPackageDao.getRepaymentPackagesByCode(product.getProductCode());
            if (listrp != null && listrp.size() > 0) {
                List<RepaymentInfoDTO> repaymentInfoDTO = repaymentPackageMapper.mapAsList(listrp, RepaymentInfoDTO.class);
                responseDTO.setRepaymentInfoDTO(repaymentInfoDTO);
            }

            //查找分润配置
            List<CommissionConfig> listsc = commissionConfigDao.getCommissionConfigsByProductCode(product.getProductCode());
            if (listsc != null && listsc.size() > 0) {
                commissionConfigInfoDTO = commissionConfigMapper.mapAsList(listsc, CommissionConfigInfoDTO.class);
                responseDTO.setCommissionConfigInfos(commissionConfigInfoDTO);
            }
            //分润配置分组排序---按职位从高到低---按单量从高到低
            if (commissionConfigInfoDTO != null && commissionConfigInfoDTO.size() > 0) {
                Map<String, List<CommissionConfigInfoDTO>> maps = new HashedMap();
                for (CommissionConfigInfoDTO configInfoDTO : commissionConfigInfoDTO) {
                    String key = "";
                    if (configInfoDTO.getLowerLimit() != null && configInfoDTO.getUpperLimit() != null)
                        key = configInfoDTO.getLowerLimit().toString() + "-" + configInfoDTO.getUpperLimit().toString();

                    List<CommissionConfigInfoDTO> infos = maps.get(key);
                    if (infos == null)
                        infos = new ArrayList<>();
                    infos.add(configInfoDTO);
                    maps.put(key, infos);
                }
                //设置分组
                List<CommissionArray> array = new ArrayList<>();
                for (String key : maps.keySet()) {
                    CommissionArray commissionArray = new CommissionArray();
                    commissionArray.setCommission(maps.get(key));
                    array.add(commissionArray);
                }
                //逆序排序
                Collections.reverse(array);
                responseDTO.setCommissionArray(array);
            }
            //经营范围
            OrganizationTreeResponseDTO orgTree = merchantStoreUilt.getBelongOrgsByAdminCode(accountKey);
            if (orgTree != null) {
                OrganizationTreeNodes oTreeNodes = orgTree.getData();
                if (oTreeNodes != null) {
                    List<ProductStoreLimitConfig> listpslc = storeLimitConfigDao.getStoreConfigsByProductCode(product.getProductCode());
                    StoreConfigTreeInfoDTO treeInfoDTO = new StoreConfigTreeInfoDTO();
                    treeInfoDTO.setId(oTreeNodes.getId());
                    treeInfoDTO.setPid(oTreeNodes.getpId());
                    treeInfoDTO.setName(oTreeNodes.getName());
                    Boolean ischecked = getIsChecked(treeInfoDTO.getId(), listpslc);
                    treeInfoDTO.setChecked(ischecked);
                    List<StoreConfigTreeInfoDTO> subNodes = new ArrayList<>();
                    subNodes = getSubNodes(subNodes, oTreeNodes.getNodes(), listpslc);
                    treeInfoDTO.setNodes(subNodes);
                    responseDTO.setStoreConfigInfo(treeInfoDTO);
                }
            }
            //经营范围(Only Checked)
            if (orgTree != null) {
                OrganizationTreeNodes oTreeNodes = orgTree.getData();
                if (oTreeNodes != null) {
                    List<ProductStoreLimitConfig> listpslc = storeLimitConfigDao.getStoreConfigsByProductCode(product.getProductCode());
                    StoreConfigTreeInfoDTO treeInfoDTO = new StoreConfigTreeInfoDTO();
                    Boolean ischecked = getIsChecked(oTreeNodes.getId(), listpslc);
                    if (ischecked) {
                        treeInfoDTO.setId(oTreeNodes.getId());
                        treeInfoDTO.setPid(oTreeNodes.getpId());
                        treeInfoDTO.setName(oTreeNodes.getName());
                        treeInfoDTO.setChecked(ischecked);
                        List<StoreConfigTreeInfoDTO> subNodes = new ArrayList<>();
                        subNodes = getSubCheckedNodes(subNodes, oTreeNodes.getNodes(), listpslc);
                        treeInfoDTO.setNodes(subNodes);
                        responseDTO.setStoreConfigInfoChecked(treeInfoDTO);
                    }
                }
            }
            responseDTO.successfully();
        } else {
            responseDTO.setMessage(ResponseCodeEnums.NOT_MEET_CONDITIONS_DATA.getDisplayName());
        }
        return responseDTO;
    }

    private List<StoreConfigTreeInfoDTO> getSubCheckedNodes(List<StoreConfigTreeInfoDTO> subNodes, List<OrganizationTreeNodes> nodes, List<ProductStoreLimitConfig> listpslc) {
        if (nodes != null && nodes.size() > 0) {
            for (OrganizationTreeNodes treeNodes : nodes) {
                StoreConfigTreeInfoDTO treeInfoDTO = new StoreConfigTreeInfoDTO();
                Boolean ischecked = getIsChecked(treeNodes.getId(), listpslc);
                if (ischecked) {
                    treeInfoDTO.setId(treeNodes.getId());
                    treeInfoDTO.setPid(treeNodes.getpId());
                    treeInfoDTO.setName(treeNodes.getName());
                    treeInfoDTO.setChecked(ischecked);
                    List<StoreConfigTreeInfoDTO> sNodes = new ArrayList<>();
                    sNodes = getSubCheckedNodes(sNodes, treeNodes.getNodes(), listpslc);
                    treeInfoDTO.setNodes(sNodes);
                    subNodes.add(treeInfoDTO);
                }
            }
        }
        return subNodes;
    }

    private List<StoreConfigTreeInfoDTO> getSubNodes(List<StoreConfigTreeInfoDTO> subNodes, List<OrganizationTreeNodes> nodes, List<ProductStoreLimitConfig> listpslc) {
        if (nodes != null && nodes.size() > 0) {
            for (OrganizationTreeNodes treeNodes : nodes) {
                StoreConfigTreeInfoDTO treeInfoDTO = new StoreConfigTreeInfoDTO();
                treeInfoDTO.setId(treeNodes.getId());
                treeInfoDTO.setPid(treeNodes.getpId());
                treeInfoDTO.setName(treeNodes.getName());
                Boolean ischecked = getIsChecked(treeInfoDTO.getId(), listpslc);
                treeInfoDTO.setChecked(ischecked);
                List<StoreConfigTreeInfoDTO> sNodes = new ArrayList<>();
                sNodes = getSubNodes(sNodes, treeNodes.getNodes(), listpslc);
                treeInfoDTO.setNodes(sNodes);
                subNodes.add(treeInfoDTO);
            }
        }
        return subNodes;
    }

    private Boolean getIsChecked(String id, List<ProductStoreLimitConfig> listpslc) {
        Boolean ret = false;
        if (listpslc != null && listpslc.size() > 0) {
            for (ProductStoreLimitConfig config : listpslc) {
                if (config.getStoreCode() != null && config.getStoreCode().equals(id)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 修改产品
     */
    @Override
    public ProductResponseDTO updateProduct(ProductUpdateDTO productUpdateDTO) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        ProductInfoDTO productInfoDTO = productUpdateDTO.getProductInfoDTO();
//        if (StringUtils.isBlank(productInfoDTO.getLevel1Code()) || StringUtils.isBlank(productInfoDTO.getLevel2Code()) || StringUtils.isBlank(productInfoDTO.getLevel3Code())) {
//            responseDTO.setMessage("产品分类不能为空!");
//            return responseDTO;
//        } else
        if (StringUtils.isBlank(productInfoDTO.getProductName())) {
            responseDTO.setMessage("产品名称不能为空!");
            return responseDTO;
        } else if (productUpdateDTO.getSupportTimeInfos() == null || productUpdateDTO.getSupportTimeInfos().size() < 1) {
            responseDTO.setMessage("支持期数不能为空!");
            return responseDTO;
        } else if (productUpdateDTO.getSupportTimeInfos().size() > 0) {
            Map<String, Integer> maps = new HashedMap();
            for (SupportTimeInfoDTO infoDTO : productUpdateDTO.getSupportTimeInfos()) {
                if (infoDTO.getPaytimeUnit() != null) {
                    String key = infoDTO.getPaytimeUnit().getEnumName() + "-" + infoDTO.getPayTime().toString();
                    Integer integer = maps.get(key);
                    if (integer != null) {
                        responseDTO.setMessage("同一日期单位下的支持期数不能重复!");
                        return responseDTO;
                    } else
                        maps.put(key, infoDTO.getPayTime());
                }
            }
        } else if (productUpdateDTO.getCommissionConfigInfos() == null || productUpdateDTO.getCommissionConfigInfos().size() < 1) {
            responseDTO.setMessage("提成方案不能为空!");
            return responseDTO;
        } else if (productUpdateDTO.getRepaymentConfigInfos() == null || productUpdateDTO.getRepaymentConfigInfos().size() < 1) {
            responseDTO.setMessage("利率配置不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getInterestType() == null) {
            responseDTO.setMessage("计息方式不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getMoneyResource() == null) {
            responseDTO.setMessage("资金来源不能为空!");
            return responseDTO;
        } else if (productInfoDTO.getLoanType() == null) {
            responseDTO.setMessage("放款对象不能为空!");
            return responseDTO;
        }

//        String name = this.checkStoreConfigsIsExist(productInfoDTO.getLevel1Code(), productInfoDTO.getLevel2Code(), productInfoDTO.getLevel3Code(), productUpdateDTO.getStoreConfigInfoS());
//        if (!StringUtils.isBlank(name)) {
//            responseDTO.setMessage("名称为:" + name + "的商区已经关联了改产品类型,请重新选择!");
//            return responseDTO;
//        }
        List<ProductVo> exists = productDao.selectProductByTypeAndName(productInfoDTO.getLevel1Code(), productInfoDTO.getLevel2Code(), productInfoDTO.getLevel3Code(), productInfoDTO.getProductName());
        if (exists != null && exists.size() > 0) {
            for (ProductVo vo : exists) {
                if ((!vo.getBizid().equals(productInfoDTO.getBizid())) || (!vo.getProductCode().equals(productInfoDTO.getProductCode()))) {
                    responseDTO.setMessage("该分类下已存在同名产品!");
                    return responseDTO;
                }
            }
        }


        BigDecimal total = getTotalRate(productUpdateDTO.getRepaymentConfigInfos());

        String productCode = "";
        try {
            //修改产品
            Product updateProduct = productMapper.map(productUpdateDTO.getProductInfoDTO(), Product.class);
            updateProduct = this.dtoToModel(updateProduct, productUpdateDTO.getProductInfoDTO());
            updateProduct.setState(ProductStateEnum.PENDING_APPROVAL.getValue());
            productCode = updateProduct.getProductCode();
            updateProduct.setTotalRate(total);
            if (StringUtils.isBlank(updateProduct.getLevel1Code()))
                updateProduct.setLevel1Code(null);
            if (StringUtils.isBlank(updateProduct.getLevel2Code()))
                updateProduct.setLevel2Code(null);
            if (StringUtils.isBlank(updateProduct.getLevel3Code()))
                updateProduct.setLevel3Code(null);
            int productCount = productDao.updateProduct(updateProduct);
            if (productCount > 0) {

                deleteSupportPaytimes(productCode);
                deleteCommissionConfigs(productCode);
                deleteRepaymentPackageConfigs(productCode);
                deleteStoreConfigs(productCode);

                addSupportPaytimes(productUpdateDTO.getSupportTimeInfos(), responseDTO, productCode);
                addCommissionConfigs(productUpdateDTO.getCommissionConfigInfos(), responseDTO, productCode);
                addRepaymentPackageConfigs(productUpdateDTO.getRepaymentConfigInfos(), responseDTO, productCode);
                addStoreConfigs(productUpdateDTO.getStoreConfigInfoS(), responseDTO, productCode);

                System.out.println("修改产品成功!");
                responseDTO.successfully();
                responseDTO.setMessage("修改产品成功!");
            } else {
                System.out.println("修改产品失败!");
                responseDTO.setMessage("修改产品失败!");
            }
        } catch (Exception ex) {
            System.out.println("修改产品异常!" + ex.getMessage());
            responseDTO.setMessage("修改产品异常!");
        }
        return responseDTO;
    }

    //删除还款包源
    private void deleteRepaymentPackageConfigs(String productCode) {
        repaymentPackageConfigDao.deleteRepaymentConfigsByProductCode(productCode);
    }

    //删除分润配置
    private void deleteCommissionConfigs(String productCode) {
        commissionConfigDao.deleteCommissionConfigsByProductCode(productCode);
    }

    //删除支持期数
    private void deleteSupportPaytimes(String productCode) {
        supportPaytimeDao.deleteSupportPaytimesByProductCode(productCode);
    }

    //删除经营范围
    private void deleteStoreConfigs(String productCode) {
        storeLimitConfigDao.deleteStoreConfigsByProductCode(productCode);
    }

    @Override
    public ProductResponseDTO updateAuditProduct(final String bizid, UpdProductStateDTO requestDTO, final String adminCode) {
        return this.service(requestDTO, ProductResponseDTO.class, new MyServiceExecutor<UpdProductStateDTO, ProductResponseDTO>() {

            protected ProductResponseDTO myprocess(UpdProductStateDTO requestDTO) throws Exception {
                ProductResponseDTO responseDTO = new ProductResponseDTO();
                if (StringUtils.isBlank(bizid)) {
                    responseDTO.setMessage("审核数据异常");
                    return responseDTO;
                }
                try {
                    int re = productDao.selectByBizid(bizid);
                    if (re < 1) {
                        responseDTO.setMessage("要审核的产品不存在");
                        return responseDTO;
                    }
                } catch (Exception e) {
                    responseDTO.setMessage("查询产品异常");
                    return responseDTO;
                }
                Product product = new Product();
                product.setBizid(bizid);

                if (requestDTO.getProState() != null) {
                    String employeeCode = getEmployeeCode();
                    //通过
                    if (requestDTO.getProState().equals("1")) {
                        product.setState(ProductStateEnum.NORMAL.getValue());
                        try {
                            int m = productDao.updateProductState(product);
                            if (m != 1) {
                                responseDTO.handleFailed();
                                responseDTO.setMessage("审核操作失败");
                                return responseDTO;
                            }
                        } catch (Exception e) {
                            System.out.println("审核操作异常" + e.getMessage());
                            responseDTO.setMessage("审核操作异常");
                            return responseDTO;
                        }
                        try {
                            StateChangeLog stateChangeLog = new StateChangeLog();
                            stateChangeLog.setStateCode(requestDTO.getProState());
                            stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
                            stateChangeLog.setOperationPerson(employeeCode);
                            stateChangeLog.setState(ProductStateEnum.NORMAL.getValue());
                            stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
                            Product pro = productDao.selectProductByBizid(bizid);
                            stateChangeLog.setProductCode(pro.getProductCode());
                            stateChangeLogDao.insert(stateChangeLog);
                        } catch (Exception e) {
                            System.out.println("添加操作记录异常" + e.getMessage());
                        }
                        responseDTO.setMessage("审核通过");
                        responseDTO.successfully();
                        return responseDTO;
                    }
                    //拒绝
                    else if (requestDTO.getProState().equals("3")) {
                        product.setState(ProductStateEnum.DISABLED.getValue());
                        try {
                            int m = productDao.updateProductState(product);
                            if (m != 1) {
                                responseDTO.handleFailed();
                                responseDTO.setMessage("审核操作失败");
                                return responseDTO;
                            }
                        } catch (Exception e) {
                            System.out.println("审核操作异常" + e.getMessage());
                            responseDTO.setMessage("审核操作异常");
                            return responseDTO;
                        }
                        try {
                            StateChangeLog stateChangeLog = new StateChangeLog();
                            stateChangeLog.setStateCode(requestDTO.getProState());
                            stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
                            stateChangeLog.setOperationPerson(employeeCode);
                            stateChangeLog.setState(ProductStateEnum.DISABLED.getValue());
                            stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
                            Product pro = productDao.selectProductByBizid(bizid);
                            stateChangeLog.setProductCode(pro.getProductCode());
                            stateChangeLogDao.insert(stateChangeLog);
                        } catch (Exception e) {
                            System.out.println("添加操作记录异常" + e.getMessage());
                        }
                        responseDTO.setMessage("已拒绝");
                        responseDTO.successfully();
                        return responseDTO;
                    }
                    //驳回
                    else if (requestDTO.getProState().equals("4")) {
                        product.setState(ProductStateEnum.REJECT.getValue());
                        try {
                            int m = productDao.updateProductState(product);
                            if (m != 1) {
                                responseDTO.handleFailed();
                                responseDTO.setMessage("审核操作失败");
                                return responseDTO;
                            }
                        } catch (Exception e) {
                            System.out.println("审核操作异常" + e.getMessage());
                            responseDTO.setMessage("审核操作异常");
                            return responseDTO;
                        }
                        try {
                            StateChangeLog stateChangeLog = new StateChangeLog();
                            stateChangeLog.setStateCode(requestDTO.getProState());
                            stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
                            stateChangeLog.setOperationPerson(employeeCode);
                            stateChangeLog.setState(ProductStateEnum.REJECT.getValue());
                            stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
                            Product pro = productDao.selectProductByBizid(bizid);
                            stateChangeLog.setProductCode(pro.getProductCode());
                            int i = stateChangeLogDao.insert(stateChangeLog);
                        } catch (Exception e) {
                            System.out.println("操作失败" + e.getMessage());
                        }
                        responseDTO.setMessage("已驳回");
                        responseDTO.successfully();
                        return responseDTO;
                    }
                    //其它
                    else {
                        responseDTO.setMessage("输入的数据无法识别，请再输一次");
                        return responseDTO;
                    }

                }
                return responseDTO;
            }

            protected void beforeProcess(UpdProductStateDTO requestDTO) throws Exception {

            }

            ;
        });
    }

    @Override
    public ProductResponseDTO updateStartProduct(final String bizid, ProductStateDTO requestDTO, final String adminCode) {
        return this.service(requestDTO, ProductResponseDTO.class, new MyServiceExecutor<ProductStateDTO, ProductResponseDTO>() {

            protected ProductResponseDTO myprocess(ProductStateDTO requestDTO) throws Exception {
                ProductResponseDTO responseDTO = new ProductResponseDTO();
                int re = productDao.selectByBizid(bizid);
                if (re < 1) {
                    throw new MyBizException("要操作的产品不存在");
                }
                Product product = new Product();
                product.setBizid(bizid);
                product.setState(ProductStateEnum.NORMAL.getValue());
                try {
                    int m = productDao.updateProductState(product);
                    if (m != 1) {
                        responseDTO.handleFailed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return responseDTO;
                }


                //获取员工编号
                String employeeCode = getEmployeeCode();
                StateChangeLog stateChangeLog = new StateChangeLog();
                stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
                stateChangeLog.setOperationPerson(employeeCode);
                stateChangeLog.setStateCode(requestDTO.getDataName());
                stateChangeLog.setState(ProductStateEnum.NORMAL.getValue());
                stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
                Product pro = productDao.selectProductByBizid(bizid);
                stateChangeLog.setProductCode(pro.getProductCode());
                try {
                    int i = stateChangeLogDao.insert(stateChangeLog);
                    if (i != 1) {
                        responseDTO.handleFailed();
                    } else {
                        responseDTO.setMessage("启用成功");
                        responseDTO.successfully();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return responseDTO;
            }

            protected void beforeProcess(UpdProductStateDTO requestDTO) throws Exception {

            }

            ;
        });
    }

    @Override
    public ProductResponseDTO updateForbiddenProduct(final String bizid, ProductStateDTO requestDTO, final String adminCode) {
        return this.service(requestDTO, ProductResponseDTO.class, new MyServiceExecutor<ProductStateDTO, ProductResponseDTO>() {

            protected ProductResponseDTO myprocess(ProductStateDTO requestDTO) throws Exception {
                ProductResponseDTO responseDTO = new ProductResponseDTO();
                int re = productDao.selectByBizid(bizid);
                if (re < 1) {
                    throw new MyBizException("要操作的产品不存在");
                }
                Product product = new Product();
                product.setBizid(bizid);
                product.setState(ProductStateEnum.DECLINE.getValue());
                try {
                    int m = productDao.updateProductState(product);
                    if (m != 1) {
                        responseDTO.handleFailed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return responseDTO;
                }

                //获取员工编号
                String employeeCode = getEmployeeCode();

                StateChangeLog stateChangeLog = new StateChangeLog();
                stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
                stateChangeLog.setOperationPerson(employeeCode);
                stateChangeLog.setStateCode(requestDTO.getDataName());
                stateChangeLog.setState(ProductStateEnum.DECLINE.getValue());
                stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
                Product pro = productDao.selectProductByBizid(bizid);
                stateChangeLog.setProductCode(pro.getProductCode());
                try {
                    int i = stateChangeLogDao.insert(stateChangeLog);
                    if (i != 1) {
                        responseDTO.handleFailed();
                    } else {
                        responseDTO.setMessage("禁用成功");
                        responseDTO.successfully();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return responseDTO;
            }

            protected void beforeProcess(UpdProductStateDTO requestDTO) throws Exception {

            }

            ;
        });
    }

    @Override
    public ProductResponseDTO deleteProduct(final String bizid, ProductDeleteDTO requestDTO, final String adminCode) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        int re = productDao.selectByBizid(bizid);
        if (re < 1) {
            responseDTO.setMessage("要操作的产品不存在");
            return responseDTO;
        }
        try {
            int n = productDao.updateProductEnabled(bizid);
            if (n == 1) {
                responseDTO.successfully();
                responseDTO.setMessage(ResponseCodeEnums.SUCCESSFULLY.getDisplayName());
            } else {
                responseDTO.handleFailed();
                responseDTO.setMessage(ResponseCodeEnums.ILLEGAL_ARGUMENT_EXCEPTION.getDisplayName());
            }
        } catch (MyBizException e) {
            e.printStackTrace();
            return responseDTO;
        }

        //获取员工编号
        String employeeCode = getEmployeeCode();

        StateChangeLog stateChangeLog = new StateChangeLog();
        stateChangeLog.setDeleted(YesOrNoEnum.NO.getValue());
        stateChangeLog.setOperationPerson(employeeCode);
        stateChangeLog.setStateCode(requestDTO.getDataValue());
        stateChangeLog.setState(ProductStateEnum.DELETED.getValue());
        stateChangeLog.setStateRemark(requestDTO.getStateRemarks());
        Product pro = productDao.selectProductByBizid(bizid);
        stateChangeLog.setProductCode(pro.getProductCode());
        try {
            int i = stateChangeLogDao.insert(stateChangeLog);
            if (i != 1) {
                responseDTO.handleFailed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;

    }

    @Override
    public RepaymentResponseDTO getRepaymentPackagesByConditions(RepaymentDTO repaymentDTO) {
        RepaymentResponseDTO repaymentResponseDTO = new RepaymentResponseDTO();

        String name = repaymentDTO.getName();
        Integer type = repaymentDTO.getType() == null ? null : repaymentDTO.getType().getValue();
        Integer paytimeType = repaymentDTO.getPaytimeType() == null ? null : repaymentDTO.getPaytimeType().getValue();

        List<RepaymentPackage> repaymentPackages = null;
        try {
            repaymentPackages = repaymentPackageDao.getRepaymentPackagesByConditions(name, type, paytimeType);
        } catch (Exception e) {
            System.out.println("获取还款包源关键字列表异常!");
            repaymentResponseDTO.setMessage("获取还款包源关键字列表异常!");
        }
        if (repaymentPackages.size() > 0) {
            List<RepaymentKeysDTO> keys = new ArrayList<>();
            if (name == null || name == "") {
                for (RepaymentPackage repaymentPackage : repaymentPackages) {

                    YesOrNoEnum yesOrNoEnum = (repaymentPackage.getIsChoice() != null && repaymentPackage.getIsChoice() == 1) ? YesOrNoEnum.YES : YesOrNoEnum.NO;
                    RepaymentKeysDTO keysDTO = new RepaymentKeysDTO(repaymentPackage.getPackageCode(), repaymentPackage.getName(), repaymentPackage.getName(), yesOrNoEnum);
                    if ((!StringUtils.isBlank(repaymentPackage.getName())) && !keys.contains(keysDTO))
                        keys.add(keysDTO);
                }
            } else if (type == null) {
                for (RepaymentPackage repaymentPackage : repaymentPackages) {
                    String typename = "";
                    String displayname = "";
                    for (AlgorithmTypeEnum item : AlgorithmTypeEnum.values()) {
                        if (item.getValue() == Integer.valueOf(repaymentPackage.getType())) {
                            typename = item.getEnumName();
                            displayname = item.getDisplayName();
                        }
                    }
                    YesOrNoEnum yesOrNoEnum = (repaymentPackage.getIsChoice() != null && repaymentPackage.getIsChoice() == 1) ? YesOrNoEnum.YES : YesOrNoEnum.NO;
                    RepaymentKeysDTO keysDTO = new RepaymentKeysDTO(repaymentPackage.getPackageCode(), typename, displayname, yesOrNoEnum);
                    if ((!StringUtils.isBlank(typename)) && (!keys.contains(keysDTO)))
                        keys.add(keysDTO);
                }
            } else if (paytimeType == null) {
                for (RepaymentPackage repaymentPackage : repaymentPackages) {
                    String typename = "";
                    String displayname = "";
                    for (PaytimeTypeEnum item : PaytimeTypeEnum.values()) {
                        if (item.getValue() == Integer.valueOf(repaymentPackage.getPaytimeType())) {
                            typename = item.getEnumName();
                            displayname = item.getDisplayName();
                        }
                    }
                    YesOrNoEnum yesOrNoEnum = (repaymentPackage.getIsChoice() != null && repaymentPackage.getIsChoice() == 1) ? YesOrNoEnum.YES : YesOrNoEnum.NO;
                    RepaymentKeysDTO keysDTO = new RepaymentKeysDTO(repaymentPackage.getPackageCode(), typename, displayname, yesOrNoEnum);
                    if ((!StringUtils.isBlank(typename)) && (!keys.contains(keysDTO)))
                        keys.add(keysDTO);
                }
            } else {
                for (RepaymentPackage repaymentPackage : repaymentPackages) {
                    BigDecimal typevalue = repaymentPackage.getValue();
                    YesOrNoEnum yesOrNoEnum = (repaymentPackage.getIsChoice() != null && repaymentPackage.getIsChoice() == 1) ? YesOrNoEnum.YES : YesOrNoEnum.NO;
                    RepaymentKeysDTO keysDTO = new RepaymentKeysDTO(repaymentPackage.getPackageCode(), typevalue.toString(), typevalue.toString(), yesOrNoEnum);
                    if ((typevalue != null && !keys.contains(keysDTO)))
                        keys.add(keysDTO);
                }
            }
            repaymentResponseDTO.setRepaymentKeys(keys);
            System.out.println("获取还款包源关键字列表成功!");
            repaymentResponseDTO.successfully();
            repaymentResponseDTO.setMessage("获取还款包源关键字列表成功!");
        } else {
            System.out.println("获取还款包源关键字列表成功,但数据为空!");
            repaymentResponseDTO.successfully();
            repaymentResponseDTO.setMessage("获取还款包源关键字列表成功,但数据为空!");
        }
        return repaymentResponseDTO;
    }

    @Override
    public ProductTypeResponseDTO getPruductTypes(String typeCode) {

        ProductTypeResponseDTO responseDTO = new ProductTypeResponseDTO();
        List<ProductEnumModelDTO> modelDTOS = new ArrayList<>();
        try {
            List<Dictionary> dictionaries = dictionaryDao.getProductTypes(ProductDictionaryEnum.PRODUCT_TYPE.getEnumName(), typeCode);
            for (Dictionary dictionary : dictionaries) {
                modelDTOS.add(new ProductEnumModelDTO(dictionary.getDataCode(), dictionary.getDataName()));
            }
            responseDTO.setProductEnumModels(modelDTOS);
            responseDTO.successfully();
            System.out.println("获取产品分类成功!");
        } catch (Exception e) {
            System.out.println("获取产品分类异常!" + e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ProductEnumDTO getUIEnums() {

        ProductEnumDTO responseDTO = new ProductEnumDTO();

        List<ProductEnumModelDTO> productStates = new ArrayList<>();
        for (ProductStateEnum item : ProductStateEnum.values()) {
            productStates.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setProductStates(productStates);

        List<ProductEnumModelDTO> positions = new ArrayList<>();
        for (PositionEnum item : PositionEnum.values()) {
            positions.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setPositions(positions);

        List<ProductEnumModelDTO> supportTimess = new ArrayList<>();
        for (PaytimeUnitEnum item : PaytimeUnitEnum.values()) {
            supportTimess.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setSupportTimes(supportTimess);

        List<ProductEnumModelDTO> commissions = new ArrayList<>();
        for (CommissionTypeEnum item : CommissionTypeEnum.values()) {
            commissions.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setCommissions(commissions);

        List<ProductEnumModelDTO> interests = new ArrayList<>();
        for (InterestTypeEnum item : InterestTypeEnum.values()) {
            interests.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setInterests(interests);

        List<ProductEnumModelDTO> moneyresources = new ArrayList<>();
        for (MoneyResourceEnum item : MoneyResourceEnum.values()) {
            moneyresources.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setMoneyresources(moneyresources);

        List<ProductEnumModelDTO> loantypes = new ArrayList<>();
        for (LoanTypeEnum item : LoanTypeEnum.values()) {
            loantypes.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setLoantypes(loantypes);

        List<ProductEnumModelDTO> enableds = new ArrayList<>();
        for (ProductEnabledEnum item : ProductEnabledEnum.values()) {
            enableds.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setEnableds(enableds);

        List<ProductEnumModelDTO> unableds = new ArrayList<>();
        for (ProductUnabledEnum item : ProductUnabledEnum.values()) {
            unableds.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setUnableds(unableds);

        List<ProductEnumModelDTO> deleteds = new ArrayList<>();
        for (ProductDeletedEnum item : ProductDeletedEnum.values()) {
            deleteds.add(new ProductEnumModelDTO(item.getValue(), item.getEnumName(), item.getDisplayName()));
        }
        responseDTO.setDeleteds(deleteds);
        responseDTO.successfully();
        return responseDTO;
    }

    @Override
    public DictonaryResponseDTO getEnableTypeList() {
        DictonaryResponseDTO responseDTO = new DictonaryResponseDTO();
        List<Dictionary> dictionaryList = dictionaryDao.getEnableTypeList();
        if (dictionaryList != null && dictionaryList.size() > 0) {
            List<DictionaryInfoDTO> productInfoDTOS = dictionaryMapper.mapAsList(dictionaryList, DictionaryInfoDTO.class);
            responseDTO.setList(productInfoDTOS);
            responseDTO.successfully();
        } else {
            responseDTO.setMessage("查无数据");
        }
        return responseDTO;
    }

    @Override
    public DictonaryResponseDTO getUnableTypeList() {
        DictonaryResponseDTO responseDTO = new DictonaryResponseDTO();
        List<Dictionary> dictionaryList = dictionaryDao.getUnableTypeList();
        if (dictionaryList != null && dictionaryList.size() > 0) {
            List<DictionaryInfoDTO> productInfoDTOS = dictionaryMapper.mapAsList(dictionaryList, DictionaryInfoDTO.class);
            responseDTO.setList(productInfoDTOS);
            responseDTO.successfully();
        } else {
            responseDTO.setMessage("查无数据");
        }
        return responseDTO;
    }

    @Override
    public DictonaryResponseDTO getDeletedTypeList() {
        DictonaryResponseDTO responseDTO = new DictonaryResponseDTO();
        List<Dictionary> dictionaryList = dictionaryDao.getDeletedTypeList();
        if (dictionaryList != null && dictionaryList.size() > 0) {
            List<DictionaryInfoDTO> productInfoDTOS = dictionaryMapper.mapAsList(dictionaryList, DictionaryInfoDTO.class);
            responseDTO.setList(productInfoDTOS);
            responseDTO.successfully();
        } else {
            responseDTO.setMessage("查无数据");
        }
        return responseDTO;
    }

    @Override
    public OrganizationTreeResponseDTO getStoreConfigTree() {

        String accountKey = this.getAccountKey();
//        accountKey = "admin";
        return merchantStoreUilt.getBelongOrgsByAdminCode(accountKey);
    }

    @Override
    public AdminCodeAndEmployeeCodeDTO getAdminCodeAndEmployeeCode() {

        AdminCodeAndEmployeeCodeDTO codeDTO = new AdminCodeAndEmployeeCodeDTO();

        try {
            String accountKey = this.getAccountKey();
            String employeeCode = this.getEmployeeCode();
            codeDTO.setAdminCode(accountKey);
            codeDTO.setEmployeeCode(employeeCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codeDTO;
    }

    private String getAccountKey() {
        String ret = "";
        try {
            ret = userInfoClient.getAccountKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ret="mengyanling";
        return ret;
    }

    //根据adminCode获取员工编号
    private String getEmployeeCode() {
        //获取员工编号
        String employeeCode = "";
        OrgEmployeeResponseDTO orgEmployeeResponseDTO = orgEmployeeUtil.getEmployeeCode(this.getAccountKey());
        if (orgEmployeeResponseDTO != null) {
            List<OrgEmployeeInfoDTO> orgEmployeeInfoDTO = orgEmployeeResponseDTO.getCode();
            if (orgEmployeeInfoDTO != null && orgEmployeeInfoDTO.size() > 0)
                employeeCode = orgEmployeeInfoDTO.get(0).getEmployeeCode();

        }
        return employeeCode;
    }

    private String getProductCode(String type1, String type2, String type3) {
        String productCode = "";

        try {
            String maxCode = productDao.getMaxCode();

            String level1 = null;
            try {
                level1 = dictionaryDao.findDataValue(type1);
            } catch (Exception e) {
                level1 = "YC";
            }
            level1 = level1 == null ? "QB" : level1;
            String level2 = null;
            try {
                level2 = dictionaryDao.findDataValue(type2);
            } catch (Exception e) {
                level2 = "YC";
            }
            level2 = level2 == null ? "QB" : level2;
            String level3 = null;
            try {
                level3 = dictionaryDao.findDataValue(type3);
            } catch (Exception e) {
                level3 = "YC";
            }
            level3 = level3 == null ? "QB" : level3;
            String prefix = level1 + level2 + level3;

            if (StringUtils.isBlank(maxCode)) {
                productCode = prefix + "00001C";
            } else {
                String numCode = maxCode.substring(maxCode.length() - 6, maxCode.length() - 1);
                Integer i = Integer.valueOf(numCode);
                i++;
                productCode = prefix + String.format("%05d", i) + "C";
            }
        } catch (NumberFormatException e) {
            productCode = null;
            System.out.println("生成产品编号异常" + e.getMessage());
        }
        return productCode;
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
