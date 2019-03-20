package com.test.stepdefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2_Steps {
	
	WebDriver driver;
	
	@And("^I enter a city name \"(.*)\"$")
	public void i_enter_city_name(String name) throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//div[@class='form-group search-cities__block']//input[@id='q']")).sendKeys(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("^I Searches for the weather$")
	public void i_searches_for_the_weather() throws Throwable {
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^I Verifies that website suggests city is \"(.*)\"$")
	public void i_city_not_found(String expected) throws Throwable {
		try {
			String alertMsg=(driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText()).toString();
			Assert.assertEquals(expected, alertMsg);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}
	}

}
