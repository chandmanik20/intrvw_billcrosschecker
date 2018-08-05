package com.writer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.JSONObject;

/**
 * This class write to a file with json specific data.
 * @author User
 *
 */
public class JSONFileWriter implements FileWriter {
	private JSONObject jsonObject;
	private String fileName;
	
	public JSONFileWriter(String fileName, JSONObject jsonObject){
		this.fileName = fileName;
		this.jsonObject = jsonObject;
	}
	
	public boolean writeFile(){
		System.out.println("Going to write file as json file....");
		System.out.println("fileName:"+fileName+"; matchModelList:"+jsonObject);

		ObjectMapper mapper = new ObjectMapper();

		File file = new File(this.fileName);
		try {
			// Serialize Java object info JSON file.
			mapper.writeValue(file, jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	
}