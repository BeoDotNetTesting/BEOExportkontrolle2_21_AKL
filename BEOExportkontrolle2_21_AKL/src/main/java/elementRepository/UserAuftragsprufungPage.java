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

public class UserAuftragsprufungPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	String belegNummer;

	public UserAuftragsprufungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath="//span[text()='Erstellen']")
	WebElement erstellenButton;
	@FindBy(id="mainContent_txtBelegnummer")
	WebElement belegnummerField;
	@FindBy(id="mainContent_txtEmfangername")
	WebElement emfangerNameField;
	@FindBy(id="mainContent_txtStrabeNum")
	WebElement StrateUndHausnummerField;
	@FindBy(id="mainContent_txtPost")
	WebElement postleitzahlField;
	@FindBy(id="mainContent_txtOrt")
	WebElement ortField;
	@FindBy(id="mainContent_txtLand")
	WebElement landField;
	@FindBy(id="mainContent_txtRechnungsnummer")
	WebElement rechnungsNummerField;
	@FindBy(id="mainContent_txtLieferscheinnummer")
	WebElement lieferscheinNummerField;
	@FindBy(id="mainContent_txtRechnungsbetrag")
	WebElement rechnungsbetragField;
	@FindBy(id="mainContent_txtGesamtRohmasse")
	WebElement gesamtRohmasseField;
	@FindBy(xpath="//span[text()='Speichern']")
	WebElement speichernButton;
	@FindBy(xpath="//table[@id='Scroll_tbl_Auftragsprufung']//tbody//tr//td[2]")
	List<WebElement> auftragsprufungTableList;
	
	
	public void clickOnErstellenButton() {
		erstellenButton.click();
	}
	public void selectCountryForOrderFromSuggetion(String land) {
		String path="//ul//li[@class='ui-menu-item']//div[text()='"+land+"']";////ul[@id='ui-id-4']//li[@class='ui-menu-item']//div[text()='"+land+"']
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
	}
	
	public void sendValuesForOrder(String CountryCode,String land) throws InterruptedException {
		String belegNummer="BN"+gu.generateCurrentDateAndTime();
		this.belegNummer=belegNummer;
		belegnummerField.sendKeys(belegNummer);
		emfangerNameField.sendKeys("EmfangerName");
		StrateUndHausnummerField.sendKeys("StrateUndHausnummer");
		postleitzahlField.sendKeys("postleitzahl");
		ortField.sendKeys("Ort");		
		landField.sendKeys(CountryCode);
		Thread.sleep(1500);
		selectCountryForOrderFromSuggetion(land);
		//rechnungsNummerField.sendKeys("RechnungsNummer");
	//	lieferscheinNummerField.sendKeys("LieferscheinNummer");
		//rechnungsbetragField.sendKeys("Rechnungsbetrag");
		//gesamtRohmasseField.sendKeys("GesamtRohmasse");
	}	
	public void sendArtikelNummerForOrder(int row,String artikelNummer) {
		String path="//table[@id='tbl_OrderDetails']//tbody//tr["+row+"]//td[3]//input";
		WebElement element =driver.findElement(By.xpath(path));
		element.sendKeys(artikelNummer);
	}
	public void clickArtikelNumberFromSuggetion(String artikelNumber) {
		String path="//li[@class='ui-menu-item']//div[text()='"+artikelNumber+"']";
		WebElement element=driver.findElement(By.xpath(path));
		element.click();
	}
	public void clickOnSpeichernButton() {
		speichernButton.click();
	}
	public String getMessageCorrespondingOrder() {
		String message=null;
		for(int i=1;i<=auftragsprufungTableList.size();i++) {
		
			String path="//table[@id='Scroll_tbl_Auftragsprufung']//tbody//tr["+i+"]//td[2]";
			WebElement element=driver.findElement(By.xpath(path));
			if(element.getText().equals(belegNummer)) {
				String pathOfMessage="//table[@id='Scroll_tbl_Auftragsprufung']//tbody//tr["+i+"]//td[6]";
				WebElement elementOfMessage=driver.findElement(By.xpath(pathOfMessage));	
				message=elementOfMessage.getText();				 
			}
		}
		return message;
	}
	public String getFreigabeClassAttributeValueFromAuftragsprufungTable() {
		String freigabeStatus=null;
		for(int i=1;i<=auftragsprufungTableList.size();i++) {
		
			String path="//table[@id='Scroll_tbl_Auftragsprufung']//tbody//tr["+i+"]//td[2]";
			WebElement element=driver.findElement(By.xpath(path));
			if(element.getText().equals(belegNummer)) {
				String pathOfFreigabe="//table[@id='Scroll_tbl_Auftragsprufung']//tbody//tr["+i+"]//td[5]//a//i";
				WebElement elementOfFreigabe=driver.findElement(By.xpath(pathOfFreigabe));						
				freigabeStatus=gu.getAttributeValueOfElement(elementOfFreigabe, "class");
			}
		}
		return freigabeStatus;
	}
}
