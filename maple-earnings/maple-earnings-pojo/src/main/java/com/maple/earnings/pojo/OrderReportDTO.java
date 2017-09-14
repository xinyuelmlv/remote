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
public class OrderReportDTO {

	private Long id;

	private Double cost;

	private Integer num;

	private Double price;

	private String refundStatus;

	private String status;

	private String title;

	private Long numIid;

	private String tid;

	private Double productCost;

	private String created;

	private String endTime;

	private String modifiedTime;

	private String payTime;

	private ERefund eRefund;

	/**
	 * Get the value of or reference to created.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return this.created;
	}

	/**
	 * Assign the value of created to created.
	 *
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the value of or reference to endTime.
	 *
	 * @return the endTime
	 */
	public String getEndTime() {
		return this.endTime;
	}

	/**
	 * Assign the value of endTime to endTime.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Get the value of or reference to modifiedTime.
	 *
	 * @return the modifiedTime
	 */
	public String getModifiedTime() {
		return this.modifiedTime;
	}

	/**
	 * Assign the value of modifiedTime to modifiedTime.
	 *
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 * Get the value of or reference to payTime.
	 *
	 * @return the payTime
	 */
	public String getPayTime() {
		return this.payTime;
	}

	/**
	 * Assign the value of payTime to payTime.
	 *
	 * @param payTime the payTime to set
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public ERefund geteRefund() {
		return this.eRefund;
	}

	public void seteRefund(ERefund eRefund) {
		this.eRefund = eRefund;
	}

	/**
	 * Get the value of or reference to id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Assign the value of id to id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the value of or reference to cost.
	 *
	 * @return the cost
	 */
	public Double getCost() {
		return this.cost;
	}

	/**
	 * Assign the value of cost to cost.
	 *
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Get the value of or reference to num.
	 *
	 * @return the num
	 */
	public Integer getNum() {
		return this.num;
	}

	/**
	 * Assign the value of num to num.
	 *
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * Get the value of or reference to price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Assign the value of price to price.
	 *
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Get the value of or reference to refundStatus.
	 *
	 * @return the refundStatus
	 */
	public String getRefundStatus() {
		return this.refundStatus;
	}

	/**
	 * Assign the value of refundStatus to refundStatus.
	 *
	 * @param refundStatus the refundStatus to set
	 */
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
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
	 * Get the value of or reference to title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Assign the value of title to title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the value of or reference to numIid.
	 *
	 * @return the numIid
	 */
	public Long getNumIid() {
		return this.numIid;
	}

	/**
	 * Assign the value of numIid to numIid.
	 *
	 * @param numIid the numIid to set
	 */
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
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

}
