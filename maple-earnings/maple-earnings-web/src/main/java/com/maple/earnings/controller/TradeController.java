/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.service.IncomHistoryService;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.TradeService;
import com.maple.earnings.service.WuliuService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Controller
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private IncomHistoryService incomHistoryService;
    @Autowired
    private WuliuService wuliuService;
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getTradeList(String userId,String timeType,String startTime,String endTime, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.tradeService.listByPage(userId,timeType,startTime,endTime, page, rows);
		return result;
	}
	@RequestMapping("/incomHistiry")
	@ResponseBody
	public EasyUIDataGridResult incomHistiry(String userId,String startTime,String endTime, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.incomHistoryService.list(userId, startTime, endTime, page, rows);
		return result;
	}
	// 根据用户编号获取交易超时信息
	@RequestMapping("/tradeTimeOut")
	@ResponseBody
	public EasyUIDataGridResult tradeTimeOut(String userId, Integer page, Integer rows) {
		EasyUIDataGridResult result =this.wuliuService.listWuliu(userId, page, rows);
		return result;
	}
	@RequestMapping("/getHistory")
	@ResponseBody
	public EasyUIDataGridResult getHistory(HttpServletRequest req, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.incomHistoryService.selectByTid(req.getParameter("userId"), req.getParameter("tid"), page, rows);
		return result;
	}
	@RequestMapping("/tradeDetail")
	@ResponseBody
	public EasyUIDataGridResult getTradeDetail(String userId,String tid) {
		EasyUIDataGridResult result = this.tradeService.getTradeDetail(userId,tid);
		return result;
	}

	@RequestMapping("/order")
	@ResponseBody
	public EasyUIDataGridResult getOrderList(String tid, Integer page, Integer rows,HttpServletRequest req) {
		HttpSession session=req.getSession();
		String userId=session.getAttribute("userId").toString();
		EasyUIDataGridResult result = this.orderService.list(tid, userId,page, rows);
		return result;
	}

	@RequestMapping("/orderList")
	@ResponseBody
	public List<EOrder> getOrders(String tid,HttpServletRequest req) {
		HttpSession session=req.getSession();
		String userId=session.getAttribute("userId").toString();
		List<EOrder> result = this.orderService.list(tid,userId);
		return result;
	}

//	@RequestMapping("/update")
//	@ResponseBody
//	public int addProductCost(HttpServletRequest request) {
//		int result = 0;
//		Long id = Long.parseLong(request.getParameter("id"));
//		Long tid = Long.parseLong(request.getParameter("tid"));
//		Double cost = Double.parseDouble(request.getParameter("cost"));
//		EOrder oderexp = new EOrder();
//		oderexp.setCost(cost);
//		oderexp.setId(id);
//		oderexp.setTid(tid);
//		try {
//			this.orderService.updateByKey(oderexp);
//			result = 1;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return result;
//	}

}
