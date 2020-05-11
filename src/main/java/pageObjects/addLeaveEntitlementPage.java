package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addLeaveEntitlementPage {
	private WebDriver driver;
	
	private static WebDriverWait w= null;
	private By employee = By.cssSelector("#entitlements_employee_empName");
	private By leave_type = By.cssSelector("#entitlements_leave_type");
	private By leave_period = By.cssSelector("#period");
	private By entitlement = By.cssSelector("#entitlements_entitlement");
	private By button_save = By.cssSelector("#btnSave");
	private By total_text = By.cssSelector("tr[class='total'] td:nth-child(2)");
	private By popup = By.id("employeeEntitlement");
	private By popup_confirm = By.id("dialogUpdateEntitlementConfirmBtn");
	
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
		return driver.findElement(total_text);
	}
	
	@SuppressWarnings("finally")
	public int getPopupSize() {
		try {
		w= new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(popup));
		
		}
		finally{
			return driver.findElements(popup).size();
		}
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup_confirm);
	}
}
