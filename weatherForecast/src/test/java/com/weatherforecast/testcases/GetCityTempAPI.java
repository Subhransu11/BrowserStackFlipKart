package com.weatherforecast.testcases;

import org.testng.annotations.Test;

import com.weatherforecast.apis.TempAPI;


public class GetCityTempAPI {

	TempAPI ta = new TempAPI();
	
	@Test
	public int getCityTempAPI(String city, String apiID) {
		Float temp = ta.tempAPI("Delhi", "40c896c78b2f3b04ae37bf8699dc07a1");
		System.out.println("Temperature from API is : " + temp + " K");
		int tempC = (int) (temp - 273);
		System.out.println("Temperature from API is : " + tempC + " C");		
		return tempC;
	}
	
}
