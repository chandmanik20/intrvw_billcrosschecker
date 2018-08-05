package com.models;

public class Orderdetail {
	Long orderid;
	float billamount;
		
	public Orderdetail() {
		super();
	}

	public Orderdetail(Long orderid, float billamount) {
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
