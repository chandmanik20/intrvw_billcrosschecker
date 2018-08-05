package com.reader;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.models.CmfoodchainType;

public class XMLFileReaderTest {
	private XMLFileReader  fileReader = null;
	
	@Before
	public void setUp() throws Exception {
		fileReader = new XMLFileReader();
	}

	@After
	public void tearDown() throws Exception {
		fileReader = null;
	}

	@Test
	public void testReadFile() {
		CmfoodchainType cmfoodchainType = fileReader.readFile(new File("D:\\data\\input\\BOM-1234-456.xml"));
		Assert.assertEquals("Mumbai", cmfoodchainType.getBranch().getLocation());
	}

}