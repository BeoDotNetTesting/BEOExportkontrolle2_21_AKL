package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
	private static WebDriver driver;
	public static Properties pro;
		
		
		public static void testBasic() throws IOException {
			pro = new Properties();
			FileInputStream fp = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
			pro.load(fp);
		}

	    private WebDriverSingleton() {
	        // Private constructor to prevent instantiation
	    }

	    public static WebDriver getDriver() throws IOException {
	        if (driver == null) {
	        	testBasic();
	            // Initialize the WebDriver (you can customize this based on your needs)
	        	System.setProperty(pro.getProperty("chromeDriver"),
						System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
	            driver = new ChromeDriver();
	        }
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null; // Reset the WebDriver instance
	        }
	    }
}
