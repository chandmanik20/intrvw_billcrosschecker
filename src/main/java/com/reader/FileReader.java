package com.reader;

import java.io.File;

import com.models.CmfoodchainType;

/**
 * This will read the file.
 * 
 * @author User
 *
 */
public interface FileReader {
	/**
	 * pass the file object as argument and it will parse given file into java object.
	 * 
	 * @param file
	 * @return
	 */
	CmfoodchainType readFile(File file);
}
