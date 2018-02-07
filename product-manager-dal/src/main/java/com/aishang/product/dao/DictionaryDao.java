package com.aishang.product.dao;

import com.aishang.product.model.Dictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictionaryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    /**
     * 产品分类联动查询
     */
    List<Dictionary> getProductTypes(@Param("dictionarytype") String dictionaryType, @Param("typecode") String typeCode);


    /**
     * 查询产品启用原因列表
     */
    List<Dictionary> getEnableTypeList();

    /**
     * 查询产禁用原因列表
     */
    List<Dictionary> getUnableTypeList();

    /**
     * 查询产品删除原因列表
     */
    List<Dictionary> getDeletedTypeList();

    /**
     * 根据dataValue获得DataName
     */
    Dictionary getDataName(String datevalue);

    /**
     * 修改字典表数据
     *
     * @param dictionary
     * @return
     */
    int update(Dictionary dictionary);

    /**
     * 添加字典信息
     *
     * @param dictionary
     * @return
     */
    void add(Dictionary dictionary);

    /**
     * 查询字典代号
     *
     * @param dataCode
     * @return
     */
    String findDataValue(String dataCode);


    /**
     * 获取字典数量
     *
     * @param dataCode
     * @return
     */
    Integer getDataCountByCode(@Param("dataCode") String dataCode);
}