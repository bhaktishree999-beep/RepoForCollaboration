package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	@FindBy(xpath="[title='Create Lead...']")
	private WebElement CreateLeads;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateLeads() {
		return CreateLeads;		
	}
	public void clickCreateLeads() {
        CreateLeads.click();
	}
}

