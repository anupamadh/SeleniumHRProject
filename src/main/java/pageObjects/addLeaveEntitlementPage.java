package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addLeaveEntitlementPage {
	public WebDriver driver;
	
	Boolean checkText = false;
	private static WebDriverWait w= null;
	By employee_hint = By.cssSelector(".ac_input inputFormatHint");
	By employee = By.cssSelector("#entitlements_employee_empName");
	By leave_type = By.cssSelector("#entitlements_leave_type");
	By leave_period = By.cssSelector("#period");
	By entitlement = By.cssSelector("#entitlements_entitlement");
	By button_save = By.cssSelector("#btnSave");
	By total_leave = By.xpath("//td[contains(text(),'20.00')]");
	By total_text = By.cssSelector("tr[class='total'] td:nth-child(2)");
	
	public addLeaveEntitlementPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmployee() {
		return driver.findElement(employee);
	}
	
	public WebElement getLeaveType() {
		return driver.findElement(leave_type);
	}
	
	public WebElement getLeavePeriod() {
		return driver.findElement(leave_period);
	}
	
	public WebElement getEntitlement() {
		return driver.findElement(entitlement);
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(button_save);
	}
	
	public WebElement getTotalText() {
		//Explicit wait added for total leaves to be displayed
		w= new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(total_text));
		return driver.findElement(total_text);
	}
}
