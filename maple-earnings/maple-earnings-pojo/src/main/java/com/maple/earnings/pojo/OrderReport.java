package com.maple.earnings.pojo;

public class OrderReport {

	private String tid;

	private Double productCost;

	private Double refundFee;

	private Double extraCost;

	private Double totalFee;

	private Double gain;

	private Double commission;

	private Double realReceive;

	private String reportDate;

	private String status;

	private String userId;

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

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Double getProductCost() {
		return this.productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	public Double getExtraCost() {
		return this.extraCost;
	}

	public void setExtraCost(Double extraCost) {
		this.extraCost = extraCost;
	}

	public Double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public Double getGain() {
		return this.gain;
	}

	public void setGain(Double gain) {
		this.gain = gain;
	}

	public String getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate == null ? null : reportDate.trim();
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
