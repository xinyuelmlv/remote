package com.maple.earnings.mapper;

import com.maple.earnings.pojo.EProduct;
import com.maple.earnings.pojo.EProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EProductMapper {
    int countByExample(EProductExample example);

    int deleteByExample(EProductExample example);

    int deleteByPrimaryKey(Long numIid);

    int insert(EProduct record);

    int insertSelective(EProduct record);

    List<EProduct> selectByExample(EProductExample example);
    
    List<EProduct> selectProAndCostByExample(EProductExample example);

    EProduct selectByPrimaryKey(Long numIid);

    int updateByExampleSelective(@Param("record") EProduct record, @Param("example") EProductExample example);

    int updateByExample(@Param("record") EProduct record, @Param("example") EProductExample example);

    int updateByPrimaryKeySelective(EProduct record);

    int updateByPrimaryKey(EProduct record);
}