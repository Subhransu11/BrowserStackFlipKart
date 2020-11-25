package com.weatherforecast.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath="//input[@id='LocationSearch_input']")
	WebElement searchBar;
	
	@FindBy(xpath="//button[contains(@id,'LocationSearch_listbox')]")
	List<WebElement> searchResult;
	
	public void serachCity(String city) {
		searchBar.click();
		searchBar.sendKeys(city);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchBar.click();
		for (WebElement cityResult : searchResult) {
			if(cityResult.getText().contains(city)) {
				cityResult.click();
				break;
			}
			else
				System.out.println("City Not Found");
		}
	}
}
