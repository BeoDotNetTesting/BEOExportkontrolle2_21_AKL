package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtilities {
	public void fluventWaitElements(WebDriver driver,WebElement element,String attribute,String attributeValue,int total) {
	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(total))
	            .pollingEvery(Duration.ofSeconds(2))
	            .ignoring(NoSuchElementException.class);   
	 fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	public void explicitWaitForWebElementText(WebDriver driver, String text,int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	}
	public void explicitWaitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void explicitWaitForWebElement(WebDriver driver,WebElement element,String attribute,String attributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	public void explicitWaitForWebElementTextToBePresent(WebDriver driver,WebElement element,String  elementText,int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.textToBePresentInElement(element, elementText));
	}
	public void explicitWaitForWebElement(WebDriver driver,WebElement element,int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicitWaitForWebElementTextBoBePresent(WebDriver driver,WebElement element,int duration,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void explicitWaitUntilWebElementClickable(WebDriver driver,WebElement element,int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
