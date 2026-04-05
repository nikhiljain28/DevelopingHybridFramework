package myFramework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentFLow {

	private WebDriver driver;
	private WebDriverWait wait;
	private String new_window;
	
	private By check_out_btn = By.xpath("//*[@value = 'Check Out']");
	private By check_out_on_cartpage = By.xpath("//*[@id='checkout']");
	
	public PaymentFLow(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait =wait;
	}
	
	public String checkOutBtnClicked() {
		
		WebElement check_outBTN = wait.until(ExpectedConditions.elementToBeClickable(check_out_btn));
		check_outBTN.click();
		new_window = driver.getWindowHandle();
		driver.switchTo().window(new_window);
		String page_title = driver.getTitle();
		return page_title;	
	}
	
	public String checkOutBtnClickedOnTheCheckOutPage() {
		checkOutBtnClicked();
		WebElement check_outBTN = wait.until(ExpectedConditions.elementToBeClickable(check_out_on_cartpage));
		check_outBTN.click();
		String s = driver.getWindowHandle();
		driver.switchTo().window(s);
		String page_title = driver.getTitle();
		return page_title;
	}
}
