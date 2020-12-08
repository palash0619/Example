package com.example.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentReports extent; // Environment level details. public ExtentTest
	public ExtentTest logger; // Specify what should be populated in the report. public
	public ExtentHtmlReporter htmlReporter; // Report name and theme

	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String RepName = "Test-Report" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + RepName);
		// Load the Extent report Config file
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		

		htmlReporter.config().setDocumentTitle("Automation Report"); // Title of the Report
		htmlReporter.config().setReportName("Functional Report"); // Name of the Report.
		htmlReporter.config().setTheme(Theme.DARK);

		

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Palash Roy");
		

		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");

		
		/*
		 * logger.log(Status.PASS, "TestCase passed" + result.getName());
		 */
		
		logger = extent.createTest(result.getName());

		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		 

	}

	public void onTestFailure(ITestResult result) {
		/*
		 * logger.log(Status.FAIL,"Testcase Failed"+result.getName()); // to add name to
		 * extent Report
		 * logger.log(Status.FAIL,"Testcase Failed"+result.getThrowable()); //captures
		 * exception in the Report
		 * 
		 * 
		 * try { String screenshotpath= Reporting.getScreenshot(driver,
		 * result.getName()); logger.addScreenCaptureFromPath(screenshotpath); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println("Test Failure");
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

		String screenshotpath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";

		File f = new File(screenshotpath);
		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
		/* logger.log(Status.SKIP, "TestCase Skipped" + result.getName()); */
		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext testContext) {
		 extent.flush(); 
	}

	// Screenshot Method

	/*
	 * public static String getScreenshot(WebDriver driver, String Screenshotname)
	 * throws IOException { String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot ts =
	 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * // After execution create a folder "FailedTestsScreenshot" under src folder
	 * String destination = System.getProperty("user.dir") + "/Screenshots/" +
	 * Screenshotname + dateName + ".png"; File finalDestination = new
	 * File(destination); FileUtils.copyFile(source, finalDestination); return
	 * destination;
	 * 
	 * }
	 */

}
