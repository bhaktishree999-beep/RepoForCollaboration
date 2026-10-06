package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	    //Declaration
		@FindBy(name ="user_name")
		private WebElement UserNameTextField;
		@FindBy(name ="user_password")
		private WebElement PasswordTextField;
		@FindBy(xpath = "//td[@class='small']/child::a/parent::td/preceding-sibling::td/child::img")
		private WebElement ProfileIcon;
		@FindBy(xpath = "//a[text()='Sign Out']")
		private WebElement LogoutButton;
		
		
		//Initialization
		public LogoutPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//getters-> right click - source - generate getters and setters
		public WebElement getUserNameTextField() {
			return UserNameTextField;
		}

		public WebElement getPasswordTextField() {
			return PasswordTextField;
		}

		public WebElement getLogoutButton() {
			return LogoutButton;
		}
		/**
		 * This method is used to logout from the application
		 * @param username
		 * @param Password
		 */
		//create scenario based methods-objects
		public void logout(String USERNAME, String PASSWORD)
		{
			//Call Username textfield
			UserNameTextField.sendKeys(USERNAME);
			//call password Textfield
			PasswordTextField.sendKeys(PASSWORD);
			//call login button
			ProfileIcon.click();
			LogoutButton.click();
		}

}
