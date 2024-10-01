package elementRepository;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserEmbargoGeneralEditPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	String warenstammName, warrenNummer, verordnungenColour = "", warenNummernSperrenColour = "",
			artikelSperrenColour = "";

	public UserEmbargoGeneralEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath = "//div[@class='breadcrumb-tabs container-fluid text-center px-0']//div[1]")
	WebElement verordnungenButton;
	@FindBy(xpath = "//div[@class='breadcrumb-tabs container-fluid text-center px-0']//div[3]")
	WebElement artikelSperrenButton;
	@FindBy(xpath = "//table[@id='Scroll_tbl_LandDetails']//tbody//tr//td[5]//div//input")
	WebElement embargoTriftZuButton;
	@FindBy(xpath = "//table[@id='Scroll_tbl_LandDetails']//tbody//tr//td[6]//div//input")
	WebElement embargoTriftNichtZuButton;
	@FindBy(xpath = "//span[text()='Speichern']")
	WebElement embargoSaveButton;
	@FindBy(xpath = "//span[text()='Zuruck']")
	WebElement embargoZuruckButon;
	@FindBy(xpath = "//div[@class='breadcrumb-tabs container-fluid text-center px-0']//div[2]")
	WebElement warenNummernSperrenButton;
	@FindBy(id = "mainContent_txtWarennummer")
	WebElement warenNummerTextField;
	@FindBy(id = "mainContent_btnAddWarennummer")
	WebElement addWarenNummerButton;
	@FindBy(id = "mainContent_txtlandname")
	WebElement landerNameField;
	@FindBy(id = "mainContent_txtWarennummer")
	WebElement warennummerOderKapitelSuchenField;
	@FindBy(id="mainContent_txtsearchartikelno")
	WebElement artikelNummerSuchenField;
	@FindBy(id="mainContent_btnAddArtikel")
	WebElement addArtikelButton;

	public void clickOnAddArtikelButton() {
		addArtikelButton.click();
	}
		public void sendOnartikelNummerSuchenField(String artikelNummer) {
			artikelNummerSuchenField.sendKeys(artikelNummer);
		}
	public void clickOnArtikelSperrenButton() {
		artikelSperrenButton.click();
	}
	public String getAttributeValueOfLanderNameFieldValue() {
		return gu.getAttributeValueOfElement(landerNameField, "value");
	}

	public void clickOnVerordnungenButton() {
		verordnungenButton.click();
	}

	public void clickOnWarenNummernSperrenButton() {
		warenNummernSperrenButton.click();
	}

	public void sendWarenNummerOnWarennummerOderKapitelSuchenField(String wtn) {
		warennummerOderKapitelSuchenField.sendKeys(wtn);
	}

	public void clickOnAddWarenNummerButton() {
		addWarenNummerButton.click();
	}

	public void sendWTNOnWarrenNummerField() throws InvalidFormatException, IOException {
		String warrenNummer = eu.readDataFromExcelExportkontrol(gu.randon(4784), "WTN_Page");
		this.warrenNummer = warrenNummer;
		gu.sendKeyFunction(warenNummerTextField, warrenNummer);
	}

	public void sendWTNOnWarrenNummerFieldWithNDigit(int i) throws InvalidFormatException, IOException {
		int digitWTN = 0;
		String wtn = eu.readDataFromExcelExportkontrol(gu.randon(4784), "WTN_Page");
		int intWarrenNummer = Integer.parseInt(wtn);
		if (i == 2) {
			digitWTN = intWarrenNummer / 1000000;
		} else if (i == 4) {
			digitWTN = intWarrenNummer / 10000;
		} else if (i == 6) {
			digitWTN = intWarrenNummer / 100;
		}
		String warrenNummer = Integer.toString(digitWTN);
		this.warrenNummer = warrenNummer;
		gu.sendKeyFunction(warenNummerTextField, warrenNummer);
	}

	public String getSendedWarenNummer() {
		return warrenNummer;
	}

	public void clickOnEmbargoTriftZuButton() {
		embargoTriftZuButton.click();
	}

	public void clickOnEmbargoTriftNichtZuButton() {
		embargoTriftNichtZuButton.click();
	}

	public void clickOnEmbargoSaveButton() {
		embargoSaveButton.click();
	}

	public String getBackGroundColourOfBreadCrumbTab(int tabNumber) {
		String path = "//div[@class='breadcrumb-tabs container-fluid text-center px-0']//div[" + tabNumber + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return gu.getAttributeValueOfElement(element, "class");
	}

	public String getActualTabColourOfBreadCrumbTab() {
		if (getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link red")) {
			verordnungenColour = "red";
		} else if (getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link yellow")) {
			verordnungenColour = "yellow";
		} else if (getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link green")) {
			verordnungenColour = "green";
		}
		if (getBackGroundColourOfBreadCrumbTab(2).equals("warennummernsperren breadcrumb-tab-link")) {
			warenNummernSperrenColour = "black";
		} else if (getBackGroundColourOfBreadCrumbTab(2).equals("warennummernsperren breadcrumb-tab-link purple")) {
			warenNummernSperrenColour = "majenta";
		}
		if (getBackGroundColourOfBreadCrumbTab(3).equals("artikelsperren breadcrumb-tab-link")) {
			artikelSperrenColour = "black";
		} else if (getBackGroundColourOfBreadCrumbTab(3).equals("artikelsperren breadcrumb-tab-link purple")) {
			artikelSperrenColour = "majenta";
		}

		String breadCrumbTabColour = "status-" + verordnungenColour + " status-over-" + verordnungenColour + ""
				+ "status-" + warenNummernSperrenColour + " status-over-" + warenNummernSperrenColour + "" + "status-"
				+ artikelSperrenColour + " status-over-" + artikelSperrenColour + "";
		return breadCrumbTabColour;
	}

	public void clickOnEmbargoZuruckButton() {
		embargoZuruckButon.click();
	}

	public String getWTNFronTable(int row) {
		String elementPath = "//table[@id='Scroll_tbl_Warennummer']//tbody//tr[" + row + "]//td[2]//a";
		WebElement element = driver.findElement(By.xpath(elementPath));
		return element.getText();
	}
}
