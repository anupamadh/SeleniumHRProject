package hrapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.assignLeavePage;
import pageObjects.dashboardPage;
import resources.base;

public class validateAssignLeave extends base{
	WebDriverWait wait;
	@Test
	public void assignLeave() {
		dashboardPage dp = new dashboardPage(driver);
		assignLeavePage alp= new assignLeavePage(driver);
		Assert.assertEquals(dp.getDashboardMenu().getText(), "Dashboard");
		dp.getDashboardMenu().click();
		dp.getAssignLeave().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alp.getEmployeeName().sendKeys("Russel");	
		alp.getEmployeeName().sendKeys(Keys.ARROW_DOWN);
		alp.getEmployeeName().sendKeys(Keys.ENTER);
		Select leave_type = new Select(alp.getLeaveType());
		leave_type.selectByValue("4");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alp.getFromDate().click();
		Select fromMonth = new Select(alp.getMonth());
		fromMonth.selectByValue("6");
		alp.getDate("8").click();
		alp.getToDate().click();
		Select toMonth = new Select(alp.getMonth());
		toMonth.selectByValue("6");
		alp.getDate("16").click();
		alp.getAssignButton().click(); 
		alp.getAssignMsg();
		Assert.assertTrue(alp.getAssignMsg().getText().contains("Successfully Assigned"));
	/**	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	@AfterTest
	public void tearDown() {
			driver.close();
			driver = null;
		}
}
