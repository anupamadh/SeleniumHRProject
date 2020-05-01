package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class dashboardPage {
	
public WebDriver driver;
By welcome = By.cssSelector("#welcome");
By leave = By.id("menu_leave_viewLeaveModule");

public dashboardPage(WebDriver driver) {
	this.driver = driver;
}

public WebElement getWelcome() {
	return driver.findElement(welcome);
	
}

public WebElement getAddEntitlements() {
	WebElement element = driver.findElement(leave);
	element.click();
	Actions actions = new Actions(driver);
	WebElement entitlements = driver.findElement(By.xpath("//a[@id='menu_leave_Entitlements']"));
	actions.moveToElement(entitlements).perform();
	WebElement addEntitlements = driver.findElement(By.xpath("//a[contains(text(),'Add Entitlements')]"));
	return addEntitlements;
	
	
	
}
}
