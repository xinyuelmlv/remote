package com.maple.earnings.mapper;

import com.maple.earnings.pojo.TradeHistory;
import com.maple.earnings.pojo.TradeHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeHistoryMapper {
    int countByExample(TradeHistoryExample example);

    int deleteByExample(TradeHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeHistory record);

    int insertSelective(TradeHistory record);

    List<TradeHistory> selectByExample(TradeHistoryExample example);
    
    List<TradeHistory> selectByTid(@Param("tid") String tid,@Param("userId")String userId);
    
    String selectMaxRealPay (@Param("tid") String tid,@Param("userId")String userId);
    
    TradeHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeHistory record, @Param("example") TradeHistoryExample example);

    int updateByExample(@Param("record") TradeHistory record, @Param("example") TradeHistoryExample example);

    int updateByPrimaryKeySelective(TradeHistory record);

    int updateByPrimaryKey(TradeHistory record);
}
