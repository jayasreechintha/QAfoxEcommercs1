package org.runnerclasses;

import org.pages.AccountCreatedPage;
import org.pages.RegisterPage;
import org.supportclasses.BaseClass;
import org.testng.annotations.BeforeClass;

public class WishListPage extends BaseClass{
	RegisterPage p;
	 AccountCreatedPage a;
	
	@BeforeClass
	private void bc() {
		ChromeDriver();
		launchUrl("https://tutorialsninja.com/demo/");
	}
}
