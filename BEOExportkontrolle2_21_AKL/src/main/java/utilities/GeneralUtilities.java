package utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {
	String path = null;

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void sendKeyFunction(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public boolean elementIsSelected(WebElement element) {
		element.click();
		boolean b = element.isSelected();
		return b;
	}

	public boolean elementIsDisplayed(WebElement element) {

		return element.isDisplayed();
	}

	public boolean elementIsEnabled(WebElement element) {
		return element.isEnabled();
	}

	public void DragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions actObject = new Actions(driver);
		actObject.dragAndDrop(sourceElement, targetElement).perform();
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void sendKeyFunctionforImage(WebElement element, String imageName) {
		element.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\" + imageName);
	}

	public String selectRowValueFromDynamicTable(List<WebElement> listOfRow, String value, String firstHalf,
			String secondHalf) throws Exception {

		for (int i = 0; i < listOfRow.size(); i++) {
			if (listOfRow.get(i).getText().equals(value)) {
				path = firstHalf + (i + 1) + secondHalf;
				// table[@class='content-table ']//tbody//tr[4]//td[3]
			}
		}
		return path;
	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void pageScroll(int horizontal, int vertical, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")", "");
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public String getCSSValueOfElement(WebElement element, String parameter) {
		return element.getCssValue(parameter);
	}

	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public boolean isClickable(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public void swithToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void swithToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void swithToFrameByIndex(WebDriver driver, String name, int tagCount) {
		driver.switchTo().frame(tagCount);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
		// driver.switchTo().defaultContent();
	}

	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.moveToElement(element).perform();
	}

	public void mouseDoubleClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.doubleClick(element).perform();
	}

	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.contextClick(element).perform();
	}

	public void arrowKeyDown(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.sendKeys(Keys.ARROW_DOWN).perform();
	}

	public String getAttributeValueOfElement(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");
		return formatter.format(date);		
	}
	public String generateCurrentDateByPattern(String pattern) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);	
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}
	public boolean checkAWordPresentInScentence(String substringToCheck, String sentence) {
		boolean status= false;
		  if (sentence.contains(substringToCheck)) {
	           status=true;
	        } else {
	        	status=false;
	        }
		  return status;
	    }
	public void scrollElementIntoView(WebDriver driver, WebElement element) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
}
