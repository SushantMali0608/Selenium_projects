package SeleniumProject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import Framework.pageobject.CartPage;
import Framework.pageobject.CheckoutPage;
import Framework.pageobject.ConfirmationPage;
import Framework.pageobject.LandingPage;
import Framework.pageobject.OrderPage;
import Framework.pageobject.Productcatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestorderTest extends BaseTest {
	String productname = "ZARA COAT 3";

	@Test(dataProvider = "getdata", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException {
		Productcatalogue productcatalogue = landingpage.Loginapplication(input.get("Email"), input.get("Password"));
		List<WebElement> products = productcatalogue.getproductlist();
		productcatalogue.Addtocart(productname);
		CartPage cartpage = productcatalogue.clickOnCart();
		Boolean match = cartpage.VerifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkout = cartpage.goToCheckout();
		checkout.selectCountry("India");
		ConfirmationPage confirmationPage = checkout.submitOrder();
		String confirmedmessage = confirmationPage.confirmedmessage();
		Assert.assertTrue(confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "SubmitOrder" })

	public void Order() {
		Productcatalogue productcatalogue = landingpage.Loginapplication("sushant123456@gmail.com", "Morya@123");
		OrderPage orderpage = productcatalogue.ClickonOrder();
		Assert.assertTrue(orderpage.VerifyProductList(productname));

	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		List<HashMap<String, String>> data = getJsonDataTMap("D:\\eclipse-workspace\\SeleniumDesignFramewok\\src\\test\\java\\Input\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	// by using array
	// return new Object[][]
	// {{"sushant123456@gmail.com","Morya@123"},{"sushantmali@gmail.com","susha@123"}};

	// passing data by creating hashmap
//   HashMap<String,String> Map = new HashMap<String,String>();
//   Map.put("Email", "sushant123456@gmail.com");
//   Map.put("Password","Morya@123");
//   HashMap<String,String> Map1 = new HashMap<String,String>();
//   Map1.put("Email", "sushantmali@gmail.com");
//   Map1.put("Password","susha@123");

}
