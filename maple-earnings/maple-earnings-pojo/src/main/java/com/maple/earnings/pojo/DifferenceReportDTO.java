/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.pojo;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class DifferenceReportDTO {

	private String tid;

	private String userId;

	private Double productCost;

	private Double refundFee;

	private Double totalFee;

	private Double gain;

	private Double commission;

	private Double realReceive;

	private Double realExpenditure;

	private String reportDate;

	private String status;

	/**
	 * Get the value of or reference to realExpenditure.
	 *
	 * @return the realExpenditure
	 */
	public Double getRealExpenditure() {
		return this.realExpenditure;
	}

	/**
	 * Assign the value of realExpenditure to realExpenditure.
	 *
	 * @param realExpenditure the realExpenditure to set
	 */
	public void setRealExpenditure(Double realExpenditure) {
		this.realExpenditure = realExpenditure;
	}

	/**
	 * Get the value of or reference to tid.
	 *
	 * @return the tid
	 */
	public String getTid() {
		return this.tid;
	}

	/**
	 * Assign the value of tid to tid.
	 *
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * Get the value of or reference to productCost.
	 *
	 * @return the productCost
	 */
	public Double getProductCost() {
		return this.productCost;
	}

	/**
	 * Assign the value of productCost to productCost.
	 *
	 * @param productCost the productCost to set
	 */
	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	/**
	 * Get the value of or reference to refundFee.
	 *
	 * @return the refundFee
	 */
	public Double getRefundFee() {
		return this.refundFee;
	}

	/**
	 * Assign the value of refundFee to refundFee.
	 *
	 * @param refundFee the refundFee to set
	 */
	public void setRefundFee(Double refundFee) {
		this.refundFee = refundFee;
	}

	/**
	 * Get the value of or reference to totalFee.
	 *
	 * @return the totalFee
	 */
	public Double getTotalFee() {
		return this.totalFee;
	}

	/**
	 * Assign the value of totalFee to totalFee.
	 *
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * Get the value of or reference to gain.
	 *
	 * @return the gain
	 */
	public Double getGain() {
		return this.gain;
	}

	/**
	 * Assign the value of gain to gain.
	 *
	 * @param gain the gain to set
	 */
	public void setGain(Double gain) {
		this.gain = gain;
	}

	/**
	 * Get the value of or reference to commission.
	 *
	 * @return the commission
	 */
	public Double getCommission() {
		return this.commission;
	}

	/**
	 * Assign the value of commission to commission.
	 *
	 * @param commission the commission to set
	 */
	public void setCommission(Double commission) {
		this.commission = commission;
	}

	/**
	 * Get the value of or reference to realReceive.
	 *
	 * @return the realReceive
	 */
	public Double getRealReceive() {
		return this.realReceive;
	}

	/**
	 * Assign the value of realReceive to realReceive.
	 *
	 * @param realReceive the realReceive to set
	 */
	public void setRealReceive(Double realReceive) {
		this.realReceive = realReceive;
	}

	/**
	 * Get the value of or reference to reportDate.
	 *
	 * @return the reportDate
	 */
	public String getReportDate() {
		return this.reportDate;
	}

	/**
	 * Assign the value of reportDate to reportDate.
	 *
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * Get the value of or reference to status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Assign the value of status to status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the value of or reference to userId.
	 *
	 * @return the userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Assign the value of userId to userId.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
