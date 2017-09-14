package com.maple.earnings.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.pojo.ETradeExample;

public interface ETradeMapper {
	int countByExample(ETradeExample example);

	int deleteByExample(ETradeExample example);

	int deleteByPrimaryKey(Long tid);

	int insert(ETrade record);

	int insertSelective(ETrade record);

	List<ETrade> selectByExample(ETradeExample example);

	List<Integer> getTradeSum(ETradeExample example);

	ETrade selectByPrimaryKey(@Param("tid")String tid,@Param("userId")String userId);

	int updateByExampleSelective(@Param("record") ETrade record, @Param("example") ETradeExample example);

	int updateByExample(@Param("record") ETrade record, @Param("example") ETradeExample example);

	int updateByPrimaryKeySelective(ETrade record);

	int updateByPrimaryKey(ETrade record);
}