package com.reader;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.models.CmfoodchainType;
import com.reader.JSONFileReader;

import junit.framework.Assert;

public class JSONFileReaderTest {
	private JSONFileReader jsonFileReader;
	
	@Before
	public void setUp() throws Exception {
		jsonFileReader = new JSONFileReader();
	}

	@After
	public void tearDown() throws Exception {
		jsonFileReader = null;
	}

	@Test
	public void testReadFile() {
		JSONFileReader  fileReader = new JSONFileReader();
		CmfoodchainType cmfoodchainType = fileReader.readFile(new File("D:\\data\\input\\BOM-1234-457.json"));
		
		Assert.assertEquals(62.00f, cmfoodchainType.getOrders().get(0).getBillamount());
		
	}
	
	@Test
	public void testReadFileNoFile() {
		JSONFileReader  fileReader = new JSONFileReader();
		CmfoodchainType cmfoodchainType = fileReader.readFile(new File("D:\\data\\input\\BOM-1234-457.p"));
		Assert.assertNull(cmfoodchainType);
//		BOM-1234-457_corrupdata.json			
	}
	
	@Test
	public void testReadFileWithCorruptdata() {
		JSONFileReader  fileReader = new JSONFileReader();
		CmfoodchainType cmfoodchainType = fileReader.readFile(new File("D:\\data\\input\\BOM-1234-457_corrupdata.json"));
		Assert.assertNull(cmfoodchainType);
//					
	}
	
}
