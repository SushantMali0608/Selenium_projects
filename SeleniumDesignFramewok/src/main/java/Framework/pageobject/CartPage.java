package Framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Abstractclass.AbstractComponants;

public class CartPage extends AbstractComponants {
	
	WebDriver driver;
	//driver.findElements(By.xpath("//div[@class ='cartSection']/h3"));
		@FindBy(xpath="//div[@class ='cartSection']/h3")
		List <WebElement> cartproducts;
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		@FindBy(css=".totalRow button")
		WebElement Checkout;
		
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String productname) {
		 Boolean match = cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		 return match;
		
	}
	public CheckoutPage goToCheckout() {
		Checkout.click();
		CheckoutPage checkoutpage= new CheckoutPage(driver);
		return checkoutpage;
	}
	

	

}
