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
	public int searchCityTemp(WebDriver driver, String browserName, String url, String city) {
		driver = bf.startBrowser(driver, browserName, url);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.serachCity(city);
		WeatherPage WP = PageFactory.initElements(driver, WeatherPage.class);
		String temp = WP.getTemperature(city);
		String tempAPP = temp.replaceAll("°", "");
		int tempA = Integer.parseInt(tempAPP);
		System.out.println(tempA);
		bf.closeBrowser(driver);
		return tempA;
	}

}
