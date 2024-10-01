package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	String customerNumberValue;
	WebElement locator;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Firmenverwaltung']")
	WebElement homePageText;
	@FindBy(xpath = "//a//span[text()='Hinzufügen']")
	WebElement addToButton;
	@FindBy(id = "mainContent_uc_UCAlgemein_txt_Kundenum")
	WebElement customerNumber;
	@FindBy(id = "mainContent_uc_UCAlgemein_txt_firmanname")
	WebElement companyName;
	@FindBy(xpath = "//div[@class='col-sm-6']//div[text()='Bitte auswählen...']")
	WebElement differentLocations;
	@FindBy(xpath = "//div[@class='col-sm-6']//li[text()='BEO-EXPORTKONTROLLE-BASIC']")
	WebElement optionDifferentLocation;
	@FindBy(id = "mainContent_uc_UCAlgemein_txt_notizen")
	WebElement notes;
	@FindBy(id = "mainContent_btnsave_tab1")
	WebElement saveButton;
	@FindBy(xpath = "//span[text()='Zurück']")
	WebElement returnButton;
	@FindBy(xpath = "//table[@class='content-table ']//tbody//tr//td[3]")
	List<WebElement> companyTable;
	@FindBy(xpath = "//table[@class='content-table ']//tbody//tr[2]//td[3]") // table[@id='tbl_firma']//tbody//tr[2]//td[2]
	WebElement companyNameTable;
	@FindBy(xpath = "//div[@class='paginate']//button[2]")
	WebElement forwardPagination;
	@FindBy(xpath = "//div[@class='paginate']//button[1]")
	WebElement reversePagination;
	@FindBy(xpath = "//span[text()='Löschen']")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//ul[1]//li[6]//a[@class='nav-link']")
	WebElement logOutButton;

	public String getHomePageText() {
		return gu.getElementText(homePageText);
	}

	public void clickOnAddToButton() {
		addToButton.click();
	}

	public void sendCustomerNumber() {
		String customerNumberValue = "AKL" + gu.randon(1000);
		this.customerNumberValue = customerNumberValue;
		gu.sendKeyFunction(customerNumber, customerNumberValue);
	}

	public void sendCompanyName() {
		gu.sendKeyFunction(companyName, "ELCOME");
	}

	public void clickOnDifferentLocations() {
		differentLocations.click();
	}

	public void selectOptionFromDifferentLocation() {
		optionDifferentLocation.click();
	}

	public void sendNotes() {
		gu.sendKeyFunction(notes, "Ernakulam Cochin");
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickReturnButton() {
		returnButton.click();
	}

	public Boolean deleteButtonClickable() {
		return deleteButton.isEnabled();
	}

	public void clickLogOutButton() {
		logOutButton.click();
	}

	public String getTextFromTable() throws Exception {

		String path = gu.selectRowValueFromDynamicTable(companyTable, "ELCOME",
				"//table[@class='content-table ']//tbody//tr[", "]//td[3]");
		if (path == null) {
			forwardPagination.click();
			path = gu.selectRowValueFromDynamicTable(companyTable, "ELCOME",
					"//table[@class='content-table ']//tbody//tr[", "]//td[3]");
		}
		return driver.findElement(By.xpath(path)).getText();
	}

}
