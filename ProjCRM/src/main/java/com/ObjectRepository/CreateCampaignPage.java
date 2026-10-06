package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	@FindBy (name="campaignname")
	private WebElement CampaignName;
	@FindBy(id = "jscal_field_closingdate")
	private WebElement ExpectedClosingDate;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getCampaignName() {
		return CampaignName;
	}
	public WebElement getExpectedClosingDate() {
		return ExpectedClosingDate;
	}
	public WebElement getSaveBtn() {
        return saveBtn;
	}
	
	public void createCampaign(String campaignName) {
        CampaignName.sendKeys(campaignName);
        saveBtn.click();
    }

    public void createCampaign(String campaignName, String closingDate) {
        CampaignName.sendKeys(campaignName);
        ExpectedClosingDate.clear();
        ExpectedClosingDate.sendKeys(closingDate);
        saveBtn.click();

}
}
