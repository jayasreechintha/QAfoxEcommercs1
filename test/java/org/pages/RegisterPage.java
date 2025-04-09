package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.supportclasses.BaseClass;

public class RegisterPage extends BaseClass{
	public RegisterPage() {
		PageFactory.initElements(driver,this);
		
	}
		@FindBy(xpath = "//a[@title='My Account']") 
		private WebElement MyAccount;
		
		@FindBy(linkText = "Register")
		public WebElement Register;
		
		public WebElement getMyAccount() {
			return MyAccount;
		}

		public void setMyAccount(WebElement myAccount) {
			MyAccount = myAccount;
		}

		public WebElement getRegister() {
			return Register;
		}

		public void setRegister(WebElement register) {
			Register = register;
		}

		public WebElement getFirstname() {
			return firstname;
		}

		public void setFirstname(WebElement firstname) {
			this.firstname = firstname;
		}

		public WebElement getLastname() {
			return lastname;
		}

		public void setLastname(WebElement lastname) {
			this.lastname = lastname;
		}

		public WebElement getEmail() {
			return email;
		}

		public void setEmail(WebElement email) {
			this.email = email;
		}

		public WebElement getTelephone() {
			return telephone;
		}

		public void setTelephone(WebElement telephone) {
			this.telephone = telephone;
		}

		public WebElement getPassword() {
			return password;
		}

		public void setPassword(WebElement password) {
			this.password = password;
		}

		public WebElement getConfirm() {
			return confirm;
		}

		public void setConfirm(WebElement confirm) {
			this.confirm = confirm;
		}

		public WebElement getAgree() {
			return agree;
		}

		public void setAgree(WebElement agree) {
			this.agree = agree;
		}

		public WebElement getRadioBtn() {
			return radioBtn;
		}

		public void setRadioBtn(WebElement radioBtn) {
			this.radioBtn = radioBtn;
		}

		public WebElement getContinueBtn() {
			return continueBtn;
		}

		public void setContinueBtn(WebElement continueBtn) {
			this.continueBtn = continueBtn;
		}
		@FindBy(name = "firstname")
		public WebElement firstname;
		
		@FindBy(name = "lastname")
		public WebElement lastname;
		
		@FindBy(name = "email")
		public WebElement email;
		
		@FindBy(name = "telephone")
		public WebElement telephone;
		
		@FindBy(name = "password")
		public WebElement password;
		
		@FindBy(name = "confirm")
		public WebElement confirm;
		
		@FindBy(name = "agree")
		public WebElement agree;
		
		@FindBy(xpath  = "(//input[@type='radio'])[2]")
		public WebElement radioBtn;
		
		public WebElement getRadioNoOption() {
			return RadioNoOption;
		}

		public void setRadioNoOption(WebElement radioNoOption) {
			RadioNoOption = radioNoOption;
		}
		@FindBy(xpath  = "//label[text()='No']")
		public WebElement RadioNoOption;
		@FindBy(xpath  = "//input[@type='submit']")
		public WebElement continueBtn;
		
		
		
		
		
		
		


}
