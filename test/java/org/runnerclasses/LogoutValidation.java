package org.runnerclasses;

import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LogoutValidation extends BaseClass{
	 RegisterPage p;
	 AccountCreatedPage a;
	
	@BeforeClass
	private void bc() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
	}

	@Test
	private void tc1() {
		 p = new RegisterPage();
		p.getMyAccount().click();
		p.getRegister().click();
		p.getFirstname().sendKeys("nani");
		p.getLastname().sendKeys("A");
		p.getEmail().sendKeys(DateDynamic.email());
		p.getTelephone().sendKeys("1234567889");
		p.getPassword().sendKeys("123456");
		p.getConfirm().sendKeys("123456");
		p.getRadioBtn().click();
		p.getAgree().click();
		p.getContinueBtn().click();
		
		
	}
	
	@Test
	private void tc2() throws InterruptedException {
		a= new AccountCreatedPage();
		Thread.sleep(3000);
		Assert.assertTrue(a.getLogoutField().isDisplayed());
		
		Assert.assertTrue(a.getEditAccountField().isDisplayed());
		
		Assert.assertTrue(a.getOrderHistoryField().isDisplayed());
		
		a.getLogoutField().click();
		
		Assert.assertTrue(a.getLoginField().isDisplayed());
		
		System.out.println("logout is valid");

	}
}
