package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addLeaveEntitlementPage {
	public WebDriver driver;
	
	By employee = By.cssSelector("#entitlements_employee_empName");
	By leave_type = By.cssSelector("#entitlements_leave_type");
	By leave_period = By.cssSelector("#period");
	By entitlement = By.cssSelector("#entitlements_entitlement");
	By button_save = By.cssSelector("#btnSave");
	
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
}
