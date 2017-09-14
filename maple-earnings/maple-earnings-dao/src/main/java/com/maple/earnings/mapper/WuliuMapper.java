package com.maple.earnings.mapper;

import com.maple.earnings.pojo.Wuliu;
import com.maple.earnings.pojo.WuliuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WuliuMapper {
    int countByExample(WuliuExample example);

    int deleteByExample(WuliuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wuliu record);

    int insertSelective(Wuliu record);

    List<Wuliu> selectByExample(WuliuExample example);

    Wuliu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wuliu record, @Param("example") WuliuExample example);

    int updateByExample(@Param("record") Wuliu record, @Param("example") WuliuExample example);

    int updateByPrimaryKeySelective(Wuliu record);

    int updateByPrimaryKey(Wuliu record);
}