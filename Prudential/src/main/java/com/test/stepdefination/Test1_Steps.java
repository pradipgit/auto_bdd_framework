package com.test.stepdefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1_Steps {

	WebDriver driver;

	@Given("^I open the application in the browser$")
	public void open_browser() {
		try {
			System.setProperty(
					"webdriver.gecko.driver",
					"C:\\selenium\\Prudential\\src\\test\\resources\\com\\test\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://openweathermap.org");
		} catch (Exception e) {
			System.out.println("Error occured during opening browser: " + e);
		}

	}

	@Then("^I validate entity openweathermap$")
	public void i_validate_label_openweathermap() throws Throwable {
		try {
			Boolean actual = driver
					.findElement(
							By.xpath("//a[@class='navbar-brand']//img[@class='img-responsive']"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}
	}

	@Then("^I validate entity Support Center$")
	public void i_validate_label_Support_Center() throws Throwable {
		try {
			Boolean actual = driver.findElement(
					By.xpath("//a[@class='first-child']")).isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}


	}

	@Then("^I validate entity Sign In$")
	public void i_validate_label_Sign_In() throws Throwable {
		try {
			Boolean actual = driver
					.findElement(
							By.xpath("//a[@class='pull-right'][contains(text(),'Sign In')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);
		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}


	}

	@Then("^I validate entity Sign Up$")
	public void i_validate_label_Sign_Up() throws Throwable {
		try {
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'Sign Up')]")).isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}


	}

	@Then("^I validate entity Weather$")
	public void i_validate_label_Weather() throws Throwable {
		try {
			Boolean actual = driver
					.findElement(
							By.xpath("//a[@class='nav__link bg-hover-color'][contains(text(),'Weather')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Maps$")
	public void i_validate_label_Maps() throws Throwable {
		try {
			Boolean actual = driver
					.findElement(
							By.xpath("//a[@class='nav__link dropdown-toggle bg-hover-color']"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Guide$")
	public void i_validate_label_Guide() throws Throwable {
		try {
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'Guide')]")).isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Search TextBox$")
	public void i_validate_label_search_TextBox() throws Throwable {
		try {
			Boolean actual = driver
					.findElement(
							By.xpath("//div[@class='form-group search-cities__block']//input[@id='q']"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Search Btn$")
	public void i_validate_label_search_btn() throws Throwable {
		try {
			Boolean actual = driver.findElement(
					By.xpath("//button[contains(text(),'Search')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);
		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Weather forecast hourly graphic$")
	public void i_validate_label_weather_graphic() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//*[@class='weather-forecast-hourly-graphic']")));
			Boolean actual = driver.findElement(
					By.xpath("//*[@class='weather-forecast-hourly-graphic']"))
					.isDisplayed();
			Assert.assertEquals(true, actual);
		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity More weather in your city$")
	public void i_validate_label_weather_in_your_city_btn() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			Boolean actual = driver
					.findElement(
							By.xpath("//a[contains(text(),'More weather in your city')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity How to start$")
	public void i_validate_label_how_to_start() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)");
			Boolean actual = driver
					.findElement(
							By.xpath("//a[@class='btn btn-orange owm-agro__btn'][contains(text(),'How to start')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Move to agromonitoring.com$")
	public void i_validate_label_move_to_agr() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
			Boolean actual = driver
					.findElement(
							By.xpath("//a[contains(text(),'Move to agromonitoring.com')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Weather map$")
	public void i_validate_label_weather_map() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)");
			Boolean actual = driver.findElement(
					By.xpath("//h2[@class='owm-weathermap__title']"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Read more$")
	public void i_validate_label_read_more() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'Read more')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity View Solutions$")
	public void i_validate_label_view_sol() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'View solutions')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Try free APIs$")
	public void i_validate_label_try_free_apis() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1100)");
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'Try Free APIs')]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Connect$")
	public void i_validate_label_connect() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");
			Boolean actual = driver.findElement(
					By.xpath("//a[contains(text(),'Connect')]")).isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}

	@Then("^I validate entity Footer$")
	public void i_validate_label_footer() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)");
			Boolean actual = driver.findElement(
					By.xpath("//footer[@class='footer-dark']//p[2]"))
					.isDisplayed();
			Assert.assertEquals(true, actual);

		} catch (Exception e) {
			System.out.println("Error occured due to: " + e);
		}

	}
	
		

}
