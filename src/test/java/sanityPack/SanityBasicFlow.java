package sanityPack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import myFramework.BaSE.BaseMethods;
import myFramework.page.DashBoard;
import myFramework.page.HomePageArticles;
import myFramework.page.PaymentFLow;
import myFramework.page.SignUpandLoginDetails;

public class SanityBasicFlow extends BaseMethods{

	@Test(enabled =false)
	public void redirectingToTheUrl() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test (enabled = false)
	public void clickingOnTheSeachBar() {
		DashBoard d = new DashBoard(wait);
		d.clickingSearchNav();
		System.out.println();
		Assert.assertEquals(driver.getTitle(), "Search – Sauce Demo","Title doesn't match");
	}
	
	@Test (enabled = false)
	public void clickingOnTheAboutUs() {
		DashBoard d = new DashBoard(wait);
		d.aboutUsNav();
		System.out.println();
		Assert.assertEquals(driver.getTitle(), "About Us – Sauce Demo","Title doesn't match");
	}
	
	@Test (enabled = false)
	public void clickingOnTheSignUp() {
		DashBoard d = new DashBoard(wait);
		d.signUpNav();
		System.out.println();
		Assert.assertEquals(driver.getTitle(), "Create Account – Sauce Demo","Title doesn't match");
	}	
	
	@Test (enabled = true)
	public void gettingTheElementsPresentInTheSidebar() {
		DashBoard d = new DashBoard(wait);
		HashMap<WebElement, String> mapq = new HashMap<>();
		List<WebElement> e = d.getSearchResults();
		for(WebElement el : e) {
			mapq.put(el, el.getText());
		}
		for(Map.Entry<WebElement, String>entries : mapq.entrySet()) {
			System.out.println(entries.getKey()+ ": "+ entries.getValue());
		}
	}
	
	@Test
	public void enteringInTheSearchField() {
		DashBoard d = new DashBoard(wait);
		d.searchfield("T-shirts");
	}
	
	@Test
	public void gettingDisplayedItems() {
		HomePageArticles ar = new HomePageArticles(driver, wait);
		List<WebElement> article  = ar.multiple_Articles();
		for(WebElement air: article) {
			System.out.println(air.getText());
		}
	}
	
	@Test (groups= "Regression")
	public void gettingGreyJacketWindow() {
		HomePageArticles a = new HomePageArticles(driver, wait);
		int value = a.clickingOnTheAddToCartButton();
		Assert.assertEquals(value, 1);
	}
	
	@Test (groups= "Regression")
	public void gettingMyCartBtn() {
		HomePageArticles a = new HomePageArticles(driver,wait);
		double price_value = a.clickingOnTheCartWindow();
		Assert.assertEquals(price_value, 55.0);
	}
	
	@Test (groups = "Regression")
	public void clickingOnCheckOutBtn() {
		HomePageArticles a = new HomePageArticles(driver,wait);
		a.clickingOnTheCartWindow();
		PaymentFLow p = new PaymentFLow(driver,wait);
		String title = p.checkOutBtnClicked();
		Assert.assertEquals("Your Shopping Cart – Sauce Demo", title);
	}
	
	@Test
	public void clickingOnTheCheckoutBtnAtCheckoutPage() {
		HomePageArticles a = new HomePageArticles(driver,wait);
		a.clickingOnTheCartWindow();
		PaymentFLow p = new PaymentFLow(driver,wait);
		String title = p.checkOutBtnClickedOnTheCheckOutPage();
		Assert.assertEquals(title, "Checkout - Sauce Demo");
//		Checkout - Sauce Demo
	}
	
	@Test
	public void signUpFunctionality() {
		SignUpandLoginDetails signUp = new SignUpandLoginDetails(driver,wait);
		signUp.clickOntheSignUpPageAndCreateAnAccount();
	}
}
