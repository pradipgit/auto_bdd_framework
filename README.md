# Automation Behaviour driven development framework
---------------------------
To clone this repository use:  
git clone https://github.com/pradipgit/auto_bdd_framework.git

### Features
1.Useful for develop GUI automation   
2.Behaviour driven test automation using Cucumber/Gherkin language   
3.Maven based project  
4.JUnit is used  
5.Enabled report extending build in plugin  
6.Commandline execution 

### How to Run
mvn clean test -Dcucumber.options="src/test/java/com/test/features"  
or  
From Eclipse:   
Run as Unit test providing below details:  
Project : Prudential  
Test class: com.test.runner.RunnerTest  

### Examples:

### Runner
@RunWith(Cucumber.class)  
@CucumberOptions(features = "src/test/java/com/test/features", glue = "com.test.stepdefination",   
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)  
public class RunnerTest {  
	@AfterClass  
	public static void writeExtentReport() {  
		Reporter.loadXMLConfig(new File("config/report.xml"));  
	}  
}  

### Step defination 
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

### Feature File

#Author: pradip.blr28@gmail.com  

@tag  
Feature: Verify all important information in the page  

  @label  
  Scenario Outline: Verifies that all important information is there, e.g.  labels etc  
    Given I open the application in the browser  
    Then I validate entity <name>          
    Examples:   
      | name  |  
      | openweathermap |  
      | Support Center |    
      | Sign In |  
      | Sign Up |  
      | Weather |  
      | Maps | 
      | Guide |  
      | Search TextBox |

### Report  
Navigate to target/cucumber-reports/reports.html  
