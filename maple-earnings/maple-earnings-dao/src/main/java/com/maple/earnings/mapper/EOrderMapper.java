package com.maple.earnings.mapper;

import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EOrderMapper {
    int countByExample(EOrderExample example);

    int deleteByExample(EOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EOrder record);

    int insertSelective(EOrder record);

    List<EOrder> selectByExample(EOrderExample example);
    
    List<EOrder> selectOrderAndRefundByExample(EOrderExample example);

    EOrder selectByPrimaryKey(@Param("id")Long id,@Param("userId")String userId);

    int updateByExampleSelective(@Param("record") EOrder record, @Param("example") EOrderExample example);

    int updateByExample(@Param("record") EOrder record, @Param("example") EOrderExample example);

    int updateByPrimaryKeySelective(EOrder record);

    int updateByPrimaryKey(EOrder record);
}