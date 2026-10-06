package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPage {
	
	@FindBy (name="lastname")
	private WebElement LastName;
	@FindBy(name="companyname")
	private WebElement CompanyName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLastName() {
        return LastName;
    }

    public WebElement getCompanyName() {
        return CompanyName;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }
	
	public void createLeads(String lastname, String companyname) {
        LastName.sendKeys(lastname);
        CompanyName.sendKeys(companyname);
        saveBtn.click();
    }
}