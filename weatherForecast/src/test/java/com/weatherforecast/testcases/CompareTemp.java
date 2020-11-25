package com.weatherforecast.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.weatherforcast.utilities.BrowserFactory;
import com.weatherforcast.utilities.ExcelUtility;
import com.weatherforecast.apis.TempAPI;
import com.weatherforecast.pages.HomePage;
import com.weatherforecast.pages.WeatherPage;

public class CompareTemp {

	public WebDriver driver;
//	BrowserFactory bf = new BrowserFactory();
//	TempAPI ta = new TempAPI();
	ExcelUtility EU = new ExcelUtility();
	GetCityTempAPI TempAPI = new GetCityTempAPI();
	SearchCityTemp TempAPP = new SearchCityTemp();

	@DataProvider(name = "Temperature")
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = EU.readExcel();
		return (testObjArray);
	}

	@Test(dataProvider = "Temperature")
	public void compareTemp(String City) {		
		String city = City;
		String apiID = "40c896c78b2f3b04ae37bf8699dc07a1";
		String url = "https://weather.com/";
		String browserName = "Chrome";
//		Float temp = ta.tempAPI(city, apiID);
//		int tempC = (int) (temp - 273);
		int tempC = TempAPI.getCityTempAPI(city, apiID);
		System.out.println("Temperature from API is : " + tempC + " C");
//		driver = bf.startBrowser(driver, "Chrome", "https://weather.com/");
//		HomePage hp = PageFactory.initElements(driver, HomePage.class);
//		hp.serachCity(city);
//		WeatherPage WP = PageFactory.initElements(driver, WeatherPage.class);
//		String tempAPP = WP.getTemperature(city);
		int tempA = TempAPP.searchCityTemp(driver, browserName, url, city);
		int diff = tempC - tempA;
		diff = (diff < 0) ? -diff : diff;
		System.out.println("Difference between temperature from Application and API is : " + diff);

		if (diff < 3) {
			System.out.println("Difference is negligible --> ");
		} else {
			System.out.println("Diffence is there between temperatures from both sources");
		}

	}
}
