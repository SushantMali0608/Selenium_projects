package Framework.Abstractclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.pageobject.CartPage;
import Framework.pageobject.OrderPage;

public class AbstractComponants {
	
	WebDriver driver;
	public AbstractComponants(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	 @FindBy(css="button[routerlink*='cart']")
	 WebElement cartheader;
	 @FindBy(css="[routerlink='/dashboard/myorders']")
	 WebElement Orderheader;

	public void waitForElementToAppear(By findby) {
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForWebElementElementToAppear(WebElement findby) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
		
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage clickOnCart() {
		cartheader.click();
		 CartPage cartpage= new CartPage(driver);
		   return cartpage;
		
		
	}
	public OrderPage ClickonOrder() {
		Orderheader.click();
		
		OrderPage orderpage= new OrderPage(driver);
		return orderpage;
		
	}
	

}
