package myFramework.BaSE;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import myFramework.utils.ConfigFileReader;

public class BaseMethods {
	
//	Declaring the webdriver at the class-level
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
//	Declaring the Methods for the driver initialization
	
	@BeforeMethod
	public void setUpTheBrowser() {
		String browserName = ConfigFileReader.getValue("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notification");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notification");
			options.addArguments("--disable-infobars");
			driver = new FirefoxDriver(options);
		}
		String time = ConfigFileReader.getValue("explicitWait");
		int t = Integer.parseInt(time);
		wait = new WebDriverWait(driver,Duration.ofSeconds(t));
		driver.get(ConfigFileReader.getValue("baseURL"));
	}
	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
}
