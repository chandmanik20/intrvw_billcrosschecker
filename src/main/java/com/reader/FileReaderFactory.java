package com.reader;

import java.io.File;

/**
 * 
 * This will return specific file reader 
 * if file extension is ".json", it will return "JSONFileReader".
 * if file extension is ".xml", it will retur "XMLFileReader".
 * 
 * @author User
 *
 */

public class FileReaderFactory {
	private static final String JSON_EXT = ".json";
	private static final String XML_EXT = ".xml";
	
	public static FileReader getInstance(File file){
		FileReader fileReader = null;
		if(file.getName().endsWith(XML_EXT)){
			fileReader = new XMLFileReader();
		} else if(file.getName().endsWith(JSON_EXT)){
			fileReader = new JSONFileReader();
		} else {
			throw new RuntimeException("No File reader found for file name - "+ file.getName());
		}
		
		return fileReader;
	}
}
