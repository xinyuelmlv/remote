package com.maple.earnings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.TradeHistoryMapper;
import com.maple.earnings.pojo.TradeHistory;
import com.maple.earnings.pojo.TradeHistoryExample;
import com.maple.earnings.pojo.TradeHistoryExample.Criteria;
import com.maple.earnings.service.IncomHistoryService;

import java.util.ArrayList;
import java.util.List;
@Service
public class IncomHistoryServiceImpl implements IncomHistoryService {
	@Autowired
	private TradeHistoryMapper tradeHistoryMapper;
	@Override
	public EasyUIDataGridResult list(String userId, String startTime, String endTime, int page,
			int rows) {
		PageHelper.startPage(page, rows);
		List <TradeHistory> incomHistorys=new ArrayList<>();
		TradeHistoryExample example=new TradeHistoryExample();
		example.setUserId(userId);
		Criteria criteria = example.createCriteria();
		if (startTime != null && !startTime.equals("") && endTime != null && !endTime.equals("")) {
			criteria.andChangetimeBetween(startTime, endTime);
		}
		incomHistorys=this.tradeHistoryMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<TradeHistory> pageInfo = new PageInfo<>(incomHistorys);
		results.setRows(incomHistorys);
		results.setTotal(pageInfo.getTotal());
		return results;
	}
	@Override
	public void insert(TradeHistory tradeHistory) {
		this.tradeHistoryMapper.insert(tradeHistory);
	}
	@Override
	public EasyUIDataGridResult selectByTid(String userId, String tid, int page, int rows) {
		PageHelper.startPage(page, rows);
		List <TradeHistory> incomHistorys=new ArrayList<>();
		incomHistorys=this.tradeHistoryMapper.selectByTid(tid, userId);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<TradeHistory> pageInfo = new PageInfo<>(incomHistorys);
		results.setRows(incomHistorys);
		results.setTotal(pageInfo.getTotal());
		return results;
	}
	@Override
	public String selectMaxRealPay(String tid, String userId) {
		String realPay=this.tradeHistoryMapper.selectMaxRealPay(tid, userId);
		return realPay;
	}

}
