package com.weatherforecast.apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TempAPI {

	
	// API ID - 40c896c78b2f3b04ae37bf8699dc07a1
	
	public Float tempAPI(String city, String apiID) {

		Float temp;
		Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiID);
		System.out.println(resp.statusCode());
		System.out.println(resp.getBody().asString());
		temp = resp.jsonPath().get("main.temp");
		System.out.println(temp);
		return temp;
	}
}
