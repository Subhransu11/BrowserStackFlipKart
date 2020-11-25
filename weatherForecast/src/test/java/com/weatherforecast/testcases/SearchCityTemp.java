package com.weatherforecast.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weatherforcast.utilities.BrowserFactory;
import com.weatherforecast.pages.HomePage;
import com.weatherforecast.pages.WeatherPage;

public class SearchCityTemp {
	public WebDriver driver;
	BrowserFactory bf = new BrowserFactory();

	@Test
	public void searchCityTemp() {
		driver = bf.startBrowser(driver, "Chrome", "https://weather.com/");
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.serachCity("Bhubaneswar");
		WeatherPage WP = PageFactory.initElements(driver, WeatherPage.class);
		String temp = WP.getTemperature("Bhubaneswar");
		System.out.println(temp);
		bf.closeBrowser(driver);
	}

}
