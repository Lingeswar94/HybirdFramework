package com.leranautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.leranautomation.pages.BasePage;
import com.leranautomation.pages.LoginPage;
import com.leranautomation.utility.BrowserFactory;
import com.leranautomation.utility.ExcelProvider;
import com.leranautomation.utility.Helper;

public class LoginTestCRM extends BasePage {

	@Test
	public void loginApp() {

		System.out.println("Driver :"+driver);
		
		ExcelProvider excelProvider = new ExcelProvider();

		Testcase = reports.createTest("Login to OprnHRM");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		Testcase.info("Starting Appilcation");
		loginPage.logintoHRM(excelProvider.getStringdata("Login", 2, 0), excelProvider.getStringdata("Login", 2, 1));
		
		// Helper.capturedscreenshot(driver);

	}

}
   