package m8_extentreports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reportgen1  {
	  ExtentHtmlReporter htmlReporter;
	  ExtentReports extent;
	  ExtentTest logger;
	  WebDriver driver;
	  
	  @BeforeTest
	  public void startreport() {
		  htmlReporter = new ExtentHtmlReporter("./ExtReports/reportgen1.html");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Host Name", "NextGen Testing 2.0");
		  extent.setSystemInfo("Environment", "Selenium Environment");
		  extent.setSystemInfo("User Name", "Pratikshya");
		  htmlReporter.config().setDocumentTitle("Test Document title Report");
		  htmlReporter.config().setReportName("TestMe App Test Cases Report");
		  htmlReporter.config().setTheme(Theme.STANDARD);
		  
	  }
	  
	  @Test
	  public void testcase01() {
		  logger = extent.createTest("TC_01","pass testcase");
		  Assert.assertEquals(10, 10);
		  
	  }
	  
	  @Test
	  public void logindemoshop() {
		  logger= extent.createTest("TC_01.1", "Starting of the Login page Accessibility");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://demowebshop.tricentis.com/");
		  Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		  logger= extent.createTest("TC_01.2", "Ending of the Login page Accessibility");
		  
	  }
	  @Test
	  public void testcase02() {
		  logger= extent.createTest("TC_02", "Dummy Test to make it fail");
		  Assert.assertEquals(10,20);
		  
	  }
	  
	  @Test(enabled=false)
	  public void testcase03() {
		  logger= extent.createTest("TC_03", "Dummy test to skip the test case");
		  Assert.assertEquals(10,20);
		  
	  }
	  
	  @AfterMethod
	  public void getresulttest(ITestResult result) throws IOException {
		  if(result.getStatus() == ITestResult.FAILURE) {
			  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+
					  "Test case failed******",ExtentColor.RED));
			  TakesScreenshot snapshot =   (TakesScreenshot)driver;
			  File src = snapshot.getScreenshotAs(OutputType.FILE);
			  String Path = System.getProperty("user.dir") +
					  "/test-output/screens/"+result.getName()+".png";
			  FileUtils.copyFile(src, new File(Path));
			  logger.addScreenCaptureFromPath(Path, result.getName());
			  logger.fail(result.getThrowable());
			  
		  }
		  else if(result.getStatus() == ITestResult.SUCCESS) {
			  logger.log(Status.PASS, MarkupHelper.createLabel
					  (result.getName()+" success ", ExtentColor.INDIGO));
			  
		  }
		  else {
			  logger.log(Status.SKIP, MarkupHelper.createLabel
					  (result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			  logger.skip(result.getThrowable());
			  }
		  
	  }
	  @AfterTest
	  public void endreport() {
		  extent.flush();
		  driver.close();
  }
}
