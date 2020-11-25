package com.weatherforecast.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Properties;

import com.weatherforcast.utilities.ExcelUtility;
import com.weatherforcast.utilities.ReadProperty;

public class CompareTemp {

	public WebDriver driver;
	Properties propConfig;
	ReadProperty RP = new ReadProperty();
	ExcelUtility EU = new ExcelUtility();
	GetCityTempAPI TempAPI = new GetCityTempAPI();
	SearchCityTemp TempAPP = new SearchCityTemp();

	@BeforeClass
	public void setUp() {
		propConfig = RP.readConfig();
	}
	
//	Input from Excel -> External Files>>WeatherForecast.xlsx
	@DataProvider(name = "Temperature")
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = EU.readExcel();
		return (testObjArray);
	}

	@Test(dataProvider = "Temperature")
	public void compareTemp(String City) {		
		String city = City;
		String apiID = propConfig.getProperty("ApiID");
		String url = propConfig.getProperty("URL");
		String browserName = propConfig.getProperty("BrowserName");
		
//		call function to get temperature of city from API
		int tempC = TempAPI.getCityTempAPI(city, apiID);
		System.out.println("Temperature from API is : " + tempC + "°C");
		
//		call function to get temperature of city from Weather Application
		int tempA = TempAPP.searchCityTemp(driver, browserName, url, city);
		System.out.println("Temperature from Application is : " + tempA + "°C");
		
		int diff = tempC - tempA;
		diff = (diff < 0) ? -diff : diff;
		System.out.println("Difference between temperature from Application and API is : " + diff);

		int diffLimit = 3;
		if (diff < diffLimit) {
			System.out.println("Difference is negligible --> ");
			
		} else {
			System.out.println("Diffence is there between temperatures from both sources");
		}

	}
}
