package com.models;

public class orderdetailType {
	Long orderid;
	float billamount;
		
	public orderdetailType() {
		super();
	}

	public orderdetailType(Long orderid, float billamount) {
		super();
		this.orderid = orderid;
		this.billamount = billamount;
	}
	
	public Long getOrderid() {
		return orderid;
	}
	
	public float getBillamount() {
		return billamount;
	}
}
