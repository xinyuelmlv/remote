/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.GlobalMap;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.ETradeMapper;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EProductCost;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.pojo.ETradeExample;
import com.maple.earnings.pojo.ETradeExample.Criteria;
import com.maple.earnings.pojo.OrderReport;
import com.maple.earnings.service.OrderReportService;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.ProductCostService;
import com.maple.earnings.service.TradeService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private ProductCostService productCostService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderReportService orderReportService;

	@Autowired
	private ETradeMapper tradeMapper;

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void saveOrUpdate(ETrade trade) {
		if (this.load(trade.getTid(),trade.getTaobao_user_id()) == null) {
			this.tradeMapper.insert(trade);
		} else {
			this.tradeMapper.updateByPrimaryKey(trade);
		}
		this.addOrderReport(trade);
	}

	/**
	 * TODO
	 *
	 * @param trade
	 */
	private void addOrderReport(ETrade trade) {
		OrderReport report = null;
		report = new OrderReport();
		report.setTotalFee(trade.getTotalFee());
		report.setTid(trade.getTid());
		String date=trade.getEndTime();
		String endTime="";
		if(date==null||date.equals("")){
			endTime="";
		}
		else{
			endTime=trade.getEndTime().substring(0, 10);
		}
		report.setReportDate(endTime);
		report.setStatus(GlobalMap.ORDER_STATUS.get(trade.getStatus()));
		List<EOrder> orders = this.orderService.listOrderAndRefund(trade.getTid(),trade.getUserId());
		double totalProductCosts = 0.0;
		double extraCost = 0.0;
		double refundfees = 0.0;
		for (EOrder order : orders) {
		//	double expense = order.getCost();
			int num = order.getNum();
			double refund = 0.0;
			// 如果退款状态不为空则获取退款金额
			if (order.getRefundStatus() != null && !order.getRefundStatus().equals("")) {
			//	refund = order.geteRefund().getRefundFee();
			}
		//	refundfees += refund;
			// 获取商品成本
		//	List<EProductCost> productCosts = this.productCostService.list(order.getNumIid());
		//	EProductCost productCost = productCosts.get(0);
			double cost =Double.parseDouble(trade.getPrice());
			// 订单中商品总成本
			totalProductCosts += (cost * num);
		//	extraCost += expense;
		}
		report.setExtraCost(extraCost);
		report.setRefundFee(refundfees);
		// 获取交易佣金
		report.setCommission(Double.parseDouble(trade.getPost_fee()));
		report.setProductCost(totalProductCosts);
		report.setUserId(trade.getUserId());
		report.setGain(report.getTotalFee() - extraCost - totalProductCosts - report.getCommission());
		// 实际到账(付款金额 -佣金 - 退款金额)
		report.setRealReceive(report.getTotalFee() - report.getCommission() - refundfees);
		this.orderReportService.saveOrUpdate(report);
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public EasyUIDataGridResult listByPage(String userId, String timeType, String startTime, String endTime, int page,
			int rows) {
		PageHelper.startPage(page, rows);
		List<ETrade> trades = new ArrayList<>();
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		example.setUserId(userId);
		criteria.andUserIdEqualTo(userId);
		if (timeType != null && !timeType.equals("")) {
			if (!startTime.equals("") && !endTime.equals("")) {
				if (timeType.equals("created")) {
					criteria.andCreatedBetween(startTime, endTime);
				}
				if (timeType.equals("payTime")) {
					criteria.andPayTimeBetween(startTime, endTime);
				}
				if (timeType.equals("modifiedTime")) {
					criteria.andModifiedTimeBetween(startTime, endTime);
				}
				if (timeType.equals("endTime")) {
					criteria.andEndTimeBetween(startTime, endTime);
				}
			}
		}
		trades = this.tradeMapper.selectByExample(example);
		for (ETrade eTrade : trades) {
			if (eTrade.getStatus().equals("WAIT_BUYER_PAY")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("WAIT_BUYER_PAY"));
			}
			if (eTrade.getStatus().equals("WAIT_SELLER_SEND_GOODS")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("WAIT_SELLER_SEND_GOODS"));
			}
			if (eTrade.getStatus().equals("SELLER_CONSIGNED_PART")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("SELLER_CONSIGNED_PART"));
			}
			if (eTrade.getStatus().equals("WAIT_BUYER_CONFIRM_GOODS")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("WAIT_BUYER_CONFIRM_GOODS"));
			}
			if (eTrade.getStatus().equals("TRADE_BUYER_SIGNED")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("TRADE_BUYER_SIGNED"));
			}
			if (eTrade.getStatus().equals("TRADE_FINISHED")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("TRADE_FINISHED"));
			}
			if (eTrade.getStatus().equals("TRADE_CLOSED")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("TRADE_CLOSED"));
			}
			if (eTrade.getStatus().equals("TRADE_CLOSED_BY_TAOBAO")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("TRADE_CLOSED_BY_TAOBAO"));
			}
			if (eTrade.getStatus().equals("TRADE_NO_CREATE_PAY")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("TRADE_NO_CREATE_PAY"));
			}
			if (eTrade.getStatus().equals("WAIT_PRE_AUTH_CONFIRM")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("WAIT_PRE_AUTH_CONFIRM"));
			}
			if (eTrade.getStatus().equals("PAY_PENDING")) {
				eTrade.setStatus(GlobalMap.ORDER_STATUS.get("PAY_PENDING"));
			}

		}
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<ETrade> pageInfo = new PageInfo<>(trades);
		results.setRows(trades);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public ETrade load(String tid,String userId) {
		return this.tradeMapper.selectByPrimaryKey(tid,userId);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */

	private List<ETrade> listByExample(ETradeExample example) {
		List<ETrade> trades = new ArrayList<>();
		trades = this.tradeMapper.selectByExample(example);
		return trades;
	}

	@Override
	public List<ETrade> list(String userId) {
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return this.listByExample(example);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<ETrade> listByPayTime(String userId, String payTime) {
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPayTimeLike("%" + payTime + "%");
		return this.listByExample(example);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<ETrade> listByEndTime(String userId, String endTime) {
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEndTimeLike("%" + endTime + "%");
		return this.listByExample(example);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<ETrade> listByModifiedTime(String userId, String modifiedTime) {
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andModifiedTimeLike("%" + modifiedTime + "%");
		return this.listByExample(example);
	}

	@Override
	public EasyUIDataGridResult getTradeDetail(String userId, String tid) {
		// TODO Auto-generated method stub
		List<ETrade> trades = new ArrayList<>();
		ETradeExample example = new ETradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		example.setUserId(userId);
		if (tid != "111111") {
			criteria.andTidEqualTo(tid);
		}
		trades = this.tradeMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<ETrade> pageInfo = new PageInfo<>(trades);
		results.setRows(trades);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
