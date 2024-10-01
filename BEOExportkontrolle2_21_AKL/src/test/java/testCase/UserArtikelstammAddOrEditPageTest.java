package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserGenehmigungenPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;

public class UserArtikelstammAddOrEditPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserArtikelstammAddOrEditPage uaaep;
	UserGenehmigungenPage ugp;

	@Test(groups="run")
	public void checkAlNumTriftNitchZuAusfuhrlistenGenehmigungTabColourTC53212Part1()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.selectFirmaFromDropDown();		
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				Thread.sleep(1000);				
				uaaep.sendValueToBegrundungForTriftnitchZu((i + 1));
				uaaep.clickOnAlNumberTriftnitchZuRadioButton((i + 1));				
			}
		}
		uaaep.clickOnSpeichernButton();
		
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link green";
		
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
		
	}

	@Test 
	public void checkAlNumTriftZuAusfuhrlistenGenehmigungTabColourTC53212Part2()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
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
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link red";
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
	}

	@Test (groups="checkAlNumTriftZuAusfuhrlistenGenehmigungTabColourTC53212Part3")
	public void checkAlNumTriftZuAusfuhrlistenGenehmigungTabColourTC53212Part3()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		ugp=new UserGenehmigungenPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
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
		uwp.clickOnGenehmigungsVerWaltungButton();
		ugp.clickOnAddGenehmigungenButton();
		ugp.addArtikelField(uasp.getAtikelNummerForExpectedString());
		Thread.sleep(1500);
		ugp.sendGenehmigungsNummer();
		ugp.sendInterneBenennung();		
		ugp.ClickOnArtderGenehmigungDropDown();
		ugp.ClickOnArtderGenehmigungDropDown();
		Thread.sleep(1000);
		ugp.sendGultigbis();
		ugp.addNeuenEmpfänger();
		ugp.clickOnMainSaveButton();
		Thread.sleep(1000);
		uwp.clickOnArtikelstammButton();
		Thread.sleep(1000);
		uwp.selectArtikelStammButton();
		Thread.sleep(1000);
		uwp.sendValueTosearchTextField(uasp.getAtikelNummerForExpectedString());
		Thread.sleep(1000);
		uwp.clickOnSearchIcon();
		Thread.sleep(1000);
		uwp.doubleClickWarrenstammAnyWhere(0,2);
		Thread.sleep(1000);
		uasp.doubleClickArtikelstammTableElementAnyWhere(0, 1);
		Thread.sleep(1000);	
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,		
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link green";
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
				
	}

	@Test (groups="TC54998Part1_CheckAlNumTriftZuAtlasCoseStart3OrX_TC55804")
	public void TC54998Part1_CheckAlNumTriftZuAtlasCoseStart3OrX_TC55804()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		Boolean status = false;
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();		
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();	
		uasp.sendArtikelNummerOnTextField();
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
		uaaep.clickOnAtlasUnterlagen();
		uaaep.clickOnAtlasVorgeschlagenTab();
		for (int i = 0; i < uaaep.getVorgeschlagenTableSize(); i++) {
			String atlasCode = uaaep.getVorgeschlagenTableElementText((i + 1), 2);
			if (atlasCode.length() > 0) {
				char firstChar = atlasCode.charAt(0);
				if (firstChar == '3' || firstChar == 'X') {
					status = true;
				} else {
					status = false;
				}
			}
			Assert.assertEquals(status, true, ":: Atlas code on trift zu not as expected");
		}
	}

	@Test 
	public void TC54998Part2CheckAlNumTriftNichtZuAtlasCoseStartY__TC55805()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		Boolean status = false;
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.sendValueToBegrundungForTriftnitchZu((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAtlasUnterlagen();
		uaaep.clickOnAtlasVorgeschlagenTab();
		for (int i = 0; i < uaaep.getVorgeschlagenTableSize(); i++) {
			String atlasCode = uaaep.getVorgeschlagenTableElementText((i + 1), 2);
			if (atlasCode.length() > 0) {
				char firstChar = atlasCode.charAt(0);
				if (firstChar == 'Y') {
					status = true;
				} else {
					status = false;
				}
			}
			Assert.assertEquals(status, true, ":: Atlas code on trift zu not as expected");
		}
	}

	@Test (groups="TC54998Part4CheckNoAtlasCoseThenTabGreen__TC55876")
	public void TC54998Part4CheckNoAtlasCoseThenTabGreen__TC55876()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link grey";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: There is No Atlas code then Atlas unterlagen tab colour not as expected");
	}

	@Test
	public void TC54998Part4CheckAlNumTriftZuAtlasCoseIsRed__TC55877()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();		
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
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
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link red";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}

	@Test 
	public void TC54998Part5CheckAlNumTriftNichtZuAtlasCodeIsOrange__TC55878()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();	
		umLp.selectFirmaFromDropDown();
		umLp.anmeldenClick();
		uwp.doubleClickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftnitchZuRadioButton((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link yellow";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}

	@Test 
	public void TC54998Part6CheckAlNumNothingCheckedAtlasCodeIsGrey__TC55879()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
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
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link grey",
				":: Atlas unterlagen tab colour when trift zu not as expected");
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftZuRadioButton((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link red",
				":: Atlas unterlagen tab colour when trift zu not as expected");
		
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftZuRadioButton((i + 1));
				uaaep.clickOnAlNumberTriftnitchZuRadioButton((i + 1));
				uaaep.sendValueToBegrundungForTriftnitchZu((i + 1));							
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link yellow",
				":: Atlas unterlagen tab colour when trift zu not as expected");
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuCheckedOrNot((i + 1)) == false) {
				uaaep.clickOnAlNumberTriftZuRadioButton((i + 1));
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link red",
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}
}
