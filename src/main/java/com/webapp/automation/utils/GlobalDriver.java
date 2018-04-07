package com.webapp.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GlobalDriver {
	
	private static final ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<WebDriver>();
			
	private GlobalDriver(){}; //Cannot be instantiated
	
	private static GlobalDriver instance = new GlobalDriver();
	
	public GlobalDriver getInstance(){
		return instance;
	}
	
	public static void createDriver(String browser){
		
		WebDriver driver = null;
		
		switch(browser){
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			case "Chrome":
				driver = new ChromeDriver();
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	public static WebDriver getDriver() {
	return (WebDriver) threadLocalWebDriver.get();
	}

	private static void setDriver(WebDriver driver) {
	threadLocalWebDriver.set(driver);
	}

	public static void unset() {
	threadLocalWebDriver.remove();
	}

	public static void destroyLocalDriver(){
	if (getDriver() != null) {
		getDriver().quit();
		}
	else {
		System.out.println("Not Destroyed ...is NULL ...!");
		}
	}
		
}
