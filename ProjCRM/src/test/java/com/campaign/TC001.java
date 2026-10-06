package com.campaign;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC001 {
	
	@Test
	public void test() {
		Reporter.log("hi",true);
	}
}
