package com.businessUtility;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.ObjectRepository.CampaignPage;
import com.ObjectRepository.ContactPage;
import com.ObjectRepository.CreateCampaignPage;
import com.ObjectRepository.CreateContactPage;
import com.ObjectRepository.CreateLeadsPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.LeadsPage;
import com.ObjectRepository.LoginPage;
import com.ObjectRepository.LogoutPage;

public class BaseClass {
	
	    //driver initialization
		public WebDriver driver = null;
		public static WebDriver sdriver;
		
		
		//create object for utility class
		public FileUtility fileUtil = new FileUtility();
		public JavaUtility javaUtil = new JavaUtility();
		public WebDriverUtility webUtil = new WebDriverUtility();
		
		
		//create object for POM class
		public LoginPage loginpage;
		public HomePage homepage;
		public CampaignPage campaignpage;
		public CreateCampaignPage createCampaignPage ;
		public ContactPage contactPage;
		public CreateContactPage createContactPage;
		public LeadsPage leadspage;
		public CreateLeadsPage createLeadsPage;
		public LogoutPage logoutpage;
		
		
		@BeforeSuite
		public void beforesuite() {
			Reporter.log("BeforeSuite - Database Connectivity established", true);
		}
		@AfterSuite
		public void afterSuite() {
			Reporter.log("AfterSuite - Database Connectivity terminated",true);
		}
		@BeforeTest
		public void befotetest() {
			Reporter.log("BeforeTest - report starts",true);
		}
		@AfterTest
		public void aftertest() {
			Reporter.log("AfterTest - report backup",true);	
		}
		@Parameters("browser")
		@BeforeClass
		public void beforeclass(String BROWSER) {
			Reporter.log("BeforeClass -launch browser",true);

			//create object for chrome driver class
		   // driver=new ChromeDriver();

		    //String BROWSER = null;
			
			if(BROWSER.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver();
				Reporter.log(BROWSER+"launched",true);
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();
				Reporter.log(BROWSER+"launched",true); 
			}
				else if(BROWSER.equalsIgnoreCase("firefox")) {
				
				driver = new EdgeDriver();
				Reporter.log(BROWSER+"launched",true);
				}
				else if(BROWSER.equalsIgnoreCase("safari")) {
					
					driver = new SafariDriver();
					Reporter.log(BROWSER+"launched",true);
				}
				else {
					Reporter.log("Invalid Input", true);
				}
			
		    //assign launched browser object to sdriver;
		    sdriver = driver;

			//maximize browser
			driver.manage().window().maximize();
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		@AfterClass
		public void afterclass() {
			Reporter.log("AfterClass - close browser",true);
			
			//close browser
			driver.quit();
		}
		@BeforeMethod	
		public void beforemethod() throws IOException, InterruptedException {
			//print
			Reporter.log("BeforeMethod - login to application",true);
			//create object for utility class
			FileUtility fileUtil = new FileUtility();
			
			//read data from the properties file
			String URL = fileUtil.readDataFromPropertiesFile("url");
			String USERNAME = fileUtil.readDataFromPropertiesFile("username");
			String PASSWORD = fileUtil.readDataFromPropertiesFile("password");
			
			//navigate to url
			driver.get(URL);
			
			Thread.sleep(2000);	
			
			//create object for POM class
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
	        campaignpage = new CampaignPage(driver);
	        createCampaignPage = new CreateCampaignPage(driver);
	        contactPage = new ContactPage(driver);
	        createContactPage = new CreateContactPage(driver);
	        leadspage = new LeadsPage(driver);
	        createLeadsPage = new CreateLeadsPage(driver);
	        logoutpage = new LogoutPage(driver);
			
			
			
	      //perform login
			loginpage.login(USERNAME, PASSWORD);	
		}
		@AfterMethod
		public void aftermethod() {
			Reporter.log("AfterMethod - logout to application",true);
		}
}
