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

public class UserGenehmigungsVerWaltungPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu=new ExcelUtilities();
	
	public UserGenehmigungsVerWaltungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@id='tbl_GenemigungArtikels']//tbody//tr")
	List<WebElement> genemigungArtikelsList;
	@FindBy(xpath="//span[text()='Hinzufügen']")
	WebElement addGenehmigungsButton;
	@FindBy(id="mainContent_txt_Genehmigungsnummer")
	WebElement genehmigungsNummerField;
	@FindBy(id="mainContent_txt_InterneBenennung")
	WebElement interneBenennungField;
	@FindBy(xpath="//div[@class='card-body']//div[4]//div[@class='col-sm-6']//div//div[2]")
	WebElement artDerGenehmigungField;
    @FindBy(xpath="//div[@class='card-body']//div[4]//div[@class='col-sm-6']//div//div[3]//ul//li[2]")
    WebElement optionFromartDerGenehmigungField;
	@FindBy(xpath="//div[@class='card-body']//div[5]//div[@class='col-sm-6']//div//div[2]")
	WebElement zusatzField;
	@FindBy(xpath="//div[@class='card-body']//div[5]//div[@class='col-sm-6']//div//div[3]//ul//li[2]")
	WebElement optionFromZusatzField;
	@FindBy(id="mainContent_txt_Gultigbis")
	WebElement gultigBisField;
	@FindBy(xpath="//table[@id='tbl_GenemigungArtikels']//tbody//tr//td[3]//input")
	WebElement artikelNumberField;
	@FindBy(xpath="//ul[@id='ui-id-1']//li[1]//div")
	WebElement artikelNummerSuggetion;
	@FindBy(xpath="//a[@id='mainContent_btnSave']//span[text()='Speichern']")
	WebElement genehmigungSaveButton;
	@FindBy(id="mainContent_txtGenehmigung")
	WebElement genehmigungHinterlegenField;
	@FindBy(xpath="//ul[@id='ui-id-2']//li//div")
	WebElement genehmigungHinterlegenSuggetion;
	
	public void sendArtikelValueOnGenemigungArtikelsField(String artikelNummer) {
		String path= "//table[@id='tbl_GenemigungArtikels']//tbody//tr["+genemigungArtikelsList.size()+"]//td[3]//input";
		WebElement element=driver.findElement(By.xpath(path));
		element.sendKeys(artikelNummer);
	}
	public void clickOnAddGenehmigungsButton() {
		addGenehmigungsButton.click();
	}
	public void fillAllgemeineInformationen() {
		genehmigungsNummerField.sendKeys("GN"+gu.generateCurrentDateAndTime());
		interneBenennungField.sendKeys("IB"+gu.generateCurrentDateAndTime());
		artDerGenehmigungField.click();
		optionFromartDerGenehmigungField.click();
		zusatzField.click();
		optionFromZusatzField.click();
		gultigBisField.sendKeys(gu.generateCurrentDateByPattern("dd.MM.yyyy"));
		
	}
	public void sendArtikelNummer(String artikelNummer) {
		artikelNumberField.sendKeys(artikelNummer);
	wu.explicitWaitForWebElement(driver, artikelNummerSuggetion, 1000);
	artikelNummerSuggetion.click();
	
	}
	public void clickOnGenehmigungSaveButton() {
		genehmigungSaveButton.click();
	}
	public void sendValueOnGenehmigungHinterlegenField() {
		genehmigungHinterlegenField.sendKeys("GN");
		wu.explicitWaitForWebElement(driver, genehmigungHinterlegenSuggetion, 1000);
		genehmigungHinterlegenSuggetion.click();
	}
}
