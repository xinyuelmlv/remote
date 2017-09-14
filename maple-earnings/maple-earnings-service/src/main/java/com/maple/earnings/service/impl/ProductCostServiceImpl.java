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

import com.maple.earnings.mapper.EProductCostMapper;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EProductCost;
import com.maple.earnings.pojo.EProductCostExample;
import com.maple.earnings.pojo.EProductCostExample.Criteria;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.service.OrderService;
import com.maple.earnings.service.ProductCostService;
import com.maple.earnings.service.TradeService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service
public class ProductCostServiceImpl implements ProductCostService {

	@Autowired
	private OrderService orderService;

	@Autowired
	private EProductCostMapper productCostMapper;

	@Autowired
	private TradeService tradeService;

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public EProductCost load(long id) {
		return this.productCostMapper.selectByPrimaryKey(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<EProductCost> list(long numIid) {
		List<EProductCost> productCosts = new ArrayList<>();
		EProductCostExample example = new EProductCostExample();
		Criteria criteria = example.createCriteria();
		criteria.andNumIidEqualTo(numIid);
		productCosts = this.productCostMapper.selectByExample(example);
		return productCosts;
	}

	@Override
	public void update(EProductCostExample ProductCostexample, EProductCost eproductCost) {
		// TODO Auto-generated method stub
		this.productCostMapper.updateByExampleSelective(eproductCost, ProductCostexample);

	}

	@Override
	public void add(long numIid, EProductCost productCost) {
//		// TODO Auto-generated method stub
//		this.productCostMapper.insert(productCost);
//		List<EOrder> orders = this.orderService.listByNumIid(productCost.getNumIid());
//		for (EOrder order : orders) {
//			ETrade trade = this.tradeService.load(order.getTid());
//			this.tradeService.saveOrUpdate(trade);
//		}

	}

	@Override
	public void updateByNumid(EProductCost record) {
//		// TODO Auto-generated method stub
//		this.productCostMapper.updateByNumid(record);
//		List<EOrder> orders = this.orderService.listByNumIid(record.getNumIid());
//		for (EOrder order : orders) {
//			ETrade trade = this.tradeService.load(order.getTid());
//			this.tradeService.saveOrUpdate(trade);
//		}

	}

}
