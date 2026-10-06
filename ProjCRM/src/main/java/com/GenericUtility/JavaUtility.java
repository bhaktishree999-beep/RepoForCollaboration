package com.GenericUtility;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

   /**
    * This class is used to fetch test data from external resource file
    * @author Bhakti
    */

public class JavaUtility {
	
	/**
	 * This method is used to capture the local date and time
	 * @return
	 */
	
	public String timeStamp() {
		
		String time = LocalDateTime.now().toString().replace(":", "_");
		
		return time;
	}
	
	/**
	 * This method is used to generate random number
	 * @return
	 */
	
	 public int generateRandomNumber() {
		 
		 Random random = new Random();
		 int randomvalue = random.nextInt(100000);
		 return randomvalue; 
	 }
	 /**
	  * This method is used to generate random string data
	  * @return
	  */
    public String generateRandomDate() {
    	
    	String data = UUID.randomUUID().toString().replaceAll("a-zA-Z]","");
    	return data;
}	
}
