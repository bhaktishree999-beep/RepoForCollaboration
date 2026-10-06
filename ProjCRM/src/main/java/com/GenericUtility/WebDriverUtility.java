package com.GenericUtility;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

   /**
    * This class is used to fetch test data from external resource file
    * @author Bhakti
    */

public class WebDriverUtility {
	
	     //MANAGE METHODS
	
		//maximizes the browser window
		public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
		//minimizes the browser window
		public void tominimize(WebDriver driver) {
			driver.manage().window().minimize();
		}
		
		//fullscreen 
		public void tofullscreen(WebDriver driver) {
			driver.manage().window().fullscreen();
		}
		
		
	     //Gets current window dimensions
	     public Dimension togetsize(WebDriver driver) {
	     return driver.manage().window().getSize();
	     }

	     //Resizes the browser window to custom dimensions (width x height)
	     public void tosetsize(WebDriver driver, int width, int height) {
	     Dimension dimension = new Dimension(width, height);
	     driver.manage().window().setSize(dimension);
	     }
	     
	     //capture the current position
	     public Point togetposition(WebDriver driver) {
	    	 return driver.manage().window().getPosition();
	     }
	     //set the position in point(x & y coordinates)
	     public void tosetposition(WebDriver driver, int x, int y) {
	    	 Point point = new Point(x, y);
	    	 driver.manage().window().setPosition(point);	 
	     }
	     
	     //NAVIGATE METHODS
	     
	    //perform back operation on the browser
	     public void toback(WebDriver driver) {
	    	 driver.navigate().back();
	     }
	     
	     //perform forward operation on the browser
	     public void toforward(WebDriver driver) {
	    	 driver.navigate().forward();
	     }
	     
	     
	     //perform refresh operation on the browser
	     public void torefresh(WebDriver driver) {
	    	 driver.navigate().refresh();
	     }
}
	     
