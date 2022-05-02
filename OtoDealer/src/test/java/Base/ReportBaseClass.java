package Base;

import org.apache.commons.mail.EmailException;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Utility.Constants;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
//import org.apache.log4j.xml.DOMConfigurator;
//import DbConnection.connection;
import java.util.Date;
import java.util.Properties;


public class ReportBaseClass {
	
	static Date now = new Date();
	public static String TimeStamp = now.toString().replace(":", "-");
	//protected HomePage homePage;
	public static ExtentReports report;
	public static com.aventstack.extentreports.ExtentTest logger;
	public static ExtentHtmlReporter extent;
	public static FileInputStream fis;
	public static Properties prop;
	protected String email;
	protected String pass;
	public int App_Open=0;
	public static Properties prop1;
	FileInputStream fis1;

	@BeforeSuite
	public void setUpSuite() throws IOException{

		extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+TimeStamp+"Oto_AutomationReport.html"));
		report=new ExtentReports();
		report.attachReporter(extent);

		if(Constants.PlatForm_Name.equals("API")){

			if(Constants.Project_Name.equals("OTO")){

				System.out.println("Rest Assured Project");

				Login login = new Login();
				login.testLogin();
				LoanStockList stock = new LoanStockList();
				stock.getLoanStock();

				//	logger.info("Successful Login and get stock");
			}
		}

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException{
		//System.out.print(result.getStatus());

		if (result.getStatus() == ITestResult.FAILURE) {
			// String screenshotPath= ScreenshotUtility.getScreenshot(driver);
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " Test case FAILED due to below issues:", ExtentColor.RED));

			logger.fail(result.getThrowable());
			//    logger.addScreenCaptureFromPath(screenshotPath);

			//Email.sendEmail();

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(
					Status.PASS,
					MarkupHelper.createLabel(result.getName()
							+ " Test Case PASSED", ExtentColor.GREEN));
		} else {
			logger.log(
					Status.SKIP,
					MarkupHelper.createLabel(result.getName()
							+ " Test Case SKIPPED", ExtentColor.ORANGE));
			//logger.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown(){
		System.out.println("test executed");
	}

	@AfterSuite
	public void EndSuite() throws EmailException{
		report.flush();
		System.out.println("Close ExtentReport");
	}

}