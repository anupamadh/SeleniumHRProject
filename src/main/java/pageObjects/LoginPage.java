package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
private WebDriver driver = null;

private By username = By.id("txtUsername");
private By password = By.cssSelector("input[name='txtPassword']");
private By login_button = By.xpath("//input[@name='Submit']");

public LoginPage(WebDriver driver) {
	this.driver = driver;
}
public WebElement getUsername() {
	return driver.findElement(username);
}

public WebElement getPassword() {
	return driver.findElement(password);
}

public WebElement getLoginButton() {
	return driver.findElement(login_button);
}

}
