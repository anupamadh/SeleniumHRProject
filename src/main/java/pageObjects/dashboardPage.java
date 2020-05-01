package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage {
	
public WebDriver driver;
By welcome = By.cssSelector("#welcome");

public dashboardPage(WebDriver driver) {
	this.driver = driver;
}

public WebElement getWelcome() {
	return driver.findElement(welcome);
	
}
}
