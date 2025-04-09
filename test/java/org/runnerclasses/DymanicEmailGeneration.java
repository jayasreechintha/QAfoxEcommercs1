package org.runnerclasses;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DymanicEmailGeneration extends BaseClass{
	
	
//	
//	@Test
//	private void tc1() {
//		ChromeDriver();
//		launchUrl("https://tutorialsninja.com/demo/");
//driver.findElement(By.xpath("//a[@title='My Account']")).click();
//driver.findElement(By.linkText("Register")).click();
//driver.findElement(By.name("firstname")).sendKeys("jjj");
//driver.findElement(By.name("lastname")).sendKeys("kkk");
//driver.findElement(By.name("email")).sendKeys("jjjkkk@gmail.com");
//driver.findElement(By.name("telephone")).sendKeys("1234567");
//
//
//driver.findElement(By.name("password")).sendKeys("jjjkkk");
//driver.findElement(By.name("confirm")).sendKeys("jjjkkk");
//driver.findElement(By.name("agree")).click();
//driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}
	
	@Test
	private void tc1() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
driver.findElement(By.xpath("//a[@title='My Account']")).click();
driver.findElement(By.linkText("Register")).click();
driver.findElement(By.name("firstname")).sendKeys("jjj");
driver.findElement(By.name("lastname")).sendKeys("kkk");

//dynamic mail
WebElement mail = driver.findElement(By.name("email"));
mail.sendKeys(DateDynamic.email());

driver.findElement(By.name("telephone")).sendKeys("1234567");


driver.findElement(By.name("password")).sendKeys("jjjkkk");
driver.findElement(By.name("confirm")).sendKeys("jjjkkk");


driver.findElement(By.name("agree")).click();

assertTrue(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed());

driver.findElement(By.xpath("//input[@type='submit']")).click();

//verify text and continue button
WebElement element = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
 WebElement continueBtn = driver.findElement(By.xpath("//a[text()='Continue']"));
if (element.isDisplayed()) {
	
WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(10));
wait.until(ExpectedConditions.visibilityOf(continueBtn));

continueBtn.click();

//verify account data
String expectedaccount="My Account";
String expectedOrders="My Orders"; 
String expectedAffiliate="My Affiliate Account"; 
String expectedNewsletter="Newsletter"; 

String account = driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
String Orders = driver.findElement(By.xpath("//h2[text()='My Orders']")).getText();
String Affiliate = driver.findElement(By.xpath("//h2[text()='My Affiliate Account']")).getText();
String Newsletter = driver.findElement(By.xpath("//h2[text()='Newsletter']")).getText();

Assert.assertTrue(expectedaccount.contains(account));
Assert.assertTrue(expectedOrders.contains(Orders));
Assert.assertTrue(expectedAffiliate.contains(Affiliate));
Assert.assertTrue(Newsletter.contains(Newsletter));

System.out.println("test case for login is successfull");


}



	}

}
