package hrapp;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;
import utils.jdbcConnection;

public class HomePage extends base{

@BeforeTest	
public void initialize() throws IOException {
	driver = initializeDriver();
}


/**@Test(dataProvider = "test1data")
public void basePageNavigation(String username, String password) throws IOException {
	driver.get(prop.getProperty("url"));
	LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys(username);
	lp.getPassword().sendKeys(password);
	lp.getLoginButton().click();
	
}
*/


@Test
public void basePageNavigation() throws IOException, SQLException {
	driver.get(prop.getProperty("url"));
	LoginPage lp = new LoginPage(driver);
	jdbcConnection jd = new jdbcConnection();
	jd.getConnection();
	lp.getUsername().sendKeys(jd.getUsername());
	lp.getPassword().sendKeys(jd.getPassword());
	lp.getLoginButton().click();
	
}
/**
@DataProvider(name="test1data")
public Object[][] getData() {
	String excelPath = "/Users/anupamadhir/workspace/SeleniumHRProject/excel/data.xlsx";
	Object data[][] = testData(excelPath, "Sheet1");
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
*/

}
