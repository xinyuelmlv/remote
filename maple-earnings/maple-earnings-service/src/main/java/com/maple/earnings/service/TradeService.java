/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service;

import java.util.List;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.ETrade;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public interface TradeService {

	void saveOrUpdate(ETrade trade);

	ETrade load(String tid,String userId);

	/**
	 * TODO
	 *
	 * @param userId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGridResult listByPage(String userId,String timeType,String startTime,String endTime, int page, int rows);
	
	EasyUIDataGridResult getTradeDetail(String userId,String tid);
	
	List<ETrade> list(String userId);

	List<ETrade> listByPayTime(String userId, String payTime);

	List<ETrade> listByEndTime(String userId, String endTime);

	List<ETrade> listByModifiedTime(String userId, String modifiedTime);

}
