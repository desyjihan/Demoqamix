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
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDemo {

	public static WebDriver driver;
	private static ExtentTest extentTest;
	
	private SearchPage searchPage = new SearchPage();
	private RegisPage regisPage = new RegisPage();
	private LoginPage loginPage = new LoginPage();
	private CheckOutPage checkOutPage = new CheckOutPage();
	private LogoutPage logoutPage = new LogoutPage();
	
	public TestDemo() {
		driver = Hooks.driver;
		extentTest = Hooks.extentTest;
	}
	
	//tag1
	@Given("User go to Web DemoQA and click myAcc")
	public void user_go_to_Web_DemoQA_click_myAcc() {
//		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		scroll(200);
		regisPage.myAcc();
		extentTest.log(LogStatus.PASS, "User go to Web DemoQA and click myAcc");
	}
	
	@When("User enter username email password regis") 
	public void user_enter_username_email_password_regis() {
		regisPage.regis("jihan", "jihan@test.com", "jihan.123.asd");
		scroll(300);
		extentTest.log(LogStatus.PASS, "User enter username email password regis");
	}
	
	@Then("User click button regis and alert")
	public void user_click_button_regis_and_alert() {
		regisPage.btnRegis();
		scroll(200);
		delay(3);
		regisPage.alert();
		
		extentTest.log(LogStatus.PASS, "User click button regis and alert");
	}

	//tag2
	@When("User enter username password")
	public void user_enter_username_password() {
		scroll(600);
		loginPage.login("", "jihan.123.asd");
		delay(1);
		extentTest.log(LogStatus.PASS, "User enter username password");
	}
	
	@When("Button remember me")
	public void button_remember_me() {
//		scroll(200);
		loginPage.remember();
		extentTest.log(LogStatus.PASS, "Button remember me");
	}
	
	@Then("User click button login")
	public void user_click_button_login() {
		loginPage.btnLogin();
		scroll(200);
		delay(2);
		extentTest.log(LogStatus.PASS, "User click button login");
	}
	
	//tag3
	@Given("Search item1")
	public void search_item1() {
		scroll(-400);
		delay(3);
		searchPage.SearchItem("Pink Floral");
		scroll(600);
		extentTest.log(LogStatus.PASS, "Search item1");
	}
	
	@When("Click button wishlist1")
	public void click_button_wishlist1() {
		searchPage.wishList1();
		delay(2);
		extentTest.log(LogStatus.PASS, "Click button wishlist");
	}
	
	@Then("Click logo1")
	public void click_logo1() {
		searchPage.Logo1();
		scroll(400);
		extentTest.log(LogStatus.PASS, "Click logo1");
	}
	
	//tag4
	@When("Search item2")
	public void search_item2() {
		searchPage.SearchItem("White Lace");
		scroll(700);
		extentTest.log(LogStatus.PASS, "Search item2");
	}
	
	@And("Click button wishlist2")
	public void click_button_wishlist2()  {
		searchPage.wishList1();
		delay(3);
		extentTest.log(LogStatus.PASS, "Click button wishlist2");
	}
	
	@And("Click logo2")
	public void click_logo2()  {
		searchPage.Logo2();
		scroll(400);
		extentTest.log(LogStatus.PASS, "Click logo2");
	}
	
	@Then("Click mywishlist")
	public void click_mywishlist() {
		searchPage.MyWishList();
		scroll(400);
		extentTest.log(LogStatus.PASS, "Click mywishlist");
	}
		
	
	 //tag5
	 @When("Click select options1") 
	 public void click_select_options1() {
		 searchPage.Options(); 
		 extentTest.log(LogStatus.PASS, "Click select options1");
	}
	 
	 @When("Select options1") 
	 public void select_options1() { 
		 scroll(400);
		 searchPage.SelectColorSizeCart(1,3); 
		 extentTest.log(LogStatus.PASS, "Select options1");
	}
	  
	 @Then("Alert to cart") 
	 public void alert_to_cart() { 
		 scroll(200);
		 searchPage.AlertDismiss();
		 extentTest.log(LogStatus.PASS, "Alert to cart");
	 }
	
	//tag6
	@Given("Click logo3")
	public void click_logo3()  {
		searchPage.Logo3();
		scroll(400);
		extentTest.log(LogStatus.PASS, "Click logo3");
	}
	
	@When("Click mywishlist2")
	public void click_mywishlist2() {
		searchPage.MyWishList();
		scroll(400);
		searchPage.Options2();
		scroll(600);
		searchPage.SelectSizeCart(3);
		scroll(200);
		extentTest.log(LogStatus.PASS, "Click mywishlist2");
	}
	
	//tag7
	@When("Click viewcart")
	public void click_viewcart() {
		searchPage.Logo3();
		scroll(500);
		searchPage.ViewCart();
		scroll(700);
		delay(3);
		extentTest.log(LogStatus.PASS, "Click viewcart");
	}
	
	@And("Click proceed to checkout")
	public void click_checkout() {
		searchPage.checkOut();
		scroll(600);
		delay(1);
		extentTest.log(LogStatus.PASS, "Click proceed to checkout");
	}
	
	//tag8
	@And("Click checkout to data")
	public void click_checkout_to_data() {
		scroll(400);
		checkOutPage.country("Indonesia");
		checkOutPage.Address("Tembalang");
		checkOutPage.City("Semarang");
		checkOutPage.Province("Jawa Tengah");
		checkOutPage.postCode("50277");
		checkOutPage.Phone("082220000012");
//		checkOutPage.Email("jihan@test.com");
		delay(1);
		extentTest.log(LogStatus.PASS, "Click checkout to data");
	}
	
	@And("Click checkbox accept")
	public void click_checkbox_accept() {
		scroll(-200);
		checkOutPage.accept();
		extentTest.log(LogStatus.PASS, "Click checkbox accept");
	}
	
	@Then("Click placeorder")
	public void click_placeorder() {
		checkOutPage.placeOrder();
		delay(3);
		scroll(700);
		extentTest.log(LogStatus.PASS, "Click placeorder");
	}
	
	//tag9
	@Given("Click logo4")
	public void click_logo4() {
		searchPage.Logo1();
		scroll(400);
	}
	
	@When("Click myacc")
	public void click_myacc() {
		regisPage.myAcc();
		extentTest.log(LogStatus.PASS, "Click myacc");
	}
	
	@And("Click logout")
	public void click_logout() {
		logoutPage.logout();
		scroll(800);
		extentTest.log(LogStatus.PASS, "Click logout");
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
