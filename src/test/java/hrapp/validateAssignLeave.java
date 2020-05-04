package hrapp;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.dashboardPage;
import resources.base;

public class validateAssignLeave extends base{
	WebDriverWait wait;
	@Test
	public void assignLeave() {
		dashboardPage dp = new dashboardPage(driver);
		Assert.assertEquals(dp.getDashboardMenu().getText(), "Dashboard");
		dp.getDashboardMenu().click();
		dp.getAssignLeave().click();
		
	}
	@AfterTest
	public void tearDown() {
			driver.close();
			driver = null;
		}
}
