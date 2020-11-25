package com.weatherforecast.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherPage {

	public WebDriver driver;

	public WeatherPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//h1[contains(@class,'CurrentConditions')]") WebElement cityTitle;
	@FindBy(xpath = "//span[contains(@class,'CurrentConditions') and contains(@data-testid,'TemperatureValue')]") WebElement temperature;

	public String getTemperature(String city) {
		String temperature_value = null;
		if(cityTitle.getText().contains(city)) {
			temperature_value = temperature.getText();
			System.out.println("Temperature of " + city + " is : " + temperature_value);
		}
		else {
			System.out.println("No such City found");
		}
		
		return temperature_value;		
	}
}
