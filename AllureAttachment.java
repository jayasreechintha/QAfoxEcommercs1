package org.runnerclasses;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.AllureListener;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

@Listeners({AllureListener.class})
public class AllureAttachment extends BaseClass{
	
	RegisterPage p;
	 AccountCreatedPage a;
	
	@BeforeClass
	private void bc() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
	}
	//allure
   @Description("verify registration")
   @Epic("epic EP001")
   @Story("ST001")
   @Severity(SeverityLevel.CRITICAL)
	@Test
	private void tc1() throws InterruptedException, Exception {
		 p = new RegisterPage();
		p.getMyAccount().click();
		p.getRegister().click();
		p.getFirstname().sendKeys("nani");
		p.getLastname().sendKeys("A");
		WebElement mail = driver.findElement(By.name("email"));
		mail.sendKeys(DateDynamic.email());
		
		p.getTelephone().sendKeys("1234567889");
		p.getPassword().sendKeys("123456");
		p.getConfirm().sendKeys("123456");
		p.getRadioNoOption().click();
		p.getAgree().click();
		p.getContinueBtn().click();
		Thread.sleep(3000);
	
		
//		
//		Alert a=driver.switchTo().alert();
//		a.accept();
//		
         
	}
   @Test
   @Description("verify registration")
   @Epic("epic EP002")
   @Story("ST002")
   @Severity(SeverityLevel.CRITICAL)
   
   private void tc2() {
	 //verify account data
	 		String expectedCreatedt="expectedCreatedt";
	 	

	 		String Created = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
	 		

	 		Assert.assertTrue(Created.contains(expectedCreatedt));
	 		

	 		System.out.println("test case for login is successfull");

	}
}
