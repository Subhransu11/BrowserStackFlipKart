package com.weatherforcast.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public WebDriver startBrowser(WebDriver ldriver, String browserName, String appUrl) { 
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");			
			ChromeOptions capabilities = new ChromeOptions();
			capabilities.setCapability("EnableNativeEvents", false);
		    capabilities.setCapability("ignoreZoomSetting", true);
		    ldriver = new ChromeDriver(capabilities);
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecho.driver", ".//Drivers//geckodriver.exe");			
			DesiredCapabilities capabilities  = DesiredCapabilities.firefox();
			capabilities.setCapability("EnableNativeEvents", false);
		    capabilities.setCapability("ignoreZoomSetting", true);
		    ldriver = new FirefoxDriver(capabilities);
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriverServer.exe");			
			DesiredCapabilities capabilities  = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("EnableNativeEvents", false);
		    capabilities.setCapability("ignoreZoomSetting", true);
		    ldriver = new InternetExplorerDriver(capabilities);
		}
		else 
			System.out.println("Browser not supported");
		
		
		ldriver.manage().window().maximize();
		ldriver.get(appUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ldriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		return ldriver;
	}
	
	public void closeBrowser(WebDriver ldriver) {
		ldriver.close();
	}
	
}
