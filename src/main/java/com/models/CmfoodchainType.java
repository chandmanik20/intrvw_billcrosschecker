package com.models;

import java.util.List;

public class CmfoodchainType {
	private Branch branch;
	private List<Orderdetail> orders;
	
	public CmfoodchainType(Branch branch, List<Orderdetail> orders) {
		super();
		this.branch = branch;
		this.orders = orders;
	}

	public Branch getBranch() {
		return branch;
	}

	public List<Orderdetail> getOrders() {
		return orders;
	}
	
}
