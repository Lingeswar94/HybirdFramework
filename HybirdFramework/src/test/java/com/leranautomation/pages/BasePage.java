package com.leranautomation.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.leranautomation.utility.BrowserFactory;
import com.leranautomation.utility.Configdataprovider;
import com.leranautomation.utility.ExcelProvider;
import com.leranautomation.utility.Helper;

public class BasePage {

	public static WebDriver driver;
	public ExcelProvider excelProvider;
	public Configdataprovider config;
	public static ExtentReports reports;
	public static	ExtentHtmlReporter html;
	public static ExtentTest Testcase;
	public static ExtentSparkReporter extentSparkReporter;

	@AfterMethod
	public void TearDownmethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			
				try {
					Testcase.fail("TestFailed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturedscreenshot(driver)).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(result.getStatus()==ITestResult.SUCCESS) {
				
				try {
					Testcase.pass("TestPassed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenshotbyRobot(driver)).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					Testcase.skip("Testshiped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenshotbyRobot(driver)).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	@BeforeSuite
	public void excelsetup() {
		excelProvider = new ExcelProvider();
		config = new Configdataprovider();
		reports = new ExtentReports();
		//ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
		 ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./Reports/Extent+"+Helper.getcurrentdate()+".html");
		reports.attachReporter(htmlReporter);
	}
	@BeforeClass
	public void OpenApp() {
		driver = BrowserFactory.StartApplication(driver, config.geturl(), config.getbrowser());
		System.out.println(driver.getTitle());
	}
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
		reports.flush();
	}

}
