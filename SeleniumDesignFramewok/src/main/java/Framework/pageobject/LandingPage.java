package Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Abstractclass.AbstractComponants;

public class LandingPage extends AbstractComponants {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.id("userEmail")).sendKeys("sushant123456@gmail.com");
	
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	 //driver.findElement(By.id("userPassword")).sendKeys("Morya@123");
	
	@FindBy(id="userPassword")
	WebElement Userpassword;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement Login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Errormessage;
	
	public Productcatalogue Loginapplication(String username ,String pssword){
		UserEmail.sendKeys(username);
		Userpassword.sendKeys(pssword);
		Login.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
		
		
		
	}
	public void Goto()
	{
	driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForWebElementElementToAppear(Errormessage);
		return Errormessage.getText();
	}

}
