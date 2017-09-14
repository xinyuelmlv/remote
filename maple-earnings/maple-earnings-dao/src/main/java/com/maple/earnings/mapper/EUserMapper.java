package com.maple.earnings.mapper;

import com.maple.earnings.pojo.EUser;
import com.maple.earnings.pojo.EUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EUserMapper {
    int countByExample(EUserExample example);

    int deleteByExample(EUserExample example);

    int deleteByPrimaryKey(String taobao_user_id);

    int insert(EUser record);

    int insertSelective(EUser record);

    List<EUser> selectByExample(EUserExample example);

    EUser selectByPrimaryKey(@Param("taobao_user_id")String taobao_user_id);
    
    EUser selectByUserName(@Param("taobao_user_nick")String taobao_user_nick);

    int updateByExampleSelective(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByExample(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByPrimaryKeySelective(EUser record);

    int updateByPrimaryKey(EUser record);
    
    void updateUserInfo(EUser record);
    
    int updateExpreTime(long times);
    
    void createOrder(@Param("userId")String userId);
    
    void createTrade(@Param("userId")String userId);
    
    void createOrderReport(@Param("userId")String userId);
    
    void createTradeHistory(@Param("userId")String userId);
}