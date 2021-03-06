package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignLeavePage {
	private WebDriver driver;
	private static Logger log =LogManager.getLogger(assignLeavePage.class.getName());
	private static WebDriverWait w= null;
	private By employee_name = By.id("assignleave_txtEmployee_empName");
	private By leave_type = By.id("assignleave_txtLeaveType");
	private By from_date = By.cssSelector("#assignleave_txtFromDate+img");
	private By month = By.cssSelector("select[class='ui-datepicker-month'] ");
	private By date = By.cssSelector("td[data-handler='selectDay'] .ui-state-default ");
	private By to_date = By.cssSelector("#assignleave_txtToDate+img");
	private By assign_msg = By.cssSelector(".message.success.fadable");
	
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
		log.error("Cannot select date"); 
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
