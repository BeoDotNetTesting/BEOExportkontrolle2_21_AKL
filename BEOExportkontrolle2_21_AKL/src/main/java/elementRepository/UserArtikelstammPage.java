package elementRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserArtikelstammPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	String warenstammName, artikelNummer, warenNummer;

	public UserArtikelstammPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//div[@class='tool-icon']//span[2]") // span[text()='Hinzufügen']
	WebElement newArtikelHinzufugenButton;
	@FindBy(id = "mainContent_txtArtikelnummer")
	WebElement textArtikelnummer;
	@FindBy(id = "mainContent_txtWarennummer")
	WebElement textWarennummer;
	@FindBy(id = "mainContent_txtArtikelbezeichnung")
	WebElement textArtikelBezeichnung;
	@FindBy(id = "mainContent_btnAddArtikel")
	WebElement addArtikelButton;
	@FindBy(xpath = "//span[text()='Zurück']")
	WebElement zuruckButton;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr//td[2]")
	List<WebElement> artikelstamFolgenummerColumn;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr//th[text()='Keine Daten vorhanden']")
	WebElement keineDatenVorhandenText;
	@FindBy(xpath = "//span//a//span[text()='Zurück']")
	WebElement zuruckButtonInArtikelstamm;
	@FindBy(id = "head_Warenstamm")
	WebElement headWarenstammWarengruppe;
	@FindBy(id = "mainContent_btn_Delete")
	WebElement deleteButton;
	@FindBy(xpath = "//span[text()='Gelöscht']")
	WebElement artikelDeletePopup;
	@FindBy(xpath = "//i[@class='close-notificationbar mx-3 fa-solid fa-times']")
	WebElement notificationBarCloseButton;
	@FindBy(xpath = "//div[@id='main']//div[2]//span[@class='alert-danger']")
	WebElement notificationBar;
	@FindBy(id="paginate_select")
	WebElement artikelstammPagination;
	@FindBy(xpath="//select[@id='paginate_select']//option")
	List<WebElement> artikelstammPaginationCount;

	public void clickOnNewArtikelHinzufugenButton() throws InterruptedException {
		Thread.sleep(3000);
		newArtikelHinzufugenButton.click();
		Thread.sleep(2500);
	}

	public void waitUntilNewArtikelHinzufugenButtonClickable() throws InterruptedException {
		wu.explicitWaitUntilWebElementClickable(driver, newArtikelHinzufugenButton, 10);
		Thread.sleep(2000);
	}

	public void sendArtikelNummerOnTextField() {
		String artikelNummer = "AN" + gu.generateCurrentDateAndTime();
		this.artikelNummer = artikelNummer;
		gu.sendKeyFunction(textArtikelnummer, artikelNummer);
	}

	public void sendExistingArtikelNummerOnTextField(String existingArtikelNumber) {
		gu.sendKeyFunction(textArtikelnummer, existingArtikelNumber);
	}

	public String getAtikelNummerForExpectedString() {
		return artikelNummer;
	}

	public void sendWarennummerOnTextField() throws InvalidFormatException, IOException {
		String warenNummer = eu.readDataFromExcelExportkontrol(gu.randon(4784), "WTN_Page");
		this.warenNummer = warenNummer;
		gu.sendKeyFunction(textWarennummer, warenNummer);
	}

	public String sendRandomWarenNummer() {
		return warenNummer;
	}

	public void sendWarennummerOnTextField(String warennummer) {
		gu.sendKeyFunction(textWarennummer, warennummer);
	}

	public void sendArtikelBezeichnungOnTextField() {
		gu.sendKeyFunction(textArtikelBezeichnung, artikelNummer);
	}

	public void sendArtikelBezeichnungOnTextFieldForEdit() {
		gu.sendKeyFunction(textArtikelBezeichnung, "123456789");
	}

	public void clickOnAddArtikelButton() {
		addArtikelButton.click();
	}

	public void clickOnZuruckButton() {
		zuruckButton.click();
	}

	public void waitForZuruckButtonClick() {
		// wu.fluventWaitElements(driver, zuruckButton, "class", "grey", 20);
		wu.explicitWaitUntilWebElementClickable(driver, zuruckButton, 10);
	}

	public String getArtikelnummerCorrespondingNumber() {
		String artikelNummerColumnElementtext = "";
		for (int i = 0; i < artikelstamFolgenummerColumn.size(); i++) {
			if (artikelstamFolgenummerColumn.get(i).getText().equals(artikelNummer)) {
				String artikelNummerColumnPath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr[" + (i + 1)
						+ "]//td[2]";
				WebElement artikelNummerColumnElement = driver.findElement(By.xpath(artikelNummerColumnPath));
				artikelNummerColumnElementtext = artikelNummerColumnElement.getText();
			}
		}
		return artikelNummerColumnElementtext;
	}

	public int getCountOfArtikelFromArtikelstamPage() {
		return artikelstamFolgenummerColumn.size();
	}
	public void selectLastPageArtikelCount() {		
		gu.selectDropdownWithIndex(artikelstammPagination, (artikelstammPaginationCount.size()-1));
	}

	public String getkeineDatenVorhandenText() {
		return keineDatenVorhandenText.getText();
	}

	public void clickOnZuruckButtonInArtikelstamm() {
		zuruckButtonInArtikelstamm.click();
	}

	public String readHeadingOfWarenstammWarengruppe() {
		// return gu.getElementText(headWarenstammWarengruppe);
		return headWarenstammWarengruppe.getText();
	}

	public void waitForHeadingOfWarenstammWarengruppe() {
		wu.explicitWaitForWebElement(driver, headWarenstammWarengruppe, "id", "head_Warenstamm");
	}

	public int getArtikelstammtableSizw() {
		return artikelstamFolgenummerColumn.size();
	}

	public void clickAnyWhereInArtikelstammTable(int row, int column) {
		String artikelstammTableElementPath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr[" + (row + 1) + "]//td["
				+ (column + 1) + "]";		
		WebElement artikelstammTableElement = driver.findElement(By.xpath(artikelstammTableElementPath));
		// artikelstammTableElement.click();
		gu.clickJavaScriptExecutor(artikelstammTableElement, driver);
	}

	public void doubleClickArtikelstammTableElementAnyWhere(int row, int column) {
		String artikelstammTableElementPath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr[" + (row + 1) + "]//td["
				+ (column + 1) + "]";
		WebElement element = driver.findElement(By.xpath(artikelstammTableElementPath));
		gu.mouseDoubleClick(driver, element);
	}

	public void clickOnDeleteButton() {
		deleteButton.click();
	}

	public String getArtikelstammTableElementText(int column, int row) {
		String artikelstammTableElementPath = "//table[@id='Scroll_tbl_Artikelstam']//tbody//tr[" + (column + 1)
				+ "]//td[" + (row + 1) + "]";
		WebElement artikelstammTableElement = driver.findElement(By.xpath(artikelstammTableElementPath));
		return artikelstammTableElement.getText();
	}

	public String readArtikelDeletePopup() {
		return artikelDeletePopup.getText();
	}

	public void clickOnNotificationBarCloseButton() {
		notificationBarCloseButton.click();
	}

	public void waitForNoDataAvailableText() {
		wu.explicitWaitForWebElementTextToBePresent(driver, keineDatenVorhandenText, "Keine Daten vorhanden", 20);
	}

	public void waitForLoschenNotificationBarText() {
		wu.explicitWaitForWebElement(driver, notificationBarCloseButton, 10);
	}

	public String readNoDataAvailableText() {
		return keineDatenVorhandenText.getText();
	}

	public String getAttributeValueOfArtikelnummerField() {
		return gu.getAttributeValueOfElement(textArtikelnummer, "class");
	}

	public String getAttributeValueOfArtikelnummerFieldValue() {
		return gu.getAttributeValueOfElement(textArtikelnummer, "value");
	}

	public String getAttributeValueOfWarennummerField() {
		return gu.getAttributeValueOfElement(textWarennummer, "class");
	}

	public String getAttributeValueOfArtikelBezeichnungField() {
		return gu.getAttributeValueOfElement(textArtikelBezeichnung, "class");
	}

	public String copyTheArtikelNumberInToArrayList() {
		ArrayList<String> artikelNummer = new ArrayList<String>();
		for (int i = 0; i < artikelstamFolgenummerColumn.size(); i++) {
			artikelNummer.add(driver.findElements(By.xpath("//table[@id='Scroll_tbl_Artikelstam']//tbody//tr//td[2]"))
					.get(i).getText());
		}
		return artikelNummer.get(gu.randon(artikelstamFolgenummerColumn.size()));
	}

	public String readNotificationBarMessage() {
		return notificationBar.getText();
	}

	public void waitForArtikelNumberExistingMessage() {
		wu.explicitWaitForWebElementTextToBePresent(driver, notificationBar, "Artikelnummer existiert bereits!", 5);
	}

	public void writeArtikelstamDataToExcel(int row, int column, String warenstammData) throws IOException {
		eu.fileWriteExcelWithoutAffectExistingData("\\src\\main\\resources\\Excel\\WarenstammTable.xlsx",
				"ArtikelstammDetails", row, column, warenstammData);
	}

	public int logIndataWTN() throws IOException, InvalidFormatException {
		ArrayList<String> data = ExcelUtilities.readDataFromExcel("\\src\\main\\resources\\Excel\\Exportkontrol.xls",
				"WTN_Page");
		return data.size();
	}

	public boolean checkWarrenstammNamePresentOrNotInArtikelStamPageHeading(String word, String scentence) {
		return gu.checkAWordPresentInScentence(word, scentence);
	}
}
