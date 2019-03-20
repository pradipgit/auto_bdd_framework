package com.test.stepdefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test3_Steps {
	
	WebDriver driver;
	
		
	@Then("^I verifies that website successfully returns weather details for the city \"(.*)\"$")
	public void i_found(String expected) throws Throwable {
		try {
			String alertMsg=(driver.findElement(By.xpath("//a[contains(text(),'Bangalore, IN')]")).getText()).toString();
			Assert.assertEquals(expected, alertMsg);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}
	}

}
