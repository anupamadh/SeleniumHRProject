package hrapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.addLeaveEntitlementPage;
import resources.base;
@Test
public class validateAddEntitlement extends base{
	WebDriverWait wait; 
	public void AddEntitlement() {
		addLeaveEntitlementPage al = new addLeaveEntitlementPage(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.getEmployee().sendKeys("Russel");	
		al.getEmployee().sendKeys(Keys.ARROW_DOWN);
		al.getEmployee().sendKeys(Keys.ENTER);
		Select leave_type = new Select(al.getLeaveType());
		leave_type.selectByValue("4");
		Select leave_period = new Select(al.getLeavePeriod());
		leave_period.selectByValue("2020-01-01$$2020-12-31");
		al.getEntitlement().sendKeys("20");
		al.getSaveButton().click();
		Assert.assertEquals(al.getTotalText().getText(), "Total");
	}
	@AfterTest
	public void tearDown() {
			driver.close();
			driver = null;
		}
}
