package com.juaracoding.demoqamix;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.demoqamix.drivers.DriverSingleton;
import com.juaracoding.demoqamix.pages.CheckOutPage;
import com.juaracoding.demoqamix.pages.LoginPage;
import com.juaracoding.demoqamix.pages.LogoutPage;
import com.juaracoding.demoqamix.pages.RegisPage;
import com.juaracoding.demoqamix.pages.SearchPage;
import com.juaracoding.demoqamix.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
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
		driver.get(Constants.URL);	
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
