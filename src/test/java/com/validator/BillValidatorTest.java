package com.validator;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.models.CmfoodchainType;
import com.models.MatchModel;
import com.models.branchType;
import com.models.orderdetailType;
import com.validator.BillValidator;

import junit.framework.Assert;

public class BillValidatorTest {

	private BillValidator billValidator;
	
	@Before
	public void setUp() throws Exception {
		billValidator = new BillValidator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatchTrue() {
		branchType branch = new branchType("Mumbai", 124.90f, "BOM-1234-456");
		orderdetailType order1 = new orderdetailType(1L, 60.43f);
		orderdetailType order2 = new orderdetailType(2L, 72.43f);
		List<orderdetailType> orders = new ArrayList<orderdetailType>();
		orders.add(order1);
		orders.add(order2);
		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		MatchModel match = billValidator.match(cmfoodchainType);
		Assert.assertEquals(false, match.isMatched());
	}
	
	@Test
	public void testMatchFalse() {
		branchType branch = new branchType("Mumbai", 124.90f, "BOM-1234-456");
		orderdetailType order1 = new orderdetailType(1L, 60.90f);
		orderdetailType order2 = new orderdetailType(2L, 64.00f);
		List<orderdetailType> orders = new ArrayList<orderdetailType>();
		orders.add(order1);
		orders.add(order2);
		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		MatchModel match = billValidator.match(cmfoodchainType);
		Assert.assertEquals(true, match.isMatched());
	}

}
