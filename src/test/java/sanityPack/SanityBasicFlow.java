package sanityPack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import myFramework.BaSE.BaseMethods;
import myFramework.page.DashBoard;

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
}
