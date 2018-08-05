package com.writer;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.models.Cmfoodchain;
import com.models.JSONObject;
import com.models.MatchModel;

public class JSONFileWriterTest {
	private JSONFileWriter jsonFileWriter = null;
	private String fileName = "D:\\data\\output\\test.json";
	
	@Before
	public void setUp() throws Exception {
		File file = new File(fileName);
		if(file.exists()){
			file.delete();
		}
	}

	@After
	public void tearDown() throws Exception {
		File file = new File(fileName);
		if(file.exists()){
			file.delete();
		}
	}

	@Test
	public void testWriteFile() {
		List<MatchModel> matchModelList = new ArrayList<MatchModel>();
		MatchModel matchModel1 = new MatchModel(false, "Mumbai_test", 124.00f, 132.00f, "BOM-1234-456");
		MatchModel matchModel2 = new MatchModel(false, "Mumbai_test", 125.00f, 135.00f, "BOM-1234-466");
		MatchModel matchModel3 = new MatchModel(false, "Mumbai_test", 139.00f, 140.00f, "BOM-1234-477");
		matchModelList.add(matchModel1);
		matchModelList.add(matchModel2);
		matchModelList.add(matchModel3);
				
		Cmfoodchain cmfoodchain = new Cmfoodchain();
		JSONObject jsonObject = new JSONObject();
		jsonObject.setCmfoodchain(cmfoodchain);
		cmfoodchain.setBranch(matchModelList);
		
		jsonFileWriter = new JSONFileWriter(fileName, jsonObject);
		boolean bool = jsonFileWriter.writeFile();
		Assert.assertTrue(bool);
	}
	
}
