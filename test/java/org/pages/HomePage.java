package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.supportclasses.BaseClass;

public class HomePage extends BaseClass{
public HomePage() {
	PageFactory.initElements(driver, this);
}
	@FindBy(tagName = "My Account")
	public WebElement MyAccountdropdown;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
