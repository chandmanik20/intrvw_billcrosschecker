package com.models;

import java.util.List;

public class CmfoodchainType {
	private branchType branch;
	private List<orderdetailType> orders;
	
	public CmfoodchainType(branchType branch, List<orderdetailType> orders) {
		super();
		this.branch = branch;
		this.orders = orders;
	}

	public branchType getBranch() {
		return branch;
	}

	public List<orderdetailType> getOrders() {
		return orders;
	}
	
}
