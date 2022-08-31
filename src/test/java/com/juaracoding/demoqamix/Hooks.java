package com.juaracoding.demoqamix;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.demoqamix.drivers.DriverSingleton;
import com.juaracoding.demoqamix.pages.CheckOutPage;
import com.juaracoding.demoqamix.pages.LoginPage;
import com.juaracoding.demoqamix.pages.LogoutPage;
import com.juaracoding.demoqamix.pages.RegisPage;
import com.juaracoding.demoqamix.pages.SearchPage;
import com.juaracoding.demoqamix.utils.Constants;
import com.juaracoding.demoqamix.utils.TestScenarios;
import com.juaracoding.demoqamix.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	public static ExtentTest extentTest;
	public static ExtentReports reports = new ExtentReports("target/extent-reports.html");
	
	private SearchPage searchPage = new SearchPage();
	private RegisPage regisPage = new RegisPage();
	private LoginPage loginPage = new LoginPage();
	private CheckOutPage checkOutPage = new CheckOutPage();
	private LogoutPage logoutPage = new LogoutPage();
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		regisPage = new RegisPage();
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		checkOutPage = new CheckOutPage();
		logoutPage = new LogoutPage();
		
		driver = DriverSingleton.getDriver();
		TestScenarios[] tests = TestScenarios.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultStatus(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
					+extentTest.addScreenCapture(screenshotPath));
		}
	}
	
	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void closeBrowser() {
		delay(2);
		DriverSingleton.closeObjectInstance();
	}
	
	public static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
}
