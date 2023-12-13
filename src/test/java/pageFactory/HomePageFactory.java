package pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFactory extends MyBase {

	WebDriver driver;
	LoginPageFactory loginPg;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='app_logo' and text()='Swag Labs']")
	WebElement appLogo_Header;

	@FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	WebElement login_Error_Msg;

	public void validate_UnsuccessfulLogin() {
		String expectedError_Msg = "Epic sadface: Username and password do not match any user in this service";
		String actualError_Msg = login_Error_Msg.getText();
		Assert.assertTrue(actualError_Msg.equals(expectedError_Msg));
		System.out.println("*** Unsuccessful Login *** ");
	}

	public void validatePageTitle() throws InterruptedException {

		Thread.sleep(3000);
		try {
			if (login_Error_Msg.isDisplayed()) {
				validate_UnsuccessfulLogin();
			}
		} catch (Exception exe) {
			if (appLogo_Header.isDisplayed()) {
				String actualPageTitle = driver.getTitle();
				String expectedPageTitle = "Swag Labs";
				System.out.println("Home page title:" + actualPageTitle);
				Assert.assertTrue(actualPageTitle.equals(expectedPageTitle));
				System.out.println("*** Successful Login *** ");

			}

		}
		driver.close();
	}
}
