package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

     /**
      * This class is used to fetch test data from external resource file
      * @author Bhakti
      */

public class FileUtility {
	
	/**
	 * This class is used to fetch test data from properties file
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertiesFile(String Key) throws IOException {
		
		        //create object FileInputStream class from java
				//fetching the file
				FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
				
				//Create object for file type class (Properties)
				//open the file
				Properties prop = new Properties();
				
				//load the data into the test script
				prop.load(fis);
				
				//read data from the loaded file
				String value = prop.getProperty(Key);
				
				return value;
	}

}
