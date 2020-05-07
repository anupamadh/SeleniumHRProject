package hrapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.addLeaveEntitlementPage;
import pageObjects.dashboardPage;
import resources.base;
import utils.ExcelUtils;
@Test
public class validateAddEntitlement extends base{
	WebDriverWait wait; 
	@Test(dataProvider = "addleave")
	public void AddEntitlement(String employee, String leaveType, String leavePeriod, String entitlement) {
		dashboardPage dp = new dashboardPage(driver);
		addLeaveEntitlementPage al = new addLeaveEntitlementPage(driver);
		dp.getAddEntitlements().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.getEmployee().sendKeys(employee);	
		al.getEmployee().sendKeys(Keys.ARROW_DOWN);
		al.getEmployee().sendKeys(Keys.ENTER);
		Select leave_type = new Select(al.getLeaveType());
		leave_type.selectByValue(leaveType);
		Select leave_period = new Select(al.getLeavePeriod());
		leave_period.selectByValue(leavePeriod);
		al.getEntitlement().sendKeys(entitlement);
		al.getSaveButton().click();
		if (al.getPopupSize()>0) {
			al.getPopup().click();
		}
		Assert.assertEquals(al.getTotalText().getText(), "Total");
	}
	
	@DataProvider(name="addleave")
	public Object[][] getData() {
		String excelPath = "/Users/anupamadhir/workspace/SeleniumHRProject/excel/data.xlsx";
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
