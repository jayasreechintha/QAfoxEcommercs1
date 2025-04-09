package org.runnerclasses;

import org.openqa.selenium.By;
import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestingMandatoryFileds extends BaseClass{
	 RegisterPage p;
	 AccountCreatedPage a;
	String FirstName ="First Name must be between 1 and 32 characters!";
	String LastName ="Last Name must be between 1 and 32 characters!";
	String EMail ="E-Mail Address does not appear to be valid!";
	String Telephone ="Telephone must be between 3 and 32 characters!";
	String Password ="Password must be between 4 and 20 characters!";
	
	
	
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
		
		p.getContinueBtn().click();
		
		String expectedFirstName = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div[@class='text-danger']")).getText();
		String expectedLastName = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")).getText();
	    String expectedEmail = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div[@class='text-danger']")).getText();
	    String expectedtelephone = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")).getText();
	    String expectedPassword = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div[@class='text-danger']")).getText();
	
	org.testng.Assert.assertEquals(FirstName, expectedFirstName);
	org.testng.Assert.assertEquals(LastName, expectedLastName);
	org.testng.Assert.assertEquals(EMail, expectedEmail);
	org.testng.Assert.assertEquals(Telephone, expectedtelephone);
	org.testng.Assert.assertEquals(Password, expectedPassword);
	
	
	
	}
	
}
