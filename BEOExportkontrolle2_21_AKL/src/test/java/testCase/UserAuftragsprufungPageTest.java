package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserAuftragsprufungPage;
import elementRepository.UserEmbargoGeneralEditPage;
import elementRepository.UserEmbargoGeneralPage;
import elementRepository.UserGenehmigungsVerWaltungPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserAuftragsprufungPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserEmbargoGeneralPage uegp;
	UserEmbargoGeneralEditPage uegep;
	UserAuftragsprufungPage uap;
	UserArtikelstammAddOrEditPage uaaep;
	UserGenehmigungsVerWaltungPage ugvwp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(groups = "countryIsLockedInEmbargoCheckForAllArticles_61436")
	public void countryIsLockedInEmbargoCheckForAllArticles_61436()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField();
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnEmbargoButton();
		Thread.sleep(500);
		uegp.selectLanderubersichtTableRows(0);
		Thread.sleep(500);
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		String landName = uegp.readEmbargoCountryTableElementText(0, 1);
		String Länderkürzel = uegp.readEmbargoCountryTableElementText(0, 2);
		String LandForOrder = Länderkürzel + " - " + landName;
		Thread.sleep(500);
		uegp.clickOnLanderName(1);
		Thread.sleep(500);
		uegep.clickOnVerordnungenButton();
		if (uegep.getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link yellow")) {
			Thread.sleep(500);
			uegep.clickOnEmbargoTriftZuButton();
			Thread.sleep(250);
		}
		uegep.clickOnEmbargoSaveButton();
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder(Länderkürzel, LandForOrder);
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		uap.clickOnSpeichernButton();
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), Constant.uap_OrderExpectedMessage,
				Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatus, Constant.uap_AssertionOrderStatus);
	}

	@Test(groups = "thereWTN_IsLockedForACountry_61585")
	public void thereWTN_IsLockedForACountry_61585() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField();
		String warrenNummer = uasp.sendRandomWarenNummer();
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnEmbargoButton();
		Thread.sleep(1000);
		uegp.selectLanderubersichtTableRows(2);
		Thread.sleep(500);
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		String landName = uegp.readEmbargoCountryTableElementText(1, 1);
		String Länderkürzel = uegp.readEmbargoCountryTableElementText(1, 2);
		String LandForOrder = Länderkürzel + " - " + landName;
		Thread.sleep(500);
		uegp.clickOnLanderName(2);
		Thread.sleep(500);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWarenNummerOnWarennummerOderKapitelSuchenField(warrenNummer);
		Thread.sleep(500);
		uegep.clickOnAddWarenNummerButton();
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder(Länderkürzel, LandForOrder);
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		uap.clickOnSpeichernButton();
		String expected = "Ein oder mehrere Warennummern, wurden für den Export in das Bestimmungsland „" + LandForOrder
				+ "“ gesperrt.";
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), expected, Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatus, Constant.uap_AssertionOrderStatus);
	}

	@Test(groups = "thereArtikelIsLockedForACountry_61600")
	public void thereArtikelIsLockedForACountry_61600() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField();
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnEmbargoButton();
		Thread.sleep(1000);
		uegp.selectLanderubersichtTableRows(2);
		Thread.sleep(500);
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		String landName = uegp.readEmbargoCountryTableElementText(2, 1);
		String Länderkürzel = uegp.readEmbargoCountryTableElementText(2, 2);
		String LandForOrder = Länderkürzel + " - " + landName;		
		Thread.sleep(500);
		uegp.clickOnLanderName(3);
		Thread.sleep(500);
		uegep.clickOnArtikelSperrenButton();
		uegep.sendOnartikelNummerSuchenField(artikelNumber);
		uegep.clickOnAddArtikelButton();
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder(Länderkürzel, LandForOrder);
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		uap.clickOnSpeichernButton();		
		String expected = "Ein oder mehrere Artikel wurden für das ausgewählte Bestimmungsland „" + LandForOrder
				+ "“ gesperrt.";		
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), expected, Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatus, Constant.uap_AssertionOrderStatus);
	}
	@Test(groups = "thereArtikelAndWTNIsLockedForACountry_61601")
	public void thereArtikelAndWTNIsLockedForACountry_61601() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField();
		String warrenNummer = uasp.sendRandomWarenNummer();
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnEmbargoButton();
		Thread.sleep(1000);
		uegp.selectLanderubersichtTableRows(2);
		Thread.sleep(500);
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		String landName = uegp.readEmbargoCountryTableElementText(2, 1);
		String Länderkürzel = uegp.readEmbargoCountryTableElementText(2, 2);
		String LandForOrder = Länderkürzel + " - " + landName;		
		Thread.sleep(500);
		uegp.clickOnLanderName(3);
		Thread.sleep(500);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWarenNummerOnWarennummerOderKapitelSuchenField(warrenNummer);
		Thread.sleep(500);
		uegep.clickOnAddWarenNummerButton();		
		uegep.clickOnArtikelSperrenButton();
		uegep.sendOnartikelNummerSuchenField(artikelNumber);
		uegep.clickOnAddArtikelButton();
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder(Länderkürzel, LandForOrder);
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		uap.clickOnSpeichernButton();	
		String expected = "Ein oder mehrere Artikel und Warennummern wurden für das ausgewählte Bestimmungsland „"+LandForOrder+"“ gesperrt.";	
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), expected, Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatus, Constant.uap_AssertionOrderStatus);
	}
	@Test(groups = "thereArtikelMarkedAsTrifftZu_61634")
	public void thereArtikelMarkedAsTrifftZu_61634() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField("38260090");		
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftZuRadioButton((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();		
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnEmbargoButton();
		Thread.sleep(1000);
		uegp.selectLanderubersichtTableRows(5);
		Thread.sleep(500);
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		String landName = uegp.readEmbargoCountryTableElementText(2, 1);
		String Länderkürzel = uegp.readEmbargoCountryTableElementText(2, 2);
		String LandForOrder = Länderkürzel + " - " + landName;		
		Thread.sleep(500);		
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder(Länderkürzel, LandForOrder);
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		uap.clickOnSpeichernButton();
		System.out.println(uap.getMessageCorrespondingOrder());
		String expected = "Ein oder mehrere Artikel unterliegen einer Ausfuhrgenehmigung.";
		System.out.println(expected);
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), expected, Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatus, Constant.uap_AssertionOrderStatus);
	}
	@Test(groups = "thereLicenseAddedUserGenehmigungsVerWaltungForArtikel_61635")
	public void thereLicenseAddedUserGenehmigungsVerWaltungForArtikel_61635() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		uap = new UserAuftragsprufungPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		ugvwp = new UserGenehmigungsVerWaltungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		String artikelNumber = uasp.getAtikelNummerForExpectedString();
		uasp.sendWarennummerOnTextField("38260090");		
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftZuRadioButton((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();		
		uasp.waitForZuruckButtonClick();
		uasp.clickOnZuruckButton();
		Thread.sleep(500);
		uwp.clickOnGenehmigungsVerWaltungButton();		
		ugvwp.clickOnAddGenehmigungsButton();
		ugvwp.fillAllgemeineInformationen();
		ugvwp.sendArtikelNummer(artikelNumber);
		Thread.sleep(500);		
		ugvwp.clickOnGenehmigungSaveButton();		
		uwp.clickOnArtikelstammButton();
		uwp.clickOnAuftragsprufungTabButton();
		uap.clickOnErstellenButton();
		uap.sendValuesForOrder("AD", "AD - Andorra");
		uap.sendArtikelNummerForOrder(1, artikelNumber);
		uap.clickArtikelNumberFromSuggetion(artikelNumber);
		Thread.sleep(500);
		ugvwp.sendValueOnGenehmigungHinterlegenField();
		Thread.sleep(500);
		uap.clickOnSpeichernButton();		
		String expected = "Ein oder mehrere Artikel sind genehmigungsprflichtig und haben eine Genehmigung.";		
		Assert.assertEquals(uap.getMessageCorrespondingOrder(), expected, Constant.uap_OrderExpectedMessage);
		Assert.assertEquals(uap.getFreigabeClassAttributeValueFromAuftragsprufungTable(),
				Constant.uap_ExpectedOrderStatusForGeneming, Constant.uap_AssertionOrderStatus); 
	}
}
