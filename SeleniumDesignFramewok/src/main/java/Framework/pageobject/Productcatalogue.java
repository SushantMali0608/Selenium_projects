package Framework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Framework.Abstractclass.AbstractComponants;

public class Productcatalogue extends AbstractComponants{
	
	WebDriver driver;
	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	 //List <WebElement> products =driver.findElements(By.cssSelector(".col-sm-10"));
    @FindBy(css=".col-sm-10")
    List <WebElement> products;
    
    //driver.findElement(By.cssSelector(".ng-animating"))
    @FindBy(css="\".ng-animating\"")
    WebElement spinner;
    
    
    By productBy=By.cssSelector(".col-sm-10");
    By Addtocart = By.cssSelector(".card-body button:last-child");
    By ToastContainer = By.cssSelector("#toast-container");
    
    public List<WebElement> getproductlist() {
    	waitForElementToAppear(productBy);
    	return products;
    }
    
    public WebElement getProductByname(String productname) {
    	 WebElement prod = getproductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
 				.equals(productname)).findFirst().orElse(null);
    	 return prod;
    	 }
    
   public void Addtocart(String productname) {
	  // prod.findElement(By.cssSelector(".card-body button:last-child")).click();
	   WebElement prod=getProductByname(productname);
	   prod.findElement(Addtocart).click();
	   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	   waitForElementToAppear(ToastContainer);
	   //waitForElementToDisappear(spinner);
	   
	
	   
   }
}













