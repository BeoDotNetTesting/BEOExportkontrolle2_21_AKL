package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;
import utilities.WebDriverSingleton;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;

	public static void testBasic() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	public static String logIndata(int usr) throws IOException, InvalidFormatException {
		ArrayList<String> data = ExcelUtilities.readDataFromExcel("\\src\\main\\resources\\Excel\\Exportkontrol.xls",
				"ExportkontrolleData");
		return data.get(usr);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethode(String browserName) throws IOException {
		if (browserName.equals("chrome")) {

			testBasic();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("fireFox")) {
			testBasic();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();	
		driver.get(pro.getProperty("BaseURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}
}
