/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service;

import java.io.IOException;
import java.util.List;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.DayReport;
import com.maple.earnings.pojo.DifferenceReportDTO;
import com.maple.earnings.pojo.OrderReport;
import com.maple.earnings.pojo.OrderReportDTO;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public interface OrderReportService {

	public OrderReport load(String tid,String userId);

	public void saveOrUpdate(OrderReport orderReport);

	public EasyUIDataGridResult list(String userId, String startTime, String endTime, String orderStatus, int page,
			int rows);

	public List<Integer> tradeSum(String userId, String startTime, String endTime);// 交易状态概况

	public List<String> getReportDates(String userId);

	public EasyUIDataGridResult listByReportDate(String userId, String reportDate, int page, int rows);

	public List<DayReport> list(String userId);

	public List<OrderReportDTO> listOrderReportDTOByTid(String tid,String userId);

	public EasyUIDataGridResult listDiffrenceReport(String userId, String startTime, String endTime, String orderStatus,
			int page, int rows);

	public List<DifferenceReportDTO> findDiffrenceReport(String userId, String startTime, String endTime,
			String orderStatus);

	public byte[] exportDiffrenceReportDTO(List<DifferenceReportDTO> list) throws IOException;

}
