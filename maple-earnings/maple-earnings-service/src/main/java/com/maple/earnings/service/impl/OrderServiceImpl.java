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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.EOrderMapper;
import com.maple.earnings.mapper.ERefundMapper;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EOrderExample;
import com.maple.earnings.pojo.EOrderExample.Criteria;
import com.maple.earnings.pojo.ERefund;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.TradeService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private EOrderMapper orderMapper;

	@Autowired
	private ERefundMapper refundMapper;

	@Autowired
	private TradeService tradeService;

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void add(String tid, EOrder order) {
		this.orderMapper.insert(order);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<EOrder> list(String tid,String userId) {
		List<EOrder> orders = new ArrayList<>();
		EOrderExample example = new EOrderExample();
	    example.setUserId(userId);
		Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(tid);
		orders = this.orderMapper.selectByExample(example);
		return orders;
	}

	public EasyUIDataGridResult list(String tid,String userId, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<EOrder> orders = new ArrayList<>();
		EOrderExample example = new EOrderExample();
		example.setUserId(userId);
		Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(tid);
		orders = this.orderMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<EOrder> pageInfo = new PageInfo<>(orders);
		results.setRows(orders);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<EOrder> listByNumIid(long numIid) {
		List<EOrder> orders = new ArrayList<>();
		EOrderExample example = new EOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andNumIidEqualTo(numIid);
		orders = this.orderMapper.selectByExample(example);
		return orders;
	}

	// ------- Constants (static final) ----------------------------------------

	@Override
	public void updateByKey(EOrder record,String userId) {
		// TODO Auto-generated method stub
		this.orderMapper.updateByPrimaryKey(record);
		ETrade trade = this.tradeService.load(record.getTid(),userId);
		this.tradeService.saveOrUpdate(trade);
	}

	@Override
	public EasyUIDataGridResult listOrderAndRefund(String  tid,String userId, int page, int rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<EOrder> orders = new ArrayList<>();
		EOrderExample example = new EOrderExample();
		example.setUserId(userId);
		Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(tid);
		orders = this.orderMapper.selectOrderAndRefundByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<EOrder> pageInfo = new PageInfo<>(orders);
		results.setRows(orders);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	@Override
	public List<EOrder> listOrderAndRefund(String tid,String userId) {
		// TODO Auto-generated method stub
		List<EOrder> orders = new ArrayList<>();
		EOrderExample example = new EOrderExample();
		example.setUserId(userId);
		Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(tid);
		orders = this.orderMapper.selectOrderAndRefundByExample(example);
		return orders;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void addRefund(ERefund refund) {
		this.refundMapper.insert(refund);
	}

	@Override
	public EOrder listById(long id ,String userId) {
		EOrder order=new EOrder();
		order = this.orderMapper.selectByPrimaryKey(id,userId);
		return order;
	}

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
