package com.maple.earnings.service;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.TradeHistory;

public interface IncomHistoryService {
	public EasyUIDataGridResult list(String userId, String startTime, String endTime, int page,
			int rows);
	public void insert(TradeHistory tradeHistory);
	public EasyUIDataGridResult selectByTid(String userId, String tid, int page,int rows);
	public String selectMaxRealPay (String tid,String userId);

}
