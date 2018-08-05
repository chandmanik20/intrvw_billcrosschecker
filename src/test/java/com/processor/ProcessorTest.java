package com.processor;

import static org.junit.Assert.*;

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

public class ProcessorTest {
	private Processor processor = null;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcess() {
		branchType branch = new branchType("Mumbai", 124.90f, "BOM-1234-456");
		orderdetailType order1 = new orderdetailType(1L, 60.43f);
		orderdetailType order2 = new orderdetailType(2L, 72.43f);
		List<orderdetailType> orders = new ArrayList<orderdetailType>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		branchType branch11 = new branchType("Delhi", 35.35f, "DEL-1234-456");
		orderdetailType order11 = new orderdetailType(1L, 20.20f);
		orderdetailType order12 = new orderdetailType(2L, 15.15f);
		List<orderdetailType> orders12 = new ArrayList<orderdetailType>();
		orders12.add(order11);
		orders12.add(order12);		
		CmfoodchainType cmfoodchainType12 = new CmfoodchainType(branch11, orders12);
		
		ArrayList<CmfoodchainType> cmfoodchainTypes = new ArrayList<CmfoodchainType>();
		cmfoodchainTypes.add(cmfoodchainType);
		cmfoodchainTypes.add(cmfoodchainType12);
		
		processor = new Processor(cmfoodchainTypes, new BillValidator());
		
		processor.process();
		List<MatchModel> matchModels = processor.getMatchModels();
		List<MatchModel> mismatchModels = processor.getMismatchModels();
		
		Assert.assertEquals(1, matchModels.size());
		Assert.assertEquals(1, mismatchModels.size());		
	}

	@Test
	public void testGetMatchModels() {
		branchType branch = new branchType("Mumbai", 124.90f, "BOM-1234-456");
		orderdetailType order1 = new orderdetailType(1L, 60.43f);
		orderdetailType order2 = new orderdetailType(2L, 72.43f);
		List<orderdetailType> orders = new ArrayList<orderdetailType>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		branchType branch11 = new branchType("Delhi", 35.35f, "DEL-1234-456");
		orderdetailType order11 = new orderdetailType(1L, 20.20f);
		orderdetailType order12 = new orderdetailType(2L, 15.15f);
		List<orderdetailType> orders12 = new ArrayList<orderdetailType>();
		orders12.add(order11);
		orders12.add(order12);		
		CmfoodchainType cmfoodchainType12 = new CmfoodchainType(branch11, orders12);
		
		ArrayList<CmfoodchainType> cmfoodchainTypes = new ArrayList<CmfoodchainType>();
		cmfoodchainTypes.add(cmfoodchainType);
		cmfoodchainTypes.add(cmfoodchainType12);
		
		processor = new Processor(cmfoodchainTypes, new BillValidator());
		
		processor.process();
		List<MatchModel> matchModels = processor.getMatchModels();
		
		Assert.assertEquals(1, matchModels.size());
		
	}

	@Test
	public void testGetMismatchModels() {
		branchType branch = new branchType("Mumbai", 124.90f, "BOM-1234-456");
		orderdetailType order1 = new orderdetailType(1L, 60.43f);
		orderdetailType order2 = new orderdetailType(2L, 72.43f);
		List<orderdetailType> orders = new ArrayList<orderdetailType>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		branchType branch11 = new branchType("Delhi", 35.35f, "DEL-1234-456");
		orderdetailType order11 = new orderdetailType(1L, 20.20f);
		orderdetailType order12 = new orderdetailType(2L, 15.15f);
		List<orderdetailType> orders12 = new ArrayList<orderdetailType>();
		orders12.add(order11);
		orders12.add(order12);		
		CmfoodchainType cmfoodchainType12 = new CmfoodchainType(branch11, orders12);
		
		ArrayList<CmfoodchainType> cmfoodchainTypes = new ArrayList<CmfoodchainType>();
		cmfoodchainTypes.add(cmfoodchainType);
		cmfoodchainTypes.add(cmfoodchainType12);
		
		processor = new Processor(cmfoodchainTypes, new BillValidator());
		
		processor.process();
		List<MatchModel> mismatchModels = processor.getMismatchModels();

		Assert.assertEquals(1, mismatchModels.size());	
	}

}
