package com.validator;

import java.util.List;

import com.models.CmfoodchainType;
import com.models.MatchModel;
import com.models.branchType;
import com.models.orderdetailType;

public class BillValidator implements Validator{
	
	/**
	 * this method will read individual bill, sum up and verify will given total. 
	 * if found mismatch it will add object to mismatch list.
	 */
	public MatchModel match(CmfoodchainType cmfoodchainType) {
		branchType branch = cmfoodchainType.getBranch();
		List<orderdetailType> orders = cmfoodchainType.getOrders();
		
		int count = orders == null ? 0 : orders.size();
		float totalBillAmount = 0;
		for (int i = 0; i < count; i++) {
			float billamount = orders.get(i).getBillamount();
			totalBillAmount += billamount;
		}
		
		int comp = Float.compare(branch.getTotalCollection(), totalBillAmount);
		MatchModel matchModel = new MatchModel(comp ==0, branch.getLocation(), branch.getTotalCollection(), totalBillAmount, branch.getLocationid());
		return matchModel;
	}
}