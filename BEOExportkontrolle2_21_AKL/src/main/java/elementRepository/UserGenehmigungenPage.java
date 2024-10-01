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

public class UserGenehmigungenPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();

	public UserGenehmigungenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Hinzufügen']")
	WebElement genehmigungenAddButton;
	@FindBy(xpath = "//table[@id='tbl_GenemigungArtikels']//tbody//tr")
	List<WebElement> GenehmigteArtikelList;
	@FindBy(id = "mainContent_txt_Genehmigungsnummer")
	WebElement genehmigungsNummerField;
	@FindBy(id = "mainContent_txt_InterneBenennung")
	WebElement interneBenennungField;
	@FindBy(xpath = "//div[@class='card-body']//div[4]//div//div//div[@class='select-set select-set-dark']")
	WebElement artderGenehmigungDropDown;
	@FindBy(xpath = "//div[@class='card-body']//div[4]//div//div//div[3]//ul//li")
	List<WebElement> artDerGenehmigungOptions;
	@FindBy(xpath = " //div[@class='card-body']//div[5]//div//div//div[@class='select-set select-set-dark']")
	WebElement zusatzDropDown;
	@FindBy(xpath = "//div[@class='card-body']//div[5]//div//div//div[3]//ul//li")
	List<WebElement> zusatzOptions;
	@FindBy(id = "mainContent_txt_Gultigbis")
	WebElement gultigbis;
	@FindBy(xpath = "//span[text()='Neuen Empfänger hinzufügen']")
	WebElement neuenEmpfängerHinzufügen;
	@FindBy(id = "mainContent_txt_firmenname")
	WebElement firmenName;
	@FindBy(id = "mainContent_txt_strabe")
	WebElement strabeHausnummer;
	@FindBy(xpath = "//div[@class='info-popup-content']//div[3]//div//div[@class='select-set select-set-dark']")
	WebElement landDropDown;
	@FindBy(xpath = "//div[@class='info-popup-content']//div[3]//div//div[3]//ul//li")
	List<WebElement> landListSize;
	@FindBy(id="mainContent_txt_ansprechpartner")
	WebElement ansprechPartner;
	@FindBy(xpath="//a[@id='btnAddRecipient']//span")
	WebElement addRecipientSaveButton;
	@FindBy(xpath="//div[@class='info-popup-content']//div[3]//div//div[3]//ul//li[2]")
	WebElement landAD;
	@FindBy(xpath="//a[@id='mainContent_btnSave']//span")
	WebElement mainSaveButton;

	public UserGenehmigungenPage clickOnAddGenehmigungenButton() {
		genehmigungenAddButton.click();
		return this;
	}

	public void addArtikelField(String artikelNumber) {
		String path = "//input[@class='artikelnummer" + (GenehmigteArtikelList.size() - 1) + " ui-autocomplete-input']";
		WebElement element = driver.findElement(By.xpath(path));
		element.clear();
		element.sendKeys(artikelNumber);
	}

	public void sendGenehmigungsNummer() {
		genehmigungsNummerField.sendKeys("GN" + gu.randon(1000));
	}

	public void sendInterneBenennung() {
		interneBenennungField.sendKeys("IB" + gu.randon(100));
	}

	public void ClickOnArtderGenehmigungDropDown() {
		artderGenehmigungDropDown.click();
		/*
		 * int zusatzOptionsNum=gu.randon(zusatzOptions.size()); if(zusatzOptionsNum==0)
		 * { zusatzOptionsNum=1; } String
		 * path="//div[@class='card-body']//div[5]//div//div//div[3]//ul//li["+
		 * zusatzOptionsNum+"]";
		 */
		String path = "//div[@class='card-body']//div[4]//div//div//div[3]//ul//li[2]";
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
	}

	public void clickOnZusatzDropDown() {
		zusatzDropDown.click();
		/*
		 * int artDerGenehmigungOptionsNum=gu.randon(artDerGenehmigungOptions.size());
		 * if(artDerGenehmigungOptionsNum==0) { artDerGenehmigungOptionsNum=1; } String
		 * path="//div[@class='card-body']//div[4]//div//div//div[3]//ul//li["+
		 * artDerGenehmigungOptionsNum+"]";
		 */
		String path = "//div[@class='card-body']//div[5]//div//div//div[3]//ul//li[2]";
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
	}

	public void sendGultigbis() {
		gultigbis.sendKeys(gu.generateCurrentDateByPattern("dd.MM.yyyy"));
	}

	public void addNeuenEmpfänger() {
		String path = null;
		neuenEmpfängerHinzufügen.click();
		firmenName.sendKeys("F" + gu.generateCurrentDateAndTime());
		strabeHausnummer.sendKeys(gu.randon(99) + "");
		landDropDown.click();

		/*int landNum = gu.randon(landListSize.size());
		if (landNum == 0) {
			path = "//div[@class='info-popup-content']//div[3]//div//div[3]//ul//li[2]";
		} else {
			path = "//div[@class='info-popup-content']//div[3]//div//div[3]//ul//li[" + landNum + "]";
		}
		WebElement element = driver.findElement(By.xpath(path));
		element.click();*/
		landAD.click();
		ansprechPartner.sendKeys("ansprechPartner");
		addRecipientSaveButton.click();
	}
	public void clickOnMainSaveButton() {
		mainSaveButton.click();
	}
}
