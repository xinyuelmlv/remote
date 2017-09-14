package com.maple.earnings.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maple.earnings.pojo.DayReport;
import com.maple.earnings.pojo.OrderReport;
import com.maple.earnings.pojo.OrderReportExample;

public interface OrderReportMapper {

	int countByExample(OrderReportExample example);

	int deleteByExample(OrderReportExample example);

	int deleteByPrimaryKey(Long tid);

	int insert(OrderReport record);

	int insertSelective(OrderReport record);

	List<OrderReport> selectByExample(OrderReportExample example);

	OrderReport selectByPrimaryKey(@Param("tid")String tid,@Param("userId")String userId);

	int updateByExampleSelective(@Param("record") OrderReport record, @Param("example") OrderReportExample example);

	int updateByExample(@Param("record") OrderReport record, @Param("example") OrderReportExample example);

	int updateByPrimaryKeySelective(OrderReport record);

	int updateByPrimaryKey(OrderReport record);

	List<String> selectReportDates(@Param("userId")String userId);

	List<DayReport> selectDayReportDates(@Param("userId")String userId);
}
