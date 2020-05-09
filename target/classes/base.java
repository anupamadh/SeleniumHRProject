package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
public static WebDriver driver = null;
public Properties prop = null;
private static Logger log =LogManager.getLogger(base.class.getName());
public WebDriver initializeDriver() throws IOException {
	prop = new Properties();
	FileInputStream fis = new FileInputStream("/Users/anupamadhir/workspace/SeleniumHRProject/src/main/java/resources/data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else {
		log.error("Cannot identify the browser");
		System.exit(0);
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
	return driver;

}
}
