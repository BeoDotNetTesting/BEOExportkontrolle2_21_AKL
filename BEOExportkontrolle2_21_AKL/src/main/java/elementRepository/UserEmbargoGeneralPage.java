package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserEmbargoGeneralPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	String warenstammName;

	public UserEmbargoGeneralPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

//	@FindBy(xpath = "//div[@class='container-fluid']//ul//li[7]//a")
//	WebElement embargoButton;
	@FindBy(xpath = "//label[text()='Länderübersicht']")//label[text()='Länderliste']  //label[text()='Länderübersicht']
	WebElement landerubersicht;
	@FindBy(xpath = "//table[@id='Scroll_tbl_AllLand']//tbody//tr//td[1]")
	List<WebElement> alleLanderTableSize;
	@FindBy(xpath = "//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr//td[1]")
	List<WebElement> landerListeLanderTable;
	@FindBy(xpath = "//span[text()='Hinzufügen']")
	WebElement hinzufugenButton;
	@FindBy(xpath = "//div[@class='notificationbar']//span[@class='success']")
	WebElement successNotificationMessage;
	@FindBy(xpath="//div[@class='notificationbar']//span[@class='alert-danger']")
	WebElement embargoNotificationAlertDangerMessage;
	@FindBy(xpath="//div[@class='notificationbar']//i")
	WebElement notificationCloseButton;
	@FindBy(xpath = "//div//div[2]//div[@class='scrollabale-head-div']//table[@class='header-table ']//thead//tr//th//div[@class='form-check']//input[@class='form-check-input check-all']")
	WebElement selectAllSelectedCountryRadioButton;
	@FindBy(xpath = "//a[@id='mainContent_btn_DeleteAll']//span[text()='Löschen']")
	WebElement selectedCountryLoschenButton;
	
	public void clickOnNotificationCloseButton() {
		notificationCloseButton.click();
	}
	public void clcickOnSelectedCountryLoschenButton() {
		selectedCountryLoschenButton.click();
	}

	public void clickOnSelectAllSelectedCountryRadioButton() {
		selectAllSelectedCountryRadioButton.click();
	}
/*
	public void clickOnEmbargoButton() {
		embargoButton.click();
	}
*/
	public void clickOnLanderubersicht() {
		landerubersicht.click();
	}

	public int getTableSizeOfLanderubersicht() {
		return alleLanderTableSize.size();
	}

	public int getTableSizeOfLanderListeLanderTable() {
		return landerListeLanderTable.size();
	}

	public void selectLanderubersichtTableRows(int row) {
		for(int i=0;i<row;i++) {
		String element = "//table[@id='Scroll_tbl_AllLand']//tbody//tr[" + (i + 1) + "]//td[1]//div//input";
		WebElement tableElement = driver.findElement(By.xpath(element));
		tableElement.click();
		}
	}

	public void clickOnHinzufugenButton() {
		hinzufugenButton.click();
	}

	public void clickOnDropDownOfLanderListe(int option) {
		String path = "//ul[@class='header-title-drop-box-navbar']/li[" + option + "]//a";
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
	}

	public String readEmbargoNotificationMessage() {
		return successNotificationMessage.getText();
	}

	public void waitForEmbargoNotificationMessage() {
		wu.explicitWaitForWebElement(driver, successNotificationMessage, 20);
	}
	public void waitForReadEmbargoNotificationAlertDangerMessage() {
		wu.explicitWaitForWebElement(driver, embargoNotificationAlertDangerMessage, 30);
	}
	public void clickOnLanderName(int row) {
		String path = "//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr[" + row + "]//td[2]//a";
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
	}
	public String getAlleAnzeigenColour(int row) {
		String verordnungenColourPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+row+"]//td[5]//a//span[1]";
		WebElement verordnungenColourPathElement=driver.findElement(By.xpath(verordnungenColourPath));
		String warenNummernSperrenColourPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+row+"]//td[5]//a//span[2]";
		WebElement warenNummernSperrenColourPathElement=driver.findElement(By.xpath(warenNummernSperrenColourPath));
		String artikelSperrenColourPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+row+"]//td[5]//a//span[3]";
		WebElement artikelSperrenColourPathElement=driver.findElement(By.xpath(artikelSperrenColourPath));
		String alleAnzeigenColour=gu.getAttributeValueOfElement(verordnungenColourPathElement, "class")+gu.getAttributeValueOfElement(warenNummernSperrenColourPathElement, "class")+gu.getAttributeValueOfElement(artikelSperrenColourPathElement, "class");
		return alleAnzeigenColour;
	}
	
	public void doubleClickEmbargoTableElementAnyWhere(int row, int column) {
		String embargoTableElementPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+(row+1)+"]//td["+(column+1)+"]";
		WebElement element = driver.findElement(By.xpath(embargoTableElementPath));
		gu.mouseDoubleClick(driver, element);		
	}
	public String readEmbargoCountryNameFromTable(int row, int column) {
		String embargoLandNameElementPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+(row+1)+"]//td["+(column+1)+"]//a";
		WebElement element = driver.findElement(By.xpath(embargoLandNameElementPath));
		return element.getText();
	}
	public String readEmbargoCountryTableElementText(int row, int column) {
		String embargoLandNameElementPath="//table[@id='Scroll_tbl_SelectedCountry']//tbody//tr["+(row+1)+"]//td["+(column+1)+"]";
		WebElement element = driver.findElement(By.xpath(embargoLandNameElementPath));
		return element.getText();
	}
	public String readEmbargoNotificationAlertDangerMessage() {
		return embargoNotificationAlertDangerMessage.getText();
	}
}
