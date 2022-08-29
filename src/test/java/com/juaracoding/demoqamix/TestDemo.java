package com.juaracoding.demoqamix;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.juaracoding.demoqamix.drivers.DriverSingleton;
import com.juaracoding.demoqamix.pages.CheckOutPage;
import com.juaracoding.demoqamix.pages.LoginPage;
import com.juaracoding.demoqamix.pages.LogoutPage;
import com.juaracoding.demoqamix.pages.RegisPage;
import com.juaracoding.demoqamix.pages.SearchPage;
import com.juaracoding.demoqamix.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDemo {

	public static WebDriver driver;
	private SearchPage searchPage;
	private RegisPage regisPage;
	private LoginPage loginPage;
	private CheckOutPage checkOutPage;
	private LogoutPage logoutPage;

	@Before
	public void setup() {
		DriverSingleton.getInstance(Constants.CHROME);
		regisPage = new RegisPage();
		loginPage = new LoginPage();
		searchPage = new SearchPage(driver);
		checkOutPage = new CheckOutPage();
		logoutPage = new LogoutPage();
		
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@After
	public void closeBrowser() {
		delay(3);
//		driver.quit();
//		DriverSingleton.closeObjectInstance();
	}
	
	//tag1
	@Given("User go to Web DemoQA and click myAcc")
	public void user_go_to_Web_DemoQA_click_myAcc() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		scroll(200);
		regisPage.myAcc();
	}
	
	@When("User enter username email password regis") 
	public void user_enter_username_email_password_regis() {
		regisPage.regis("jihan", "jihan@test.com", "jihan.123.asd");
//		System.out.println("Input Regis Success");
		scroll(300);
//		delay(3);
	}
	
	@Then("User click button regis and alert")
	public void user_click_button_regis_and_alert() {
		regisPage.btnRegis();
		scroll(200);
		regisPage.alert();
		delay(3);
	}

	//tag2
	@Given("Button remember me")
	public void button_remember_me() {
		scroll(200);
		loginPage.remember();
	}
	
	@Given("User enter username password")
	public void user_enter_username_password() {
		scroll(200);
		regisPage.myAcc();
		scroll(400);
		loginPage.login("jihan", "jihan.123.asd");
		System.out.println("Input Login Success");
		delay(3);
	}
	
	@Then("User click button login")
	public void user_click_button_login() {
		loginPage.btnLogin();
		scroll(200);
	}
	
	//tag3
	@Given("Search item1")
	public void search_item1() {
		scroll(-400);
		delay(3);
		searchPage.SearchItem("Pink Floral");
		scroll(600);
	}
	
	@When("Click button wishlist1")
	public void click_button_wishlist1() {
		searchPage.wishList1();
		delay(2);
	}
	
	@Then("Click logo1")
	public void click_logo1() {
		searchPage.Logo1();
		scroll(400);
	}
	
	//tag4
	@Given("Search item2")
	public void search_item2() {
		searchPage.SearchItem("White Lace");
		scroll(700);
	}
	
	@When("Click button wishlist2")
	public void click_button_wishlist2()  {
		searchPage.wishList1();
		delay(2);
	}
	
	@And("Click logo2")
	public void click_logo2()  {
		searchPage.Logo2();
		scroll(400);
	}
	
	@Then("Click mywishlist")
	public void click_mywishlist() {
		searchPage.MyWishList();
		scroll(400);
	}
		
	//tag5
	@When("Click select options1")
	public void click_select_options1() {
		searchPage.Options();
	}
	
	@When("Select options1")
	public void select_options1() {
		scroll(400);
		searchPage.SelectColorSizeCart(1,3);
	}
	
	@Then("Alert to cart")
	public void alert_to_cart() {
		scroll(200);
		searchPage.AlertDismiss();
	}
	
	//tag6
	@And("Click logo3")
	public void click_logo3()  {
		searchPage.Logo3();
		scroll(400);
	}
	
	@And("Click mywishlist2")
	public void click_mywishlist2() {
		searchPage.MyWishList();
	}
	
	@Given("Click select options2")
	public void click_select_options2() {
		searchPage.Options2();
	}
	
	@When("Select options2")
	public void select_options2() {
		scroll(500);
		searchPage.SelectSizeCart(3);
	}
	
	//tag7
	@Given("Click viewcart")
	public void click_viewcart() {
		searchPage.ViewCart();
		scroll(700);
		delay(3);
	}
	
	@When("Click checkout")
	public void click_checkout() {
		searchPage.checkOut();
		scroll(600);
		delay(1);
	}
	
	//tag8
	@Given("Click checkout to data")
	public void click_checkout_to_data() {
		scroll(400);
		checkOutPage.country("Indonesia");
		checkOutPage.Address("Tembalang");
		checkOutPage.City("Semarang");
		checkOutPage.Province("Jawa Tengah");
		checkOutPage.postCode("50277");
		checkOutPage.Phone("082220000012");
		delay(1);
	}
	
	@And("Click checkbox accept")
	public void click_checkbox_accept() {
		scroll(400);
		checkOutPage.accept();
	}
	
	@Then("Click placeorder")
	public void click_placeorder() {
		checkOutPage.placeOrder();
		delay(1);
		scroll(500);
	}
	
	//tag9
	@Given("Click myacc")
	public void click_myacc() {
		searchPage.Logo1();
		scroll(500);
		regisPage.myAcc();
	}
	
	@Then("Click logout")
	public void click_logout() {
		logoutPage.logout();
		scroll(700);
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
}
}
