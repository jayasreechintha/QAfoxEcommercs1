package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.supportclasses.BaseClass;

public class AccountCreatedPage extends BaseClass{
	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogoutField() {
		return logoutField;
	}

	public void setLogoutField(WebElement logoutField) {
		this.logoutField = logoutField;
	}

	public WebElement getEditAccountField() {
		return EditAccountField;
	}

	public void setEditAccountField(WebElement editAccountField) {
		EditAccountField = editAccountField;
	}

	public WebElement getOrderHistoryField() {
		return OrderHistoryField;
	}

	public WebElement getLoginField() {
		return loginField;
	}
	public void setLoginField(WebElement loginField) {
		this.loginField = loginField;
	}
	public void setOrderHistoryField(WebElement orderHistoryField) {
		OrderHistoryField = orderHistoryField;
	}
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	public WebElement logoutField;
	@FindBy(xpath = "//a[text()='Edit Account']")
	public WebElement EditAccountField;
	
	@FindBy(xpath = "(//a[text()='Order History'])[2]")
	public WebElement OrderHistoryField;
	@FindBy(xpath = "(//a[text()='Login'])[2]")
	public WebElement loginField;
}
