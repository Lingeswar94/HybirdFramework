package com.leranautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	 WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(name = "username")
	public static WebElement uname;

	@FindBy(name = "password")
	public static WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement Loginbutton;

	public void logintoHRM(String username, String Pass) {
		uname.sendKeys(username);
		password.sendKeys(Pass);
		Loginbutton.click();
	}
}
