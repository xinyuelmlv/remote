/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.DayReport;
import com.maple.earnings.pojo.DifferenceReportDTO;
import com.maple.earnings.pojo.OrderReportDTO;
import com.maple.earnings.service.OrderReportService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Controller
@RequestMapping("/report")
public class OrderReportController {

	@Autowired
	private OrderReportService orderReportService;

	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getOrderReportList(String userId, String startTime, String endTime, String orderStatus,
			Integer page, Integer rows) {
		EasyUIDataGridResult result = this.orderReportService.list(userId, startTime, endTime, orderStatus, page, rows);
		return result;
	}
	

	@RequestMapping("/SumTrade")
	@ResponseBody
	public List<Integer> SumTrade(String userId, String startTime, String endTime) {
		List<Integer> result = this.orderReportService.tradeSum(userId, startTime, endTime);
		return result;
	}

	@RequestMapping("/reportList")
	@ResponseBody
	public EasyUIDataGridResult getReportList(String userId, String date, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.orderReportService.listByReportDate(userId, date, page, rows);
		return result;
	}

	@RequestMapping("/diffrenceReportList")
	@ResponseBody
	public EasyUIDataGridResult getDiffrenceReportList(String userId, String startTime, String endTime,
			String orderStatus, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.orderReportService.listDiffrenceReport(userId, startTime, endTime,
				orderStatus, page, rows);
		return result;
	}

	@RequestMapping("/dayReportList")
	@ResponseBody
	public List<DayReport> getDayReports(String userId) {
		List<DayReport> dayReports = this.orderReportService.list(userId);
		return dayReports;
	}

	@RequestMapping("/reportDetail")
	@ResponseBody
	public List<OrderReportDTO> getReportsDetail(String tid,String userId) {
		List<OrderReportDTO> result = this.orderReportService.listOrderReportDTOByTid(tid,userId);
		return result;
	}

	@RequestMapping("/diffrenceReportListExport")
	public void getDiffrenceReportListExport(String userId, String startTime, String endTime, String orderStatus,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<DifferenceReportDTO> differenceReportDTOs = this.orderReportService.findDiffrenceReport(userId,
					startTime, endTime, orderStatus);
			byte[] fileNameByte = ("report.xls").getBytes("UTF-8");
			String filename = new String(fileNameByte, "UTF-8");

			byte[] bytes = this.orderReportService.exportDiffrenceReportDTO(differenceReportDTOs);
			// logger.info("------------------------"+bytes.length);
			response.setContentType("application/x-msdownload");
			// response.setContentType("application/x-excel");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			response.getOutputStream().write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
