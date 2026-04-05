package myFramework.page;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageArticles {

	private WebDriver driver;
	private WebDriverWait wait;

	public HomePageArticles(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private By articles = By.xpath("//*[@class='product-grid twelve columns alpha omega']/div");
	private By GeyJacket = By.xpath("//*[text()='Grey jacket']");
	private By NoirJacket = By.xpath("//*[text()='Noir jacket']");
	private By StripedTop = By.xpath("//*[text()='Striped top']");
	private By productName = By.cssSelector("#buy form h2");
	private By addToCartBtn = By.cssSelector("#add");
	private By cartValue = By.xpath("//*[contains(@class,'count cart-target')]");
	private By myCartButton = By.xpath("//*[contains(text(),'My Cart')]");
	private By info_productLabel = By.xpath("//*[@class='info']//a");
	private By info_priceOfTheItem = By.xpath("//*[contains(@class,'two columns price desktop')]");
	
	public List<WebElement> multiple_Articles(){
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(articles));
	}

	public void clickingOnGreyJacketandPricing() {
		Actions action = new Actions(driver);
		try {
			WebElement greyJacket = wait.until(ExpectedConditions.presenceOfElementLocated(GeyJacket));
			action.keyDown(Keys.COMMAND).click(greyJacket).keyUp(Keys.COMMAND).perform();
			Set<String> total_windows = driver.getWindowHandles();
			for(String oneBYOnewindow : total_windows) {
				driver.switchTo().window(oneBYOnewindow);
//				System.out.println(driver.getTitle());
			}
			WebElement productDescription = wait.until(ExpectedConditions.presenceOfElementLocated(productName));
			
			String productPrice = productDescription.getText();

			//			Extracting the price of the product

			double price = Double.parseDouble(productPrice.replaceAll("[^0-9.]", ""));
//			System.out.println(price);
			//			return productDescription;
		}
		catch(TimeoutException e) {
			throw new TimeoutException("Script is not able to execute");
		}
	}

	public int clickingOnTheAddToCartButton() {
		try {
			clickingOnGreyJacketandPricing();
			WebElement addtoCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
			addtoCart.click();
			WebElement checkingAddtoCartVal = wait.until(ExpectedConditions.presenceOfElementLocated(cartValue));
			wait.until(ExpectedConditions.textToBe(cartValue, "(1)"));
			String cartText = checkingAddtoCartVal.getText();
			String countStr = cartText.replaceAll("[^0-9]", "");
			int value = Integer.parseInt(countStr);
//			System.out.println(value);
			return value;
		}
		catch(TimeoutException e) {
			throw new TimeoutException("Element is not present in the DOM");
		}
	}
	
	public Double clickingOnTheCartWindow() {
		try {
			clickingOnTheAddToCartButton();
			driver.navigate().refresh();
			WebElement myCartBtn = wait.until(ExpectedConditions.elementToBeClickable(myCartButton));
			myCartBtn.click();
			WebElement product_description = wait.until(ExpectedConditions.visibilityOfElementLocated(info_productLabel));
			String value = product_description.getText();
			Assert.assertEquals("Grey jacket - Grey jacket - Grey jacket", value.trim());
			WebElement product_price = wait.until(ExpectedConditions.visibilityOfElementLocated(info_priceOfTheItem));
			String product_price_in_String = product_price.getText();
			String only_double_value = product_price_in_String.replaceAll("[^0-9.]","");
			System.out.println(only_double_value);
			double price_value= Double.parseDouble(only_double_value);
			return price_value;
			
		}
		catch(TimeoutException e) {
			throw new TimeoutException ("Element is not finding within the time");
		}
	}
}

