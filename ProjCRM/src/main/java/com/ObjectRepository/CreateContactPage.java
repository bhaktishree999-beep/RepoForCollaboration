package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	@FindBy (name="lastname")
	private WebElement LastName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLastName() {
        return LastName;
	}
	public WebElement getSaveBtn() {
        return saveBtn;
	}
	public void createContact(String lastname) {
        LastName.sendKeys(lastname);
        saveBtn.click();
    }
}



   
