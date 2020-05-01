package hrapp;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{

@BeforeTest	
public void initialize() throws IOException {
	driver = initializeDriver();
}

@Test
public void basePageNavigation() throws IOException {
	driver.get(prop.getProperty("url"));
	LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys("Admin");
	lp.getPassword().sendKeys("admin123");
	lp.getLoginButton().click();
	
}



}
