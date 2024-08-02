package BasePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest Test;
	ExtentReports extents = ExtentReporterNG.config();
	private ExtentTest screenCaptureFromPath;
	@Override
	public void onTestStart(ITestResult result) {
	    // not implemented
		Test = extents.createTest(result.getMethod().getMethodName());
	  }
     @Override
	 public void onTestSuccess(ITestResult result) {
	    // not implemented
    	 Test.log(Status.PASS, "TestPassed");
	  }
     @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
    	 Test.fail(result.getThrowable());
    	 
    	 try {
			driver=  (WebDriver) result.getTestClass().getRealClass().getField("driver").
					 get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	
    	 String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
         
		}
	  }

     @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

     @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

     @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
     @Override
	 
	  public void onStart(ITestContext context) {
	    // not implemented
	  }
     @Override
	  public void onFinish(ITestContext context) {
	    // not implemented
    	 extents.flush();
	  }

}
