package com.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.models.Cmfoodchain;
import com.models.CmfoodchainType;
import com.models.JSONObject;
import com.models.MatchModel;
import com.processor.Processor;
import com.reader.FileReader;
import com.reader.FileReaderFactory;
import com.validator.BillValidator;
import com.writer.FileWriter;
import com.writer.JSONFileWriter;

public class Main {
	//location of the folder(file) where all input json and xml files are present.
	public static String SOURCE_LOCATION = null;
	//destination location where output Match.json and Mismatch.json files generated after the process 
	public static String DESTINATION_LOCATION = null;
	
	/**
	 * Invoker class to begin the process. 
	 * call from shell script to start the process.
	 * @param args
	 */
	public static void main(String[] args) {
		SOURCE_LOCATION = System.getenv("SOURCE_LOCATION");
		DESTINATION_LOCATION = System.getenv("DESTINATION_LOCATION");
		System.out.println("SOURCE_LOCATION["+SOURCE_LOCATION+"] DESTINATION_LOCATION["+DESTINATION_LOCATION+"]");
		
		Main main = new Main();
		
		main.call();
	}

	/**
	 * Aall method is the main method to start process.
	 * Step 1: - This will first read location and sub-folder to collect all files.
	 * Step 2: - Read "XML" and "JSON" files and get objects.
	 * Step 3: - Match collected object for success, and create 2 list match and mismatch.
	 * Step 4: - Prepare writable objects - match and mismatch.
	 * Step 5: - Write matched and mismatched object list into 2 different "JSON" files.
	 */
	public void call() {
		File folder = new File(SOURCE_LOCATION);
		
		//List of the file name under given location
		List<File> allFileNames = getAllFileUnderLocation(folder);
		System.out.println("allFileNames["+allFileNames+"]");
		
		//TODO read all files and create models objects
		List<CmfoodchainType> collections = new ArrayList<CmfoodchainType>();
		
		for (Iterator<File> iterator = allFileNames.iterator(); iterator.hasNext();) {
			File file = iterator.next();
			FileReader fileReader = FileReaderFactory.getInstance(file);
			CmfoodchainType cmfoodchainType = fileReader.readFile(file);
			collections.add(cmfoodchainType);
		}
		
		// process for match and mismatch output
		Processor processor = new Processor(collections, new BillValidator());
		processor.process();
		List<MatchModel> matchedModels = processor.getMatchModels();
		
		List<MatchModel> mismatchedModels = processor.getMismatchModels();
		
		JSONObject writableObject = getWritableObject(matchedModels);
		JSONObject writableObjectMismatch = getWritableObject(mismatchedModels);
		
		FileWriter fileWriter = new JSONFileWriter(DESTINATION_LOCATION + System.getProperty("file.separator")+"Match.json", writableObject);
		fileWriter.writeFile();
		
		FileWriter fileWriterMismatch = new JSONFileWriter(DESTINATION_LOCATION + System.getProperty("file.separator")+"Mismatch.json", writableObjectMismatch);
		fileWriterMismatch.writeFile();
		
	}

	/**
	 * 
	 * prepare writable object.
	 * 
	 * @param matchedModels
	 * @return
	 */
	private static JSONObject getWritableObject(List<MatchModel> matchedModels) {
		if(matchedModels == null || matchedModels.size() ==0){
			return new JSONObject();
		}
		
		Cmfoodchain cmfoodchain = new Cmfoodchain();
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.setCmfoodchain(cmfoodchain);
		cmfoodchain.setBranch(matchedModels);
		
		return jsonObject;
	}

	/**
	 * It will traverse recursively to collect all files under given directory location.
	 * 
	 * @param folder
	 * @return
	 */
	private static List<File> getAllFileUnderLocation(File folder) {
		List<File> fileList = new ArrayList<File>();
		
		 for (File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		        	List<File> innerFileList = getAllFileUnderLocation(fileEntry);
		        	fileList.addAll(innerFileList);
		        } else {
		            System.out.println(fileEntry.getName());
		            fileList.add(fileEntry);
		        }
		    }
		 return fileList;
	}
}
