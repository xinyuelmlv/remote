package com.maple.earnings.pojo;

import java.util.List;

public class TradeInfoBean {

    private OrdersBean orders;
    private String payment="";
    private String status="";
    private String tid;
    private String type;
    private String created="";
    private String pay_time="";
    private String modified="";
    private String end_time="";
    private String total_fee;
    private String post_fee;
    private String price;
    private String received_payment;
    private String title;
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getPay_time() {
		return pay_time;
	}

	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public OrdersBean getOrders() {
        return orders;
    }

    public void setOrders(OrdersBean orders) {
        this.orders = orders;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class OrdersBean {
        private List<OrderBean> order;

        public List<OrderBean> getOrder() {
            return order;
        }

        public void setOrder(List<OrderBean> order) {
            this.order = order;
        }

        public static class OrderBean {
         

            private String adjust_fee;
            private boolean buyer_rate;
            private int cid;
            private String discount_fee;
            private String end_time;
            private boolean is_daixiao;
            private int num;
            private long num_iid;
            private long oid;
            private String payment;
            private String pic_path;
            private String price;
            private String refund_status;
            private boolean seller_rate;
            private String seller_type;
            private String status;
            private String title;
            private String total_fee;

            public String getAdjust_fee() {
                return adjust_fee;
            }

            public void setAdjust_fee(String adjust_fee) {
                this.adjust_fee = adjust_fee;
            }

            public boolean isBuyer_rate() {
                return buyer_rate;
            }

            public void setBuyer_rate(boolean buyer_rate) {
                this.buyer_rate = buyer_rate;
            }

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getDiscount_fee() {
                return discount_fee;
            }

            public void setDiscount_fee(String discount_fee) {
                this.discount_fee = discount_fee;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public boolean isIs_daixiao() {
                return is_daixiao;
            }

            public void setIs_daixiao(boolean is_daixiao) {
                this.is_daixiao = is_daixiao;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public long getNum_iid() {
                return num_iid;
            }

            public void setNum_iid(long num_iid) {
                this.num_iid = num_iid;
            }

            public long getOid() {
                return oid;
            }

            public void setOid(long oid) {
                this.oid = oid;
            }

            public String getPayment() {
                return payment;
            }

            public void setPayment(String payment) {
                this.payment = payment;
            }

            public String getPic_path() {
                return pic_path;
            }

            public void setPic_path(String pic_path) {
                this.pic_path = pic_path;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getRefund_status() {
                return refund_status;
            }

            public void setRefund_status(String refund_status) {
                this.refund_status = refund_status;
            }

            public boolean isSeller_rate() {
                return seller_rate;
            }

            public void setSeller_rate(boolean seller_rate) {
                this.seller_rate = seller_rate;
            }

            public String getSeller_type() {
                return seller_type;
            }

            public void setSeller_type(String seller_type) {
                this.seller_type = seller_type;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(String total_fee) {
                this.total_fee = total_fee;
            }
        }
    }
}
