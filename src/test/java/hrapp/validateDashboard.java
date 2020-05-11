package hrapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.dashboardPage;
import resources.base;
import utils.ExcelUtils;


public class validateDashboard extends base{
	private static Logger log =LogManager.getLogger(validateDashboard.class.getName());
	private dashboardPage dp;

	@Test(priority=1)
	public void validateAppDashboard() throws InterruptedException {
		dp = new dashboardPage(driver);
		Assert.assertEquals(dp.getWelcome().getText(), "Welcome Admin");
		log.info("Landed on Dashboard Page");
		Thread.sleep(3000);

	}
	@Test(priority=2,dataProvider = "addleave")

	public void AddEntitlement(String employee, String leaveType, String leavePeriod, String entitlement) {
		dp.getAddEntitlements().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dp.getEmployee().sendKeys(employee);	
		dp.getEmployee().sendKeys(Keys.ARROW_DOWN);
		dp.getEmployee().sendKeys(Keys.ENTER);
		Select leave_type = new Select(dp.getLeaveType());
		leave_type.selectByValue(leaveType);
		log.debug("Selecting leave period");
		Select leave_period = new Select(dp.getLeavePeriod());
		leave_period.selectByValue(leavePeriod);
		dp.getEntitlement().sendKeys(entitlement);
		dp.getSaveButton().click();
		if (dp.getPopupSize()>0) {
			dp.getPopup().click();
		}
		Assert.assertEquals(dp.getTotalText().getText(), "Total");
	}

	@DataProvider(name="addleave")
	public Object[][] getData() {
		String excelPath = System.getProperty("user.dir")+"/excel/data.xlsx";
		Object data[][] = testData(excelPath, "AddLeave");
		return data;
	}
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount(); 

		Object data[][] = new Object[rowCount-1][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j< colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}





}
