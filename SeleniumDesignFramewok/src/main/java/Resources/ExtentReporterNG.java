package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports config() {
		String Path =System.getProperty("user.dir") +"//testing//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Path); 
		reporter.config().setReportName("Automation test");
		reporter.config().setDocumentTitle("Test case");
		
		ExtentReports extents =new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("tester", "Sushant mali");
		return extents;
	}

}
