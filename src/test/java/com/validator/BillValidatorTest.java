package com.validator;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.models.CmfoodchainType;
import com.models.MatchModel;
import com.models.Branch;
import com.models.Orderdetail;
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
		Branch branch = new Branch("Mumbai", 124.90f, "BOM-1234-456");
		Orderdetail order1 = new Orderdetail(1L, 60.43f);
		Orderdetail order2 = new Orderdetail(2L, 72.43f);
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		orders.add(order1);
		orders.add(order2);
		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		MatchModel match = billValidator.match(cmfoodchainType);
		Assert.assertEquals(false, match.isMatched());
	}
	
	@Test
	public void testMatchFalse() {
		Branch branch = new Branch("Mumbai", 124.90f, "BOM-1234-456");
		Orderdetail order1 = new Orderdetail(1L, 60.90f);
		Orderdetail order2 = new Orderdetail(2L, 64.00f);
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		orders.add(order1);
		orders.add(order2);
		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		MatchModel match = billValidator.match(cmfoodchainType);
		Assert.assertEquals(true, match.isMatched());
	}

}
