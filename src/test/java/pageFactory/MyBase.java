package pageFactory;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyBase {

	public static WebDriver driver;
	FileInputStream fis;
	Properties p = new Properties();

	public WebDriver launchBrowser() throws IOException {
		fis = new FileInputStream(
				"C:/Users/Praveen/eclipse-workspace/Capstone_SDET/src/test/resources/data.properties");
		p.load(fis);

		String browserName = p.getProperty("Browser");
		System.out.println("The Browser Name is:" + browserName);

		if (browserName.equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}

		else if (browserName.equals("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}
		return driver;
	}

	public void navigateToWebPage() throws IOException {
		fis = new FileInputStream(
				"C:/Users/Praveen/eclipse-workspace/Capstone_SDET/src/test/resources/data.properties");
		p.load(fis);

		String url = p.getProperty("baseUrl");
		System.out.println("The website url is:" + url);
		driver.get(url);
	}
}
