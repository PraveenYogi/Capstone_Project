package pageFactory;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageFactory extends MyBase {

	WebDriver driver;
	List<HashMap<String,String>> excelTestData  = ExcelReader.readExcelSheet("TestData", "LoginCredentials");
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement usernameTextField;

	@FindBy(id = "password")
	WebElement passwordTextField;

	@FindBy(id = "login-button")
	WebElement loginBtn;
	


	public void enterUsername(String userName) throws InterruptedException {
//		System.out.println("*************");
//		System.out.println(excelTestData.get(0).get("Valid_UserName"));
//		System.out.println(excelTestData.get(0).get("Valid_Password"));
//		System.out.println(excelTestData.get(0).get("Invalid_UserName"));
//		System.out.println(excelTestData.get(0).get("Invalid_Password"));
//		System.out.println("*************");
//		System.out.println(excelTestData.get(1).get("Valid_UserName"));
//		System.out.println(excelTestData.get(1).get("Valid_Password"));
//		System.out.println(excelTestData.get(1).get("Invalid_UserName"));
//		System.out.println(excelTestData.get(1).get("Invalid_Password"));
//		System.out.println("*************");

		
		String username = excelTestData.get(1).get(userName);		
		System.out.println("Excel Username:"+username);
		usernameTextField.sendKeys(username);
		
	}

	public void enterPassword(String passWord) throws InterruptedException {
		String password = excelTestData.get(1).get(passWord);
		System.out.println("Excel Password:"+password);
		passwordTextField.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}
	


}
