package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		
		@FindBy (name = "Campaigns")
		private WebElement CampaignModule;
		@FindBy(linkText = "More")
		private WebElement MoreButton;
		@FindBy (linkText = "Contacts")
		private WebElement ContactModule;
		@FindBy (linkText = "Leads")
		private WebElement LeadsModule;
		
		
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public WebElement getCampaignModule() {
		return CampaignModule;
	}
	public WebElement getMoreButton() {
		return MoreButton;
	}
	public WebElement getContactModule() {
		return ContactModule;
	}
	public WebElement getLeadsModule() {
		return LeadsModule;
		
	}
	
	
	public void clickCampaigns() {
    CampaignModule.click();
	}

	public void clickContacts() {
    ContactModule.click();
	}

	public void clickLeads() {
    LeadsModule.click();
	}

	public void navigateToCampaignsViaMore() {
    MoreButton.click();
    CampaignModule.click();
	}
	}





