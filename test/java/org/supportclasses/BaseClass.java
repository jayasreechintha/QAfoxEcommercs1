package org.supportclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void ChromeDriver() {
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();

	}
	public static void edgedriver() {
		driver=new EdgeDriver();
		WebDriverManager.edgedriver().setup();

	}
	
	public static void launchUrl(String url) {
		driver.get(url);

	}

}
