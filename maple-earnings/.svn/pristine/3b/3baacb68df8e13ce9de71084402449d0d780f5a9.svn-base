package com.maple.earnings.mapper;

import com.maple.earnings.pojo.ManagerUser;
import com.maple.earnings.pojo.ManagerUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerUserMapper {
    int countByExample(ManagerUserExample example);

    int deleteByExample(ManagerUserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(ManagerUser record);

    int insertSelective(ManagerUser record);

    List<ManagerUser> selectByExample(ManagerUserExample example);

    ManagerUser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByExample(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByPrimaryKeySelective(ManagerUser record);

    int updateByPrimaryKey(ManagerUser record);
}