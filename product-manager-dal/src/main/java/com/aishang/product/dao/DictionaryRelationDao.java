package com.aishang.product.dao;

import com.aishang.product.model.DictionaryRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface DictionaryRelationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryRelation record);

    int insertSelective(DictionaryRelation record);

    DictionaryRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryRelation record);

    int updateByPrimaryKey(DictionaryRelation record);

    /**
     * 修改字典表数据
     *
     * @param dictionary
     * @return
     */
    int update(DictionaryRelation dictionary);

    /**
     * 添加字典信息
     *
     * @param dictionary
     * @return
     */
    void add(DictionaryRelation dictionary);

    Integer getDataCountByCode(@Param("dataCode") String dataCode, @Param("parentCode") String parentCode);
}