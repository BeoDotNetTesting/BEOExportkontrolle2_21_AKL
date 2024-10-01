package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserWarenstammPageTest extends BaseClass {
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	LoginPage lp;
	SoftAssert softAssert;
	GeneralUtilities gu = new GeneralUtilities();

	@Test 
	public void userWarenstammPageMainNavigationBarTest()
			throws InterruptedException, InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		boolean expected = true;	
		softAssert.assertEquals(uwp.artikelstammButtonIsDisplayed(), expected,
				":: artikelstammButton is not Displayed");
		softAssert.assertEquals(uwp.artikelstammButtonIsEnable(), expected, ":: artikelstammButton is not Enable");
		softAssert.assertEquals(uwp.archivButtonIsDisplayed(), expected, ":: archivButton is not Displayed");
		softAssert.assertEquals(uwp.archivButtonIsEnable(), expected, ":: archivButton is not Enable");		
		softAssert.assertEquals(uwp.embargoButtonIsDisplayed(), expected, ":: embargoButton is not Displayed");
		softAssert.assertEquals(uwp.embargoButtonIsEnable(), expected, ":: embargoButton is not Enable");
		softAssert.assertEquals(uwp.datenExportButtonIsDisplayed(), expected, ":: datenExportButton is not Displayed");
		softAssert.assertEquals(uwp.datenExportButtonIsEnable(), expected, ":: datenExportButton is not Enable");
	}

	@Test 
	public void userWarenstammPageFunctionalNavTest() throws InterruptedException, InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		boolean expected = true;
		softAssert.assertEquals(uwp.warenstammHinzufugenButtonIsDisplayed(), expected,
				":: atrikelstammZurukButtonatrikelstammHinzufugenButton is not Displayed");
		softAssert.assertEquals(uwp.warenstammHinzufugenButtonIsEnable(), expected,
				":: atrikelstammHinzufugenButton is not Enable");
		softAssert.assertEquals(uwp.warenstammBearbeitenButtonIsDisplayed(), expected,
				":: atrikelstammBearbeitenButton is not Displayed");
		softAssert.assertEquals(uwp.warenstammBearbeitenButtonIsEnable(), expected,
				":: atrikelstammBearbeitenButton is not Enable");
		softAssert.assertEquals(uwp.warenstammLoschenButtonIsDisplayed(), expected,
				":: artikelstammLoschenButton is not Displayed");
		softAssert.assertEquals(uwp.warenstammLoschenButtonIsEnable(), expected,
				":: artikelstammLoschenButton is not Enable");		
		softAssert.assertEquals(uwp.warenstammDateiHochladenButtonIsDisplayed(), expected,
				":: artikelstammDatei Hochladen Button is not Displayed");
		softAssert.assertEquals(uwp.warenstammDateiHochladenButtonIsEnable(), expected,
				":: artikelstammDatei Hochladen Button is not Enable");
		softAssert.assertEquals(uwp.warenstammFilterButtonIsDisplayed(), expected,
				":: artikelstamm Filter Button is not Displayed");
		softAssert.assertEquals(uwp.warenstammFilterButtonIsEnable(), expected,
				":: artikelstamm Filter Button is not Enable");
	}

	@Test
	public void verifyTheLoschenClickMessage_TC54176() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnWarenstammLoschenButton();
		try {
			gu.mediumDelay();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actal = uwp.readLoschenkMessage();
		String expected = "Bitte wählen Sie mindesten eine Zeile.";
		Assert.assertEquals(actal, expected, ":: Loschen click when no artikle select message not as expected");
	}

	@Test (groups="verifyPossibleToClickAnywhereInRowToTickCheckbox_TC54176")
	public void verifyPossibleToClickAnywhereInRowToTickCheckbox_TC54176() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 4; j++) {
				if(j!=1&&j!=2) {
				uwp.clickWarenstammTableElementAnyWhere(i, j);
				boolean actual1 = uwp.radioButtonOfWarenstammTableEnableOrNot(i);				
				Assert.assertEquals(actual1, true, ":: Radio Button is not Selected");				
				uwp.clickWarenstammTableElementAnyWhere(i, j+1);
				boolean actual2 = uwp.radioButtonOfWarenstammTableEnableOrNot(i);				
				Assert.assertEquals(actual2, false, ":: Radio Button is not Selected");				
				uwp.scrollWarenstammTable();
				}
			}
		}
	}

	@Test(priority = 1,groups="verifyPossibleToCreatOfWarenstamm_TC54307i")
	public void verifyPossibleToCreatOfWarenstamm_TC54307i() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickWarenstammHinzufugenButton();
		uwp.sendWarenstammName();
		uwp.clickOnWarenstammHinzufugenSaveButton();
		String expected = uwp.selectWarenstammName();
		String actual = uwp.getTextWarenstammTableElement(0, 2);
		Assert.assertEquals(actual, expected, ":: Warren name not as expected");
	}

	@Test(priority = 2)
	public void verifyTheDeleteButtonFunWhileCancelAlertMessage_TC54456()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		String expected = "Produktgruppe : " + uwp.getTextWarenstammTableElement(0, 1) + "  beschreibung : "
				+ uwp.getTextWarenstammTableElement(0, 2) + "  artikelanzahl : "
				+ uwp.getTextWarenstammTableElement(0, 3);
		int columnNumber = gu.randon(3);
		uwp.clickWarenstammTableElementAnyWhere(0, columnNumber);
		uwp.clickOnWarenstammLoschenButton();
		gu.alertDismiss(driver);
		String actual = "Produktgruppe : " + uwp.getTextWarenstammTableElement(0, 1) + "  beschreibung : "
				+ uwp.getTextWarenstammTableElement(0, 2) + "  artikelanzahl : "
				+ uwp.getTextWarenstammTableElement(0, 3);
		Assert.assertEquals(actual, expected, "::Warenstamm Loschen Alert dismiss not as expected");
	}

	@Test(priority = 3)
	public void verifyTheDeleteButtonFunWhileAcceptAlertMessage_TC54456()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		int columnNumber = gu.randon(3);
		uwp.clickWarenstammTableElementAnyWhere(0, columnNumber);
		String selectedProduktgruppe = uwp.getTextWarenstammTableElement(0, 1);
		uwp.clickOnWarenstammLoschenButton();
		gu.alertAccept(driver);
		uwp.waitForLoschenNotificationBarText();
		String actualNotificationMessage = "Artikelstamm - " + uwp.readLoschenkMessage();
		String expectedNotificationMessage = "Artikelstamm - Gelöscht";
		Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage,
				"::Notification Bar Message not as expected");
		uwp.clickOnNotificationBarCloseButton();
		uwp.sendValueTosearchTextField(selectedProduktgruppe);
		uwp.clickOnSearchIcon();
		String expected = "Keine Daten vorhanden";
		uwp.waitForNoDataAvailableText();
		Thread.sleep(1000);
		String actual = uwp.readNoDataAvailableText();
		Assert.assertEquals(actual, expected, "::Warenstamm deletion not as expected");
	}

	@Test 
	public void verifyDarkModeButtonChange_TC54423() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.clickOnDarkModeButton();
		String actual = uwp.getAttributeValueOfWholeBodyClass();
		String expected = "bck-color-black";
		System.out.println("actual:" + actual + "expected:" + expected);
		Assert.assertEquals(actual, expected, "::Background colour not as expeted");
	}

	@Test
	public void verifyToWriteWarenstamDataToExcel() throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		for (int i = 0; i < uwp.getWarenstammTableSize(); i++) {
			for (int j = 0; j < 3; j++) {
				uwp.writeWarenstamDataToExcel((i + 1), j, uwp.getTextWarenstammTableElement(i, (j + 1)));
			}
		}
	}

	@Test(groups="doubleClickOnWarrenstammShouldOpenCorrespondingWarrenstamm_TC58938")
	public void doubleClickOnWarrenstammShouldOpenCorrespondingWarrenstamm_TC58938()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		for (int i = 0; i < 3; i++) {
			boolean actual = false;
			String beschreibung = uwp.getTextWarenstammTableElement(i, 1);			
			Thread.sleep(1000);
			if(i!=1) {//Because 2nd column not visible
			uwp.doubleClickWarenstammTableElementAnyWhere(i, i);	
			}
			Thread.sleep(1000);
			String warrenstammHeading = uasp.readHeadingOfWarenstammWarengruppe();
			Thread.sleep(1000);
			if (warrenstammHeading.contains(beschreibung)) {
				actual = true;
			}
			Assert.assertEquals(actual, true, "::When double click On warrengroup the heading not as expected");
			uasp.clickOnZuruckButton();
			Thread.sleep(1000);
		}

	}
}
