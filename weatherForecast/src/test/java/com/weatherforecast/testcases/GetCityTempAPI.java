package com.weatherforecast.testcases;

import org.testng.annotations.Test;

import com.weatherforecast.apis.TempAPI;


public class GetCityTempAPI {

	TempAPI ta = new TempAPI();
	
	@Test
	public void getCityTempAPI() {
		Float temp = ta.tempAPI("Delhi", "40c896c78b2f3b04ae37bf8699dc07a1");
		System.out.println("Temperature from API is : " + temp + " K");
		Float tempC = temp-273;
		System.out.println("Temperature from API is : " + tempC + " C");
	}
	
}
