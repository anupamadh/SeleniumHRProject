package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addLeaveEntitlementPage {
	public WebDriver driver;
	WebDriverWait w;
	Boolean checkText = false;
	By employee_hint = By.cssSelector(".ac_input inputFormatHint");
	By employee = By.cssSelector("#entitlements_employee_empName");
	By leave_type = By.cssSelector("#entitlements_leave_type");
	By leave_period = By.cssSelector("#period");
	By entitlement = By.cssSelector("#entitlements_entitlement");
	By button_save = By.cssSelector("#btnSave");
	By total_leave = By.xpath("//td[contains(text(),'20.00')]");
	
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
