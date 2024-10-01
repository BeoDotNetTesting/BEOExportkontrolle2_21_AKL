package elementRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserWarenstammPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	String warenstammName;

	public UserWarenstammPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// main bar
	// @FindBy(xpath = "//ul//li[1]//a[@class='nav-link ']")
	// WebElement exportkontrolleButton;
	// @FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[4]//a[@class='nav-link
	// ']")
	// WebElement eveVerwaltungButton;
	// @FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[5]//a[@class='nav-link
	// ']")
	// WebElement toolsButton;
	@FindBy(xpath = "//ul//li[1]//a[@id='navbarDropdown'] ")
	WebElement artikelstammButton;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[2]//a[@class='nav-link ']")
	WebElement archivButton;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[3]//a[@class='nav-link ']")
	WebElement genehmigungsVerWaltungButton;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[4]//a[@class='nav-link ']")
	WebElement embargoButton;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//ul//li[5]//a[@class='nav-link ']")
	WebElement datenExportButton;
	@FindBy(xpath = "//ul[@class='navbar-nav side-nav']//li[1]//ul//li[1]")
	WebElement artikelstammTabButton;
	@FindBy(xpath = "//ul[@class='navbar-nav side-nav']//li[1]//ul//li[2]")
	WebElement auftragsprufungTabButton;
	@FindBy(xpath = "//body")
	WebElement wholeBodyElement;
	@FindBy(id = "toggle")
	WebElement darkModeButton;

	// artikelstammBar

	@FindBy(id = "mainContent_btnWarenAdd")
	WebElement warenstammHinzufugenButton;
	@FindBy(id = "mainContent_BtnWEdit")
	WebElement warenstammBearbeitenButton;
	@FindBy(id = "mainContent_btnDelete")
	WebElement warenstammLoschenButton;
	@FindBy(id = "mainContent_btnFileUpload")
	WebElement warenstammDateiHochladenButton;
	@FindBy(id = "mainContent_btnFilterArtikel")
	WebElement warenstammFilterButton;
	@FindBy(xpath = "//div[@class='notificationbar']//span[1]") // span[text()='Bitte wählen Sie mindesten eine Zeile.']
	WebElement loschenMessage;
	@FindBy(xpath = "//div[@class='notificationbar']")
	WebElement loschenMessageDiv;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr")
	List<WebElement> warenstammTable;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr//td[3]")
	List<WebElement> warenstammTableBeschreibung;
	@FindBy(id = "mainContent_txtWarenstamm")
	WebElement warenstammNameField;
	@FindBy(id = "mainContent_btnsave")
	WebElement warenstammHinzufugenSaveButton;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[1]//td[3]") // table[@id='Scroll_tbl_Warenstamm']//tbody//tr[1]//td[2]//span
	WebElement firstWarrenstammId;
	@FindBy(id = "searchtext")
	WebElement searchTextField;
	@FindBy(xpath = "//div//span[@class='searach-icon']")
	WebElement searchIcon;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr//th[text()='Keine Daten vorhanden']")
	WebElement noDataAvailableText;
	@FindBy(xpath = "//i[@class='close-notificationbar mx-3 fa-solid fa-times']") // (xpath="//div[@calss='notificationbar']//i")
	WebElement notificationBarCloseButton;
	@FindBy(id = "searchtext")
	WebElement searchField;
	
	// main bar function

	public boolean artikelstammButtonIsDisplayed() {
		return artikelstammButton.isDisplayed();
	}

	public boolean artikelstammButtonIsEnable() {
		return artikelstammButton.isEnabled();
	}

	public boolean archivButtonIsDisplayed() {
		return archivButton.isDisplayed();
	}

	public boolean archivButtonIsEnable() {
		return archivButton.isEnabled();
	}

	public void clickOnGenehmigungsVerWaltungButton() {
		genehmigungsVerWaltungButton.click();
	}

	public boolean embargoButtonIsDisplayed() {
		return embargoButton.isDisplayed();
	}

	public boolean embargoButtonIsEnable() {
		return embargoButton.isEnabled();
	}

	public void clickOnEmbargoButton() {
		embargoButton.click();
	}

	public boolean datenExportButtonIsDisplayed() {
		return datenExportButton.isDisplayed();
	}

	public boolean datenExportButtonIsEnable() {
		return datenExportButton.isEnabled();
	}

	// artikelstammBar function

	public boolean warenstammHinzufugenButtonIsDisplayed() {
		return warenstammHinzufugenButton.isDisplayed();
	}

	public boolean warenstammHinzufugenButtonIsEnable() {
		return warenstammHinzufugenButton.isEnabled();
	}

	public boolean warenstammBearbeitenButtonIsDisplayed() {
		return warenstammBearbeitenButton.isDisplayed();
	}

	public boolean warenstammBearbeitenButtonIsEnable() {
		return warenstammBearbeitenButton.isEnabled();
	}

	public boolean warenstammLoschenButtonIsDisplayed() {
		return warenstammLoschenButton.isDisplayed();
	}

	public boolean warenstammLoschenButtonIsEnable() {
		return warenstammLoschenButton.isEnabled();
	}

	public boolean warenstammDateiHochladenButtonIsDisplayed() {
		return warenstammDateiHochladenButton.isDisplayed();
	}

	public boolean warenstammDateiHochladenButtonIsEnable() {
		return warenstammDateiHochladenButton.isEnabled();
	}

	public boolean warenstammFilterButtonIsDisplayed() {
		return warenstammFilterButton.isDisplayed();
	}

	public boolean warenstammFilterButtonIsEnable() {
		return warenstammFilterButton.isEnabled();
	}

	public void clickOnWarenstammLoschenButton() {
		warenstammLoschenButton.click();
	}

	public void waitForLoschenClickMessageNoArtikleSelect() {
		wu.explicitWaitForWebElement(driver, warenstammLoschenButton, "id", "mainContent_btnDelete");
	}

	public String readLoschenkMessage() {
		return gu.getElementText(loschenMessage);
	}

	public int getWarenstammTableSize() {
		return warenstammTable.size();
	}

	public void clickWarenstammTableElementAnyWhere(int row, int column) {
		String tableElement = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (row + 1) + "]//td[" + (column + 1)
				+ "]";
		WebElement element = driver.findElement(By.xpath(tableElement));
		element.click();
	}

	public void doubleClickWarenstammTableElementAnyWhere(int row, int column) {
		String tableElement = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (row + 1) + "]//td[" + (column + 1)
				+ "]";
		WebElement element = driver.findElement(By.xpath(tableElement));
		gu.mouseDoubleClick(driver, element);
	}

	public String getTextWarenstammTableElement(int row, int column) {
		String tableElement = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (row + 1) + "]//td[" + (column + 1)
				+ "]";

		WebElement element = driver.findElement(By.xpath(tableElement));
		return element.getText();
	}

	public boolean checkWarrenstammNamePresentOrNotInArtikelStamPageHeading(String word, String scentence) {
		return gu.checkAWordPresentInScentence(word, scentence);
	}

	public boolean radioButtonOfWarenstammTableEnableOrNot(int row) {
		WebElement element = driver.findElement(By.xpath("//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (row + 1)
				+ "]//td[1]//div//input[@class='form-check-input']"));
		return element.isSelected();
	}

	public void scrollWarenstammTable() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
	}

	public void clickWarenstammHinzufugenButton() {
		warenstammHinzufugenButton.click();
	}

	public void sendWarenstammName() {
		String warenstammName = "WARSTM" + gu.randon(10000);
		this.warenstammName = warenstammName;
		gu.sendKeyFunction(warenstammNameField, warenstammName);
	}

	public String selectWarenstammName() {
		return warenstammName;
	}

	public void clickOnWarenstammHinzufugenSaveButton() {
		warenstammHinzufugenSaveButton.click();
	}

	public void clickWarrenstammIdCreatedRandomly() {
		for (int i = 0; i < warenstammTableBeschreibung.size(); i++) {
			if (warenstammTableBeschreibung.get(i).getText().equals(warenstammName)) {
				String productGroupId = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (i + 1) + "]//td[2]//span";
				WebElement productGroupIdElement = driver.findElement(By.xpath(productGroupId));
				productGroupIdElement.click();
			}
		}
	}

	public void doubleClickWarrenstammId() throws InterruptedException {
		// firstWarrenstammId.click();
		gu.mouseDoubleClick(driver, firstWarrenstammId);
		Thread.sleep(2000);
	}

	public String getCountOfNumberOfArtikelInWarenstamm(int i) {
		String artikelanzahlCount = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (i + 1) + "]//td[4]";
		WebElement artikelanzahlCountElement = driver.findElement(By.xpath(artikelanzahlCount));
		return artikelanzahlCountElement.getText();
	}

	public void clickWarrenstammIdByPassingValue(int i) {
		String productGroupId = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (i + 1) + "]//td[3]//span";
		WebElement productGroupIdElement = driver.findElement(By.xpath(productGroupId));
		productGroupIdElement.click();
	}

	public void doubleClickWarrenstammIdByPassingValue(int i) {
		String productGroupId = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (i + 1) + "]//td[2]//span";
		WebElement productGroupIdElement = driver.findElement(By.xpath(productGroupId));
		gu.mouseDoubleClick(driver, productGroupIdElement);
	}
	public void doubleClickWarrenstammAnyWhere(int row,int column) {
		String productGroupId = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (row + 1) + "]//td[" + (column + 1) + "]//span";
		WebElement productGroupIdElement = driver.findElement(By.xpath(productGroupId));
		gu.mouseDoubleClick(driver, productGroupIdElement);
	}
	public String getAttributeValueOfWholeBodyClass() {
		return gu.getAttributeValueOfElement(wholeBodyElement, "class");
	}

	public void clickOnDarkModeButton() {
		darkModeButton.click();
	}

	public void sendValueTosearchTextField(String input) {
		gu.sendKeyFunction(searchTextField, input);
	}

	public void clickOnSearchIcon() {
		searchIcon.click();
	}

	public String readNoDataAvailableText() {
		return noDataAvailableText.getText();
	}

	public void waitForNoDataAvailableText() {
		wu.explicitWaitForWebElementTextToBePresent(driver, noDataAvailableText, "Keine Daten vorhanden", 20);
	}

	public void waitForLoschenNotificationBarText() {
		wu.explicitWaitForWebElement(driver, notificationBarCloseButton, 10);
	}

	public void clickOnNotificationBarCloseButton() {
		notificationBarCloseButton.click();
	}

	public void writeWarenstamDataToExcel(int row, int column, String warenstammData) throws IOException {
		eu.fileWriteExcelWithoutAffectExistingData("\\src\\main\\resources\\Excel\\WarenstammTable.xlsx",
				"warenstammName", row, column, warenstammData);
	}

	public int getTotalCountOfArtikel() {
		int count = 0;
		for (int i = 0; i < warenstammTableBeschreibung.size(); i++) {
			String artikelanzahlCount = "//table[@id='Scroll_tbl_Warenstamm']//tbody//tr[" + (i + 1) + "]//td[4]";
			WebElement artikelanzahlCountElement = driver.findElement(By.xpath(artikelanzahlCount));
			String numberText = artikelanzahlCountElement.getText();
			int num = Integer.parseInt(numberText);
			count += num;
		}
		return count;
	}

	public void clickOnAuftragsprufungTabButton() {
		auftragsprufungTabButton.click();
	}

	public void clickOnArtikelstammButton() {
		artikelstammButton.click();
	}

	public void selectArtikelStammButton() {
		artikelstammTabButton.click();
	}
	
}
