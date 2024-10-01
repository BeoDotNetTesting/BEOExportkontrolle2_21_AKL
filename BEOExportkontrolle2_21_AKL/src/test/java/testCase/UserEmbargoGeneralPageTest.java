package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserEmbargoGeneralEditPage;
import elementRepository.UserEmbargoGeneralPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserEmbargoGeneralPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserArtikelstammAddOrEditPage uaaep;
	UserEmbargoGeneralPage uegp;
	UserEmbargoGeneralEditPage uegep;
	GeneralUtilities gu = new GeneralUtilities();
	SoftAssert softAssert;

	@Test(priority = 2,groups="checkWeatherCanAddEmbargoCountry_TC56116i")
	public void checkWeatherCanAddEmbargoCountry_TC56116i()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		int allLanderTableSize = uegp.getTableSizeOfLanderubersicht();
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.waitForEmbargoNotificationMessage();
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Embargo erfolgreich aktualisiert",
				":: Country added message not as expected");
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		Assert.assertEquals(uegp.getTableSizeOfLanderListeLanderTable(), allLanderTableSize,
				":: Selected country number Not As Expected");
	}

	@Test(priority = 1,groups="verifyToDeleteSelectedEmbargoCountry_TC56117")
	public void verifyToDeleteSelectedEmbargoCountry_TC56117()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnSelectAllSelectedCountryRadioButton();
		uegp.clcickOnSelectedCountryLoschenButton();
		gu.alertAccept(driver);
		uegp.waitForEmbargoNotificationMessage();
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Gelöscht",
				":: Country added message not as expected");

	}

	@Test(priority = 2,groups="checkWeatherCanAddEmbargoCountry_TC56116")
	public void checkWeatherCanAddEmbargoCountry_TC56116()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		int allLanderTableSize = uegp.getTableSizeOfLanderubersicht();
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.waitForEmbargoNotificationMessage();
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Embargo erfolgreich aktualisiert",
				":: Country added message not as expected");
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		Assert.assertEquals(uegp.getTableSizeOfLanderListeLanderTable(), allLanderTableSize,
				":: Selected country number Not As Expected");
	}

	@Test(groups = "doubleClickOnEmbargoLandShouldOpenCorrespondingEmbargoLand_TC58941")
	public void doubleClickOnEmbargoLandShouldOpenCorrespondingEmbargoLand_TC58941()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		Thread.sleep(1000);
		uegp.clickOnLanderubersicht();
		Thread.sleep(1000);
		uegp.clickOnDropDownOfLanderListe(2);

		for (int i = 0; i < 5; i++) {
			String embargoLandNAmeFromTable = uegp.readEmbargoCountryNameFromTable(i, 1);
			Thread.sleep(1000);
			uegp.doubleClickEmbargoTableElementAnyWhere(i, i);
			Thread.sleep(1000);
			String embargoLandName = uegep.getAttributeValueOfLanderNameFieldValue();
			Thread.sleep(1000);
			Assert.assertEquals(embargoLandName, embargoLandNAmeFromTable, "Embargo Land name not as expected");
			uegep.clickOnEmbargoZuruckButton();
			Thread.sleep(1000);
		}
	}
	@Test(priority = 2,groups="verifyErrorMessageWhileSaveWithOutSelectAnyCountry")
	public void verifyErrorMessageWhileSaveWithOutSelectAnyCountry()throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		uegp.clickOnHinzufugenButton();		
		uegp.waitForReadEmbargoNotificationAlertDangerMessage();
		System.out.println(uegp.readEmbargoNotificationAlertDangerMessage());
		Assert.assertEquals(uegp.readEmbargoNotificationAlertDangerMessage(), "Bitte wählen Sie mindesten eine Zeile.",
				":: Embargo - Please select at least one line message not as expected");
		uegp.clickOnNotificationCloseButton();		
	}
	@Test(groups="test")
	public void testFirma()throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		
	}
}
