package com.google.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static ConfigPage config;

	public static void start(String browser) {

		config = new ConfigPage();
		if (browser.equalsIgnoreCase("chrome")) {
			String chromePath = config.getChromepath();
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
			driver= new FirefoxDriver();
					}
		else {
			throw new RuntimeException("please chose chrome or firefox for your driver");
		}
		
		driver.manage().timeouts().implicitlyWait(config.getImplisiveWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(config.getPageloadWait(), TimeUnit.SECONDS);
		driver.get(config.getURL());
			
	}
	
	public void tearDown() {
		driver.close();
	}

}
