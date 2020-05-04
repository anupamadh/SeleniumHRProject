package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignLeavePage {
	public WebDriver driver;
	private static WebDriverWait w= null;
	By employee_name = By.id("assignleave_txtEmployee_empName");
	By leave_type = By.id("assignleave_txtLeaveType");
	By from_date = By.cssSelector("#assignleave_txtFromDate+img");
	By month = By.cssSelector("select[class='ui-datepicker-month'] ");
	By date = By.cssSelector("td[data-handler='selectDay'] .ui-state-default ");
	By to_date = By.cssSelector("#assignleave_txtToDate+img");
	By assign_msg = By.cssSelector(".message.success.fadable");
	
	By assign_button = By.id("assignBtn");
	public assignLeavePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmployeeName() {
		return driver.findElement(employee_name);
	}
	
	public WebElement getLeaveType() {
		return driver.findElement(leave_type);
	}
	
	public WebElement getFromDate() {
		return driver.findElement(from_date);
	}
	
	public WebElement getToDate() {
		return driver.findElement(to_date);
	}
	
	public WebElement getMonth() {
		return driver.findElement(month);
	}
	
	public WebElement getDate(String fromToDate) {
		List<WebElement> dates = driver.findElements(date);
		for (WebElement date: dates) {
			if (date.getText().equals(fromToDate)) {
				return date;
			}
		}
		return null;
	}
	
	public WebElement getAssignButton() {
		w= new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.elementToBeClickable(assign_button));
		return driver.findElement(assign_button);
	}
	
	public WebElement getAssignMsg() {
		w= new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.presenceOfElementLocated(assign_msg));
		return driver.findElement(assign_msg);
	}

	
}
