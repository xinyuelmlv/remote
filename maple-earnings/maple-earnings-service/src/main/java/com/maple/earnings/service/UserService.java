/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.EUser;

/**
 * TODO - High level description about type's responsibility.
 *
 */
public interface UserService {

	List<EUser> list();

	EUser load(String taobao_user_id);

	void register(EUser user);

	EasyUIDataGridResult list(int page, int rows);
	
	int updateExpreTime(long times);
	
	int updateByPrimaryKeySelective(EUser user);
	
	int updateByPrimaryKey(EUser user);
	
	void createOrder(String userId);
	
	void createTrade(String userId);
	
    void createOrderReport(String userId);
	    
	void createTradeHistory(String userId);
	//按照用户名查询用户信息
	EUser getUserByUserName(String taobao_user_nick);
	//根据用户编号将首次登录录入的用户信息存储到用户表中
	void updateUserInfo(EUser user);
}
