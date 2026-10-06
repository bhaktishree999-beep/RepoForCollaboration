package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//Declaration
	@FindBy(name ="user_name")
	private WebElement UserNameTextField;
	@FindBy(name ="user_password")
	private WebElement PasswordTextField;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginButton;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getters-> right click - source - generate getters and setters
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	/**
	 * This method is used to login to the application
	 * @param username
	 * @param Password
	 */
	//create scenario based methods-objects
	public void login(String USERNAME, String PASSWORD)
	{
		//Call Username textfield
		UserNameTextField.sendKeys(USERNAME);
		//call password Textfield
		PasswordTextField.sendKeys(PASSWORD);
		//call login button
		LoginButton.click();
	}
}
