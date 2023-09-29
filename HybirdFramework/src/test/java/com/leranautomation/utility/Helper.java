package com.leranautomation.utility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String capturedscreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Screenshot=System.getProperty("user.dir"+"/Screenshot/OPenHRM_"+getcurrentdate()+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File(Screenshot));
		} catch (Exception e) {
			System.out.println("Unable tocapture screenshot " + e.getMessage());
		}
		return Screenshot;

	}

	public static String ScreenshotbyRobot(WebDriver driver) {

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		
		String screenshot=System.getProperty("user.dir")+"/Screenshot/OpenHRM_"+getcurrentdate()+".png";
		File file = new File(screenshot);
		
		try {
			ImageIO.write(bufferedImage, screenshot, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshot;
	}

	public static String getcurrentdate() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_");
		Date date = new Date();
		return format.format(date);

	}
}
