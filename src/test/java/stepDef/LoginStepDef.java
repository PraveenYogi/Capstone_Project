package stepDef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.MyBase;

public class LoginStepDef extends MyBase{
	
	public static WebDriver driver;
	
	
	LoginPageFactory loginPg;
	HomePageFactory homePg;
	
	@Given("browser is launched")
	public void browser_is_launched() throws IOException {
		driver = launchBrowser();
	}

	@Given("user navigates to the saucedemo login page")
	public void user_navigates_to_the_saucedemo_login_page() throws IOException {
		navigateToWebPage();
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String userName, String password) throws InterruptedException {
		loginPg = new LoginPageFactory(driver);
		loginPg.enterUsername(userName);
		loginPg.enterPassword(password);
		
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginPg.clickLogin();
	}

	@Then("I validate the page title after successful login")
	public void i_validate_the_page_title_after_successful_login() throws InterruptedException {
		homePg = new HomePageFactory(driver);
		homePg.validatePageTitle();
	}

}
