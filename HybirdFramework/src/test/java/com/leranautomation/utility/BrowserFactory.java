package com.leranautomation.utility;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	static WebDriver driver;
    static	ExtentTest Testcase;

	public static WebDriver StartApplication(WebDriver driver, String Url, String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//Testcase.log(Status.PASS, "Driver got successfully");
			//String title = driver.getTitle();
			//Testcase.log(Status.INFO, "Actual title :" + title);
			//Testcase.log(Status.INFO, "Expected title :" + "GooGleChrome");

		} else if (BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Testcase.log(Status.PASS, "Driver got successfully");

		} else if (BrowserName.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			Testcase.log(Status.PASS, "Driver got successfully");
		} else {
			Testcase.log(Status.FAIL, "Driver not successfully");
		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
