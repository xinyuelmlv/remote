package com.maple.earnings.pojo;

public class TradeHistory {
	private Integer id;

	private String tid;

	private String changetime;

	private Double realpayment;

	private Double postfee;

	private Double shuoldpayment;
	
	private String title;
	
	private String status;

	private String userId;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getChangetime() {
		return changetime;
	}

	public void setChangetime(String changetime) {
		this.changetime = changetime == null ? null : changetime.trim();
	}

	public Double getRealpayment() {
		return realpayment;
	}

	public void setRealpayment(Double realpayment) {
		this.realpayment = realpayment;
	}

	public Double getPostfee() {
		return postfee;
	}

	public void setPostfee(Double postfee) {
		this.postfee = postfee;
	}

	public Double getShuoldpayment() {
		return shuoldpayment;
	}

	public void setShuoldpayment(Double shuoldpayment) {
		this.shuoldpayment = shuoldpayment;
	}
}