package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy (xpath="[title='Create Contact...']")
	private WebElement CreateContact;

	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getCreateContact() {
		return CreateContact;
	}
	
	public void clickCreateContact() {
        CreateContact.click();
    }
}

