package com.maple.earnings.pojo;

public class EProduct {
    private Long numIid;

    private String apprroveStatus;

    private String modified;

    private int num;

    private Double price;

    private String title;

    private String uId;
    
    //与ProductCost实现实体关联
    private EProductCost eProductCost;
    

    public EProductCost geteProductCost() {
		return eProductCost;
	}

	public void seteProductCost(EProductCost eProductCost) {
		this.eProductCost = eProductCost;
	}

	public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getApprroveStatus() {
        return apprroveStatus;
    }

    public void setApprroveStatus(String apprroveStatus) {
        this.apprroveStatus = apprroveStatus == null ? null : apprroveStatus.trim();
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified == null ? null : modified.trim();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}