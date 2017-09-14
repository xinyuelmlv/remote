package com.maple.earnings.mapper;

import com.maple.earnings.pojo.ETradeMiddle;
import com.maple.earnings.pojo.ETradeMiddleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ETradeMiddleMapper {
    int countByExample(ETradeMiddleExample example);

    int deleteByExample(ETradeMiddleExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(ETradeMiddle record);

    int insertSelective(ETradeMiddle record);

    List<ETradeMiddle> selectByExample(ETradeMiddleExample example);

    ETradeMiddle selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") ETradeMiddle record, @Param("example") ETradeMiddleExample example);

    int updateByExample(@Param("record") ETradeMiddle record, @Param("example") ETradeMiddleExample example);

    int updateByPrimaryKeySelective(ETradeMiddle record);

    int updateByPrimaryKey(ETradeMiddle record);
}