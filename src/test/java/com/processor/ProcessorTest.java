package com.processor;

import static org.junit.Assert.*;

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
		Branch branch = new Branch("Mumbai", 124.90f, "BOM-1234-456");
		Orderdetail order1 = new Orderdetail(1L, 60.43f);
		Orderdetail order2 = new Orderdetail(2L, 72.43f);
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		Branch branch11 = new Branch("Delhi", 35.35f, "DEL-1234-456");
		Orderdetail order11 = new Orderdetail(1L, 20.20f);
		Orderdetail order12 = new Orderdetail(2L, 15.15f);
		List<Orderdetail> orders12 = new ArrayList<Orderdetail>();
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
		Branch branch = new Branch("Mumbai", 124.90f, "BOM-1234-456");
		Orderdetail order1 = new Orderdetail(1L, 60.43f);
		Orderdetail order2 = new Orderdetail(2L, 72.43f);
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		Branch branch11 = new Branch("Delhi", 35.35f, "DEL-1234-456");
		Orderdetail order11 = new Orderdetail(1L, 20.20f);
		Orderdetail order12 = new Orderdetail(2L, 15.15f);
		List<Orderdetail> orders12 = new ArrayList<Orderdetail>();
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
		Branch branch = new Branch("Mumbai", 124.90f, "BOM-1234-456");
		Orderdetail order1 = new Orderdetail(1L, 60.43f);
		Orderdetail order2 = new Orderdetail(2L, 72.43f);
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		orders.add(order1);
		orders.add(order2);		
		CmfoodchainType cmfoodchainType = new CmfoodchainType(branch, orders);
		
		Branch branch11 = new Branch("Delhi", 35.35f, "DEL-1234-456");
		Orderdetail order11 = new Orderdetail(1L, 20.20f);
		Orderdetail order12 = new Orderdetail(2L, 15.15f);
		List<Orderdetail> orders12 = new ArrayList<Orderdetail>();
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
