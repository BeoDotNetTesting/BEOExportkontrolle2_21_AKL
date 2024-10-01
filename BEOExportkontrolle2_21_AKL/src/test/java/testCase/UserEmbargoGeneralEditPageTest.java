package testCase;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserEmbargoGeneralEditPage;
import elementRepository.UserEmbargoGeneralPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserEmbargoGeneralEditPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserArtikelstammAddOrEditPage uaaep;
	UserEmbargoGeneralPage uegp;
	UserEmbargoGeneralEditPage uegep;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(priority = 1,groups="checkEmbargoCountrySwitchToTrifftZu_TC56166")
	public void checkEmbargoCountrySwitchToTrifftZu_TC56166()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(1);
		uegep.clickOnVerordnungenButton();
		if (uegep.getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link yellow")) {
			uegep.clickOnEmbargoTriftZuButton();
			uegep.clickOnEmbargoSaveButton();
			uegp.waitForEmbargoNotificationMessage();
			Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Erfolgreich hinzugefügt",
					"Embargo country triftzuAdded Message not as expected");
			Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(1), "verordnungen breadcrumb-tab-link red",
					"Verordnungen colour in trifft Zu not as expected");
			String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
			uegep.clickOnEmbargoZuruckButton();
			//uegp.clickOnLanderubersicht();
			//uegp.clickOnDropDownOfLanderListe(2);
			Assert.assertEquals(uegp.getAlleAnzeigenColour(1), expectedBreadCrumbColour,
					"Bread Crumb Colour not as expected");
		} else if (uegep.getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link red")) {
			uegep.clickOnEmbargoTriftZuButton();
			uegep.clickOnEmbargoSaveButton();
			uegp.waitForEmbargoNotificationMessage();
			Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Erfolgreich hinzugefügt",
					"Embargo country triftzuAdded Message not as expected");
			Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(1), "verordnungen breadcrumb-tab-link yellow",
					"Verordnungen colour in trifft Zu not as expected");
			String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
			uegep.clickOnEmbargoZuruckButton();
			Thread.sleep(3000);
			//uegp.clickOnLanderubersicht();
			//uegp.clickOnDropDownOfLanderListe(2);
			Assert.assertEquals(uegp.getAlleAnzeigenColour(1), expectedBreadCrumbColour,
					"Bread Crumb Colour not as expected");
		}
	}

	@Test(priority = 2,groups="checkEmbargoCountrySwitchToTrifftNichtZu_TC56166")
	public void checkEmbargoCountrySwitchToTrifftNichtZu_TC56166()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(2);
		uegep.clickOnVerordnungenButton();
		if (uegep.getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link yellow")) {
			uegep.clickOnEmbargoTriftNichtZuButton();
			uegep.clickOnEmbargoSaveButton();
			uegp.waitForEmbargoNotificationMessage();
			Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Erfolgreich hinzugefügt",
					"Embargo country triftzuAdded Message not as expected");
			Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(1), "verordnungen breadcrumb-tab-link green",
					"Verordnungen colour in trifft Zu not as expected");
			String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
			uegep.clickOnEmbargoZuruckButton();
			//uegp.clickOnLanderubersicht();
			//uegp.clickOnDropDownOfLanderListe(2);
			Assert.assertEquals(uegp.getAlleAnzeigenColour(2), expectedBreadCrumbColour,
					"Bread Crumb Colour not as expected");
		} else if (uegep.getBackGroundColourOfBreadCrumbTab(1).equals("verordnungen breadcrumb-tab-link green")) {
			uegep.clickOnEmbargoTriftNichtZuButton();
			uegep.clickOnEmbargoSaveButton();
			uegp.waitForEmbargoNotificationMessage();
			Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Erfolgreich hinzugefügt",
					"Embargo country triftzuAdded Message not as expected");
			Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(1), "verordnungen breadcrumb-tab-link yellow",
					"Verordnungen colour in trifft Zu not as expected");
			String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
			uegep.clickOnEmbargoZuruckButton();
			//uegp.clickOnLanderubersicht();
			//uegp.clickOnDropDownOfLanderListe(2);
			Assert.assertEquals(uegp.getAlleAnzeigenColour(2), expectedBreadCrumbColour,
					"Bread Crumb Colour not as expected");
		}
	}

	@Test(priority = 3,groups="checkEmbargoCountryToAddWTN_TC56328")
	public void checkEmbargoCountryToAddWTN_TC56328() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(3);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWTNOnWarrenNummerField();
		uegep.clickOnAddWarenNummerButton();
		Thread.sleep(1500);
		Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(2), 
				"warennummernsperren breadcrumb-tab-link purple", "Verordnungen colour in trifft Zu not as expected");
		Assert.assertEquals(uegep.getWTNFronTable(1), uegep.getSendedWarenNummer(),
				"Verordnungen colour in trifft Zu not as expected");
		String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
		uegep.clickOnEmbargoZuruckButton();
		Assert.assertEquals(uegp.getAlleAnzeigenColour(3), expectedBreadCrumbColour,
				"Bread Crumb Colour not as expected");
	}
	@Test(priority = 4,groups="checkEmbargoCountryToAddWTN_2_Digit_TC56328")
	public void checkEmbargoCountryToAddWTN_2_Digit_TC56328() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(4);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWTNOnWarrenNummerFieldWithNDigit(2);
		uegep.clickOnAddWarenNummerButton();
		Thread.sleep(2000);
		Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(2),
				"warennummernsperren breadcrumb-tab-link purple", "Verordnungen colour in trifft Zu not as expected");
		Assert.assertEquals(uegep.getWTNFronTable(1), uegep.getSendedWarenNummer(),
				"Verordnungen colour in trifft Zu not as expected");
		String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
		uegep.clickOnEmbargoZuruckButton();
		Assert.assertEquals(uegp.getAlleAnzeigenColour(4), expectedBreadCrumbColour,
				"Bread Crumb Colour not as expected");
	}
	@Test(priority = 4,groups="checkEmbargoCountryToAddWTN_4_Digit_TC56328")
	public void checkEmbargoCountryToAddWTN_4_Digit_TC56328() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(5);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWTNOnWarrenNummerFieldWithNDigit(4);
		uegep.clickOnAddWarenNummerButton();
		Thread.sleep(2000);
		Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(2),
				"warennummernsperren breadcrumb-tab-link purple", "Verordnungen colour in trifft Zu not as expected");
		Assert.assertEquals(uegep.getWTNFronTable(1), uegep.getSendedWarenNummer(),
				"Verordnungen colour in trifft Zu not as expected");
		String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
		uegep.clickOnEmbargoZuruckButton();
		Assert.assertEquals(uegp.getAlleAnzeigenColour(5), expectedBreadCrumbColour,
				"Bread Crumb Colour not as expected");
	}
	@Test(priority = 4,groups="checkEmbargoCountryToAddWTN_6_Digit_TC56328")
	public void checkEmbargoCountryToAddWTN_6_Digit_TC56328() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		uegep = new UserEmbargoGeneralEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnLanderName(6);
		uegep.clickOnWarenNummernSperrenButton();
		uegep.sendWTNOnWarrenNummerFieldWithNDigit(6);
		uegep.clickOnAddWarenNummerButton();
		Thread.sleep(2000);
		Assert.assertEquals(uegep.getBackGroundColourOfBreadCrumbTab(2),
				"warennummernsperren breadcrumb-tab-link purple", "Verordnungen colour in trifft Zu not as expected");
		Assert.assertEquals(uegep.getWTNFronTable(1), uegep.getSendedWarenNummer(),
				"Verordnungen colour in trifft Zu not as expected");
		String expectedBreadCrumbColour = uegep.getActualTabColourOfBreadCrumbTab();
		uegep.clickOnEmbargoZuruckButton();
		Assert.assertEquals(uegp.getAlleAnzeigenColour(6), expectedBreadCrumbColour,
				"Bread Crumb Colour not as expected");
	}
}
