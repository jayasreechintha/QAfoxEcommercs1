package org.runnerclasses;

import org.openqa.selenium.By;
import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationWithNoSubscription extends BaseClass{
	 RegisterPage p;
	 AccountCreatedPage a;
	
	@BeforeClass
	private void bc() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
	}

	@Test
	private void tc1() throws InterruptedException {
		 p = new RegisterPage();
		p.getMyAccount().click();
		p.getRegister().click();
		p.getFirstname().sendKeys("nani");
		p.getLastname().sendKeys("A");
		p.getEmail().sendKeys(DateDynamic.email());
		
		p.getTelephone().sendKeys("1234567889");
		p.getPassword().sendKeys("123456");
		p.getConfirm().sendKeys("123456");
		p.getRadioNoOption().click();
		p.getAgree().click();
		p.getContinueBtn().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Newsletter'])[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Newsletter'])[1]")).isDisplayed());
//		boolean selected = driver.findElement(By.xpath("//input[@value='0']")).isSelected();
//		System.out.println("----------"+selected);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='0']")).isSelected());
	}
}
