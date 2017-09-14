package com.maple.earnings.pojo;

import java.util.Set;


public class ETrade {

	private int id;

	private String tid;

	private String created;

	private String endTime;

	private String modifiedTime;

	private String payTime;

	private String status;

	private Double totalFee;
	 private String post_fee;
	    private String price;
	    private String received_payment;
	    

	public String getPost_fee() {
			return post_fee;
		}

		public void setPost_fee(String post_fee) {
			this.post_fee = post_fee;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getReceived_payment() {
			return received_payment;
		}

		public void setReceived_payment(String received_payment) {
			this.received_payment = received_payment;
		}

		public String getTaobao_user_id() {
			return taobao_user_id;
		}

		public void setTaobao_user_id(String taobao_user_id) {
			this.taobao_user_id = taobao_user_id;
		}

	private String taobao_user_id;

	private Set<EOrder> orders;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created == null ? null : created.trim();
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime == null ? null : endTime.trim();
	}

	public String getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
	}

	public String getPayTime() {
		return this.payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime == null ? null : payTime.trim();
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Double getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getUserId() {
		return this.taobao_user_id;
	}

	public void setUserId(String taobao_user_id) {
		this.taobao_user_id = taobao_user_id;
	}

	/**
	 * Get the value of or reference to orders.
	 *
	 * @return the orders
	 */
	public Set<EOrder> getOrders() {
		return this.orders;
	}

	/**
	 * Assign the value of orders to orders.
	 *
	 * @param orders the orders to set
	 */
	public void setOrders(Set<EOrder> orders) {
		this.orders = orders;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public String toString() {
		return "ETrade [tid=" + this.tid + ", created=" + this.created + ", endTime=" + this.endTime + ", modifiedTime="
				+ this.modifiedTime + ", payTime=" + this.payTime + ", status=" + this.status + ", totalFee=" + this.totalFee
				+ ", taobao_user_id=" + this.taobao_user_id + ", orders=" + this.orders + "]";
	}

}
