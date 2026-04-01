package myFramework.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard {

	//  Webdriver and wait class-level declaration

//	private WebDriver driver;
	private WebDriverWait wait;

	//	WebElements locator

	private static By searchNav = By.xpath("//*[text()='Search']");
	private static By aboutUsNav = By.xpath("//*[text()='About Us']");
	private static By loginNav = By.xpath("//*[text()='Log In']");
	private static By signUpNav = By.xpath("//*[text()='Sign up']");
	private static By MyCart = By.xpath("//*[contains(text(),'My Cart')]");
	private static By check_out = By.xpath("//*[contains(text(),'Check Out')]");
	private static By sidebar = By.xpath("//*[@id= 'main-menu']/li/a");
	private static By searchBox = By.cssSelector("#search-field");
	private static By searchClick = By.cssSelector("#search-submit");
	
	//  Constructor

	public DashBoard(WebDriverWait wait) {
//		this.driver = driver;
		this.wait = wait;
	}

//	Getting lists of WebElement under sidebar
	
	public List<WebElement> getSearchResults(){
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sidebar));
	}
	
	//	WebElement Interaction
	public void clickingSearchNav() {
		try{
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(searchNav));
			e.click();
		}
		catch(TimeoutException g) {
			throw new TimeoutException("Search nav is not found it yet");
		}
	}

	public void aboutUsNav() {
		try{
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsNav));
			e.click();
		}
		catch(TimeoutException g) {
			throw new TimeoutException("aboutUsNav is not found it yet");
		}
	}
	public void loginNav() {
		try{
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(loginNav));
			e.click();
		}
		catch(TimeoutException g) {
			throw new TimeoutException("loginNav is not found it yet");
		}
	}
	public void signUpNav() {
		try{
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpNav));
			e.click();
		}
		catch(TimeoutException g) {
			throw new TimeoutException("loginNav is not found it yet");
		}
	}
	
	public void searchfield(String s) {
		try{
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
			e.clear();
			e.click();
			e.sendKeys(s);
			WebElement f = wait.until(ExpectedConditions.visibilityOfElementLocated(searchClick));
			f.click();
		}
		catch(TimeoutException g) {
			throw new TimeoutException("searchBox is not found it yet");
		}
	}

}
