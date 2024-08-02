package Framework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Abstractclass.AbstractComponants;

public class CheckoutPage extends AbstractComponants{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//By.cssSelector("input[placeholder ='Select Country']")
	@FindBy(css="input[placeholder ='Select Country']")
	WebElement Input;
	
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement Country;
	
	//  driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement Submit;
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css=".hero-primary")
	WebElement confirmedmessage;
	
	public void selectCountry(String countryName) {
		 Actions a = new Actions(driver);
		  a.sendKeys(Input,countryName).build().perform();
		 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		  
		  Country.click();
		  Submit.click();
	}
	
	public ConfirmationPage submitOrder() {
		
		Submit.click();
		ConfirmationPage confirmationPage =new ConfirmationPage(driver);
		return confirmationPage;
		
		
	}

}
