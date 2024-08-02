package SeleniumProject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import Framework.pageobject.CartPage;
import Framework.pageobject.CheckoutPage;
import Framework.pageobject.ConfirmationPage;
import Framework.pageobject.LandingPage;
import Framework.pageobject.Productcatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorMessageValidationTest extends BaseTest {
	
@Test
        public void LoginerrorValidation() throws IOException {
		 landingpage.Loginapplication("sushant123456@gmail.com", "Mor999ya@123");
		 String Errormessage=landingpage.getErrorMessage();
		 Assert.assertEquals("Incorrect email or password.", Errormessage);
		 
  	 
		   
		   
		  
		  
        }
		 
@Test
public void ProducterrorValidation() throws IOException {
String productname ="ZARA COAT 3";
 Productcatalogue productcatalogue=landingpage.Loginapplication("sushant123456@gmail.com", "Morya@123");
   List<WebElement> products =productcatalogue.getproductlist();
   productcatalogue.Addtocart(productname);
   CartPage cartpage=productcatalogue.clickOnCart();
   Boolean match =cartpage.VerifyProductDisplay("Zara COAT 33");
  Assert.assertFalse(match);
		
		
}	

	}


