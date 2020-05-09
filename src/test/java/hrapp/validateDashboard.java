package hrapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.dashboardPage;
import resources.base;

@Test
public class validateDashboard extends base{
	private static Logger log =LogManager.getLogger(validateDashboard.class.getName());
	public void validateAppDashboard() throws InterruptedException {
		dashboardPage dp = new dashboardPage(driver);
		Assert.assertEquals(dp.getWelcome().getText(), "Welcome Admin");
		log.info("Landed on Dashboard Page");
		Thread.sleep(3000);
		
	}
	

	
}
