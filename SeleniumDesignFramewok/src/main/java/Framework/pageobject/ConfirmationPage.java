package Framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Abstractclass.AbstractComponants;

public class ConfirmationPage extends AbstractComponants {
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
		@FindBy(css=".hero-primary")
		WebElement confirmedmessage;
		
		public String confirmedmessage() {
			return confirmedmessage.getText();
		}
}
