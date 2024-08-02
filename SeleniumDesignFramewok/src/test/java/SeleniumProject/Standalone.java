package SeleniumProject;

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

import Framework.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String productname ="ZARA COAT 3";
		 driver.get("https://rahulshettyacademy.com/client");
		 driver.findElement(By.id("userEmail")).sendKeys("sushant123456@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Morya@123");
		 driver.findElement(By.id("login")).click();
		 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-sm-10")));
		 List <WebElement> products =driver.findElements(By.cssSelector(".col-sm-10"));
		 //to print text
		// WebElement prod = products.stream().map(product->product.findElement(By.cssSelector("b"))).findFirst().orElse(null);
		//	prod.getText();
			//System.out.println(prod);
		 
		 WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productname)).findFirst().orElse(null);
		 
		  prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		  driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		  
		  List <WebElement> cartproducts =driver.findElements(By.xpath("//div[@class ='cartSection']/h3"));
		 Boolean match = cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		  Assert.assertTrue(match);
		  
		  driver.findElement(By.cssSelector(".totalRow button")).click();
		  Actions a = new Actions(driver);
		  a.sendKeys(driver.findElement(By.cssSelector("input[placeholder ='Select Country']")),"india").build().perform();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		  
		  driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		  driver.findElement(By.cssSelector(".action__submit")).click();
		  
		  String confirmedmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		   Assert.assertTrue(confirmedmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		   driver.close();
		  
		  
	 
		 
		 
		
		
		

	}

}
