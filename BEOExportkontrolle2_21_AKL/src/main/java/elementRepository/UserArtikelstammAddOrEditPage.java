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



public class UserArtikelstammAddOrEditPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	String warenstammName, artikelNummer;

	public UserArtikelstammAddOrEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath = "//div[text()='Ausfuhrlisten']")
	WebElement ausfuhrlistenTab;
	@FindBy(xpath = "//table[@id='Tbl_Ausfhrliste']//tbody//tr//td[5]")//table[@id='Scroll_Tbl_Ausfhrliste']//tbody//tr//td[4]
	List<WebElement> alNummerTableSize;
	@FindBy(xpath = "//span[text()='Speichern']")
	WebElement speichernButton;
	@FindBy(xpath = "//div[text()='Genehmigung']")
	WebElement genehmigungTab;
	@FindBy(xpath = "//div[text()='Atlas-Unterlagen']")
	WebElement atlasUnterlagen;
	@FindBy(id = "mainContent_GenehmigungTab_txtCode")
	WebElement unterlagenCodierungField;
	@FindBy(id = "tab5")
	WebElement atlasVorgeschlagenTab;
	@FindBy(xpath = "//table[@id='Scroll_tbl_Vorgeschlagen']//tbody//tr//td[1]")
	List<WebElement> vorgeschlagenTableRadioButton;

	public int getVorgeschlagenTableSize() {
		return vorgeschlagenTableRadioButton.size();
	}

	public String getVorgeschlagenTableElementText(int row, int column) {
		String elementPath = "//table[@id='Scroll_tbl_Vorgeschlagen']//tbody//tr[" + row + "]//td[" + column + "]";
		WebElement element = driver.findElement(By.xpath(elementPath));
		return element.getText();
	}

	public void clickOnAtlasVorgeschlagenTab() {
		atlasVorgeschlagenTab.click();
	}

	public void clickOnAtlasUnterlagen() {
		atlasUnterlagen.click();
	}

	public void SendUnterlagenCodierungValue() {
		unterlagenCodierungField.sendKeys("Test");
	}

	public void clickOnGenehmigungTab() {
		genehmigungTab.click();
	}

	public void clickOnSpeichernButton() {
		speichernButton.click();
	}

	public void clickOnAusfuhrlistenTab() {
		ausfuhrlistenTab.click();
	}

	public int getAlNummerTableSize() {
		return alNummerTableSize.size();
	}

	public Boolean checkAlNumberIsTriftZuCheckedOrNot(int row) {
		String elementPath = "//table[@id='Tbl_Ausfhrliste']//tbody//tr[" + row + "]//td[5]//div";
		WebElement element = driver.findElement(By.xpath(elementPath));
		return element.isSelected();
	}

	public void clickOnAlNumberTriftZuRadioButton(int row) {
		String elementPath = "//table[@id='Tbl_Ausfhrliste']//tbody//tr[" + row + "]//td[5]//div";
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.click();
	}
	public void clickOnAlNumberTriftnitchZuRadioButton(int row) {
		String elementPath = "//table[@id='Tbl_Ausfhrliste']//tbody//tr[" + row + "]//td[6]//div";
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.click();
	}

	public void sendValueToBegrundungForTriftnitchZu(int row) {
		String elementPath = "//table[@id='Tbl_Ausfhrliste']//tbody//tr[" + row + "]//td[7]//input";
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.sendKeys("TrifftNitchZu Value" + row);
	}

	public String getAusfuhrlistenTabColour() {
		return gu.getAttributeValueOfElement(ausfuhrlistenTab, "class");
	}

	public String getGenehmigungTabColour() {
		return gu.getAttributeValueOfElement(genehmigungTab, "class");
	}

	public String getAtlasUnterlagenTabColour() {
		return gu.getAttributeValueOfElement(atlasUnterlagen, "class");
	}
}
