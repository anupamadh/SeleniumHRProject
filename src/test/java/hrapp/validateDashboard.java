package hrapp;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.dashboardPage;
import resources.base;

@Test
public class validateDashboard extends base{
	public void validateAppDashboard() throws InterruptedException {
		dashboardPage dp = new dashboardPage(driver);
		Assert.assertEquals(dp.getWelcome().getText(), "Welcome Admin");
		Thread.sleep(3000);
		
	}
	

	
}
