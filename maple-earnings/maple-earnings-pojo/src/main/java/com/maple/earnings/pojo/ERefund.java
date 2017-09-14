package com.maple.earnings.pojo;

public class ERefund {
    private Long refundId;

    private Long alipayNo;

    private String created;

    private String orderStatus;

    private String status;

    private String goodStatus;

    private Long refundFee;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(Long alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus == null ? null : goodStatus.trim();
    }

    public Long getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
    }
}