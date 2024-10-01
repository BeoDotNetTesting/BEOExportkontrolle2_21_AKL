package elementRepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;

public class UserMasterLoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public UserMasterLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//ul//li[text()='BEO India Test']")
	WebElement beoIndiaTestFromDrop;
	@FindBy(xpath = "//div//ul//li[text()='Test By Akhil Sathyan']")
	WebElement testByAkhilSathyanFromDrop;
	@FindBy(xpath = "//div//div[@class='select-set']")
	WebElement bitteAuswahlenSelect;
	@FindBy(id = "radiouser")
	WebElement benutzerRadioButton;
	@FindBy(id = "radiofirma")
	WebElement firmaRadioButton;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//li[2]")
	WebElement artikelstammTabButton;
	@FindBy(xpath = "//ul[@class='select-list']//li")
	List<WebElement> userDropBox;
	@FindBy(xpath = "//nav[@id='navbar_main']//div//li[3] ")
	WebElement auftragprufungTabButton;
	@FindBy(id = "btnLogin")
	WebElement anmelden;

	public static String ExportkontrolleWebdata(int row, int column) throws IOException, InvalidFormatException {
		String data = ExcelUtilities.readDataFromExcelExportKontrolleRowColumn(row, column,
				"\\src\\main\\resources\\Excel\\Exportkontrol.xls", "ExportkontrolleData");
		return data;
	}

	public boolean bitteAuswahlenSelectIsDisplayed() {
		return bitteAuswahlenSelect.isDisplayed();
	}

	public boolean bitteAuswahlenSelectIsEnable() {
		return bitteAuswahlenSelect.isEnabled();
	}

	public boolean bitteAuswahlenSelectIsClickable() {
		return gu.isClickable(bitteAuswahlenSelect, driver);
	}
	public void scrollUserDropBox() {
		System.out.println(userDropBox.size());
		gu.clickJavaScriptExecutorByScroll(driver, userDropBox, 20);
	}

	public void selectFirmaFromDropDown() throws InvalidFormatException, IOException, InterruptedException {
		bitteAuswahlenSelect.click();
		String firmaElementString = "//div//ul//li[text()='" + ExportkontrolleWebdata(3, 2) + "']";				
		Thread.sleep(250);
		WebElement firmaElement = driver.findElement(By.xpath(firmaElementString));
		gu.scrollElementIntoView(driver, firmaElement);	
		Thread.sleep(250);
		firmaElement.click();		
		while(!bitteAuswahlenSelect.getText().equals(ExportkontrolleWebdata(3, 2))) {
			bitteAuswahlenSelect.click();		
			gu.scrollElementIntoView(driver, firmaElement);
			firmaElement.click();			
		}
	}
	public boolean benutzerRadioButtonIsDisplayed() {
		return benutzerRadioButton.isDisplayed();
	}

	public boolean benutzerRadioButtonIsEnable() {
		return benutzerRadioButton.isEnabled();
	}

	public boolean benutzerRadioButtonIsClickable() {
		return gu.isClickable(benutzerRadioButton, driver);

	}

	public void clickBenutzerRadioButton() {
		benutzerRadioButton.click();
	}

	public boolean benutzerRadioButtonIsSelected() {
		return benutzerRadioButton.isSelected();
	}

	public boolean firmaRadioButtonIsDisplayed() {
		return firmaRadioButton.isDisplayed();
	}

	public boolean firmaRadioButtonIsEnable() {
		return firmaRadioButton.isEnabled();
	}

	public boolean firmaRadioButtonIsClickable() {
		return gu.isClickable(firmaRadioButton, driver);
	}

	public void clickFirmaRadioButton() {
		firmaRadioButton.click();
	}

	public boolean firmaRadioButtonIsSelected() {
		return firmaRadioButton.isSelected();
	}

	public boolean anmeldenButtonIsDisplayed() {
		return anmelden.isDisplayed();
	}

	public boolean anmeldenButtonIsEnable() {
		return anmelden.isEnabled();
	}

	public boolean anmeldenButtonIsClickable() {
		return gu.isClickable(anmelden, driver);
	}

	public void anmeldenClick() {
		anmelden.click();
	}

	public void clickartikelstammTabButton() {
		artikelstammTabButton.click();
	}

	public void clickOnAuftragprufungTabButton() {
		auftragprufungTabButton.click();
	}
}
