package com.leranautomation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configdataprovider {

	public Properties properties;

	public Configdataprovider() {

		try {
			FileInputStream fileInputStream = new FileInputStream("./Config/config.properties");

			properties = new Properties();
			properties.load(fileInputStream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load file " + e.getMessage());
		}

	}

	public void datafromconfig() {
		//return properties.getProperty("QAUrl");
	}

	public String geturl() {
		return properties.getProperty("QAUrl");
	}

	public String getbrowser() {
		return properties.getProperty("Browser");
	}
}
