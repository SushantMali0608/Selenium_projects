package Framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Abstractclass.AbstractComponants;

public class OrderPage extends AbstractComponants {
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="tr td:nth-child(3)")
	public List<WebElement>ProductList;
	
	public Boolean VerifyProductList(String productname) {
		 Boolean match = ProductList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		 return match;
		
	}

	

}
