package org.runnerclasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.BaseClass;
import org.supportclasses.DateDynamic;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ValidationaWithScreenShort extends BaseClass {
	RegisterPage p;
	 AccountCreatedPage a;
	
	@BeforeClass
	private void bc() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
	}

	@Test
	private void tc1() throws InterruptedException, Exception {
		 p = new RegisterPage();
		p.getMyAccount().click();
		p.getRegister().click();
		p.getFirstname().sendKeys("nani");
		p.getLastname().sendKeys("A");
		p.getEmail().sendKeys("nani");
		
		p.getTelephone().sendKeys("1234567889");
		p.getPassword().sendKeys("123456");
		p.getConfirm().sendKeys("123456");
		p.getRadioNoOption().click();
		p.getAgree().click();
		p.getContinueBtn().click();
		Thread.sleep(3000);
	
		
//		TakesScreenshot s= (TakesScreenshot) driver;
//		File screenshotAs = s.getScreenshotAs(OutputType.FILE);
		File source = driver.findElement(By.className("form-horizontal")).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Admin\\git\\repository\\QAfoxEcommercs1\\src\\screenshots\\emailfielsActual.png");
		FileUtils.copyFile(source,destination);
		
		BufferedImage Actualmage = ImageIO.read(destination);
		BufferedImage expectedImage = ImageIO.read( new File("C:\\Users\\Admin\\git\\repository\\QAfoxEcommercs1\\src\\ExpectedScreenshots\\emailfiels.png"));
		  ImageDiffer imgDiff = new ImageDiffer();
          ImageDiff diff = imgDiff.makeDiff(expectedImage,Actualmage);
          boolean hasDiff = diff.hasDiff();
          System.out.println(hasDiff);
          Assert.assertFalse(hasDiff);
	}
}
