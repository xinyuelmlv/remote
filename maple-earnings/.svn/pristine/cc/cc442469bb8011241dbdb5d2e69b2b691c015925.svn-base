package com.maple.earnings.mapper;

import com.maple.earnings.pojo.EProductCost;
import com.maple.earnings.pojo.EProductCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EProductCostMapper {
    int countByExample(EProductCostExample example);

    int deleteByExample(EProductCostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EProductCost record);

    int insertSelective(EProductCost record);

    List<EProductCost> selectByExample(EProductCostExample example);

    EProductCost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EProductCost record, @Param("example") EProductCostExample example);

    int updateByExample(@Param("record") EProductCost record, @Param("example") EProductCostExample example);

    int updateByPrimaryKeySelective(EProductCost record);

    int updateByPrimaryKey(EProductCost record);
    int updateByNumid(EProductCost record);
}