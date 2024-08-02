package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	 public WebDriver driver;
	 public LandingPage landingpage;
	
	public WebDriver BrowserInitialisation() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//global.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String browser= System.getProperty("Browser")!=null?System.getProperty("Browser"):prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
	         WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
	         
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			//Firefoxcode
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
		
		
	}
	
	public List<HashMap<String,String>> getJsonDataTMap(String filePath) throws IOException {
		// convetinf json data to string
	String JsonContent=	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
	//Converting string to hashmp
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference <List<HashMap<String,String>>>(){});
	
	return data;
}
	
	public String getScreenshot(String TestcaseName , WebDriver driver) throws IOException {
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file = new File("//eclipse-workspace//SeleniumDesignFramewok//reports//" + TestcaseName + ".png");
		FileUtils.copyFile(source,file);
		return "//eclipse-workspace//SeleniumDesignFramewok//reports//" + TestcaseName + ".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException {
		
		driver = BrowserInitialisation();
		landingpage =new LandingPage(driver);
		landingpage.Goto();
		return landingpage;
	}
	
   @AfterMethod(alwaysRun=true)
   
   public void Teardown() {
	   driver.close();
   }

}
