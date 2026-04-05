package myFramework.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpandLoginDetails {


	private WebDriver driver;
	private WebDriverWait wait;

	public SignUpandLoginDetails(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private By createAccount_Form = By.cssSelector("#create_customer div");
	private By first_name_txt = By.cssSelector("#first_name input");
	private By last_name_txt = By.cssSelector("#last_name input");
	private By email_address_txt = By.cssSelector("#email input");
	private By password_txt = By.cssSelector("#password input");
	private By Sign_up_btn = By.cssSelector("#customer_register_link");
	private By create_btn = By.xpath("//*[@value = 'Create']");
	private By sent_message = By.xpath("//*[@class = 'errors']//li");


	public void create_Account_Form() {

		List<WebElement> attributes_under_create_Form = driver.findElements(createAccount_Form);
		for(int i=1;i<attributes_under_create_Form.size();i++) {
			WebElement el = attributes_under_create_Form.get(i);
			System.out.println(el.getText());
		}			
	}
	
	public void enteringDetailsInFirstName() {
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(first_name_txt));
		firstName.sendKeys("Nikhil");
	}
	
	public void enteringDetailsInLastName() {
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(last_name_txt));
		firstName.sendKeys("Jain");
	}
	
	public void enteringDetailsInEmail() {
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(email_address_txt));
		firstName.sendKeys("nik@yopmail.com");
	}
	
	public void enteringDetailsInPassword() {
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(password_txt));
		firstName.sendKeys("Demo@1234");
	}
	
	public void clickOntheSignUpPageAndCreateAnAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(Sign_up_btn)).click();
		enteringDetailsInFirstName();
		enteringDetailsInLastName();
		enteringDetailsInEmail();
		enteringDetailsInPassword();
		wait.until(ExpectedConditions.elementToBeClickable(create_btn)).click();
		wait.until(ExpectedConditions.elementSelectionStateToBe(sent_message,true));
		}
}

