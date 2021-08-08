# Automation Behaviour driven development framework

To clone this repository use:  
git clone https://github.com/pradipgit/bdd_automation_jpmorgan.git

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
Project : JPMorgan  
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

### Feature File

#Author: pradip.blr28@gmail.com

@Logo
Feature: Verify J.P.Morgan Logo

  @Positive
  Scenario: Verify J P Morgan logo after searching via google
    Given I browse "https://google.com" website
    Then I search for "J.P.Morgan" key
    And I click on the first result link
    Then I verify "J.P. Morgan logo"


### Step defination 
@When("^I search for \"(.*)\" key$")
	public void searchJPMorgan(String str) {
		try {
			WebElement element = factory.gp.getSearchBoxElement();
			element.sendKeys(str);
			element.submit();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Error occured during opening browser: " + e);
		}

	}

	@And("^I click on the first result link$")
	public void clickFirstResult() {
		try {

			List<WebElement> findElements = factory.gp.getAllSearchResults();

			for (WebElement webElement : findElements) {
				String link = webElement.getAttribute("href");
				if (link.contains("https://www.jpmorgan.com")) {
					webElement.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Not able to identify first result: " + e);
		}
	}

	@Then("^I verify \"(.*)\"$")
	public void verifyLogo(String logo) {

		String logoName = factory.jp.getLogoName();
		Assert.assertEquals(logo, logoName);

	}

### Report  
Navigate to target/cucumber-reports/reports.html  

### CI integration via Jenkin
This is also done , but setup is in local system.

Console Output
Started by user pradip
Running as SYSTEM
Building in workspace C:\Users\personal.jenkins\workspace\BDD
Parsing POMs
Established TCP socket on 39156
[Prudential] $ "C:\Program Files\Java\jdk1.8.0_171/bin/java" -cp C:\Users\personal.jenkins\plugins\maven-plugin\WEB-INF\lib\maven35-agent-1.12.jar;C:\apache-maven-3.6.0\boot\plexus-classworlds-2.5.2.jar;C:\apache-maven-3.6.0/conf/logging jenkins.maven3.agent.Maven35Main C:\apache-maven-3.6.0 C:\Users\personal.jenkins\war\WEB-INF\lib\remoting-3.29.jar C:\Users\personal.jenkins\plugins\maven-plugin\WEB-INF\lib\maven35-interceptor-1.12.jar C:\Users\personal.jenkins\plugins\maven-plugin\WEB-INF\lib\maven3-interceptor-commons-1.12.jar 39156
<===[JENKINS REMOTING CAPACITY]===>channel started
Executing Maven: -B -f C:\selenium\Prudential\pom.xml clean install
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< Prudential:Prudential >------------------------
[INFO] Building Prudential 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Prudential ---
[INFO] Deleting C:\selenium\Prudential\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Prudential ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\selenium\Prudential\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Prudential ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 4 source files to C:\selenium\Prudential\target\classes
[INFO] [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Prudential ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] [INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ Prudential ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ Prudential ---
[JENKINS] Recording test results[WARNING] Attempt to (de-)serialize anonymous class hudson.maven.reporters.BuildInfoRecorder$1; see: https://jenkins.io/redirect/serialization-of-anonymous-classes/

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ Prudential ---
[INFO] Building jar: C:\selenium\Prudential\target\Prudential-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ Prudential ---
[INFO] Installing C:\selenium\Prudential\target\Prudential-0.0.1-SNAPSHOT.jar to C:\Users\personal.m2\repository\Prudential\Prudential\0.0.1-SNAPSHOT\Prudential-0.0.1-SNAPSHOT.jar
[INFO] Installing C:\selenium\Prudential\pom.xml to C:\Users\personal.m2\repository\Prudential\Prudential\0.0.1-SNAPSHOT\Prudential-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.181 s
[INFO] Finished at: 2019-03-20T17:19:09+05:30
[INFO] ------------------------------------------------------------------------
Waiting for Jenkins to finish collecting data
[JENKINS] Archiving C:\selenium\Prudential\pom.xml to Prudential/Prudential/0.0.1-SNAPSHOT/Prudential-0.0.1-SNAPSHOT.pom
[JENKINS] Archiving C:\selenium\Prudential\target\Prudential-0.0.1-SNAPSHOT.jar to Prudential/Prudential/0.0.1-SNAPSHOT/Prudential-0.0.1-SNAPSHOT.jar
channel stopped
Finished: SUCCESS


