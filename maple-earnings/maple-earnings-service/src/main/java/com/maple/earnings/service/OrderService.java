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
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.ERefund;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public interface OrderService {

	public void add(String tid, EOrder order);

	public void addRefund(ERefund refund);

	public List<EOrder> list(String tid,String userId);

	public List<EOrder> listOrderAndRefund(String tid ,String userId);

	public EasyUIDataGridResult list(String tid,String userId, int page, int rows);

	public EasyUIDataGridResult listOrderAndRefund(String tid,String userId, int page, int rows);

	public void updateByKey(EOrder record,String userId);

	public List<EOrder> listByNumIid(long numIid);
	public EOrder listById(long id,String userId);

}
