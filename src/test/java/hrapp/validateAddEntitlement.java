package hrapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.addLeaveEntitlementPage;
import resources.base;
@Test
public class validateAddEntitlement extends base{
	
	public void AddEntitlement() {
		addLeaveEntitlementPage al = new addLeaveEntitlementPage(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		al.getEmployee().click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.getEmployee().sendKeys("Russel");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.getEmployee().sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.getEmployee().sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Entered employee");
		Select leave_type = new Select(al.getLeaveType());
		leave_type.selectByValue("4");
		Select leave_period = new Select(al.getLeavePeriod());
		leave_period.selectByValue("2020-01-01$$2020-12-31");
		al.getEntitlement().sendKeys("20");
		
	
		/**al.getEmployee().click();
		
			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		al.getSaveButton().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void tearDown() {
			driver.close();
			driver = null;
		}
}
