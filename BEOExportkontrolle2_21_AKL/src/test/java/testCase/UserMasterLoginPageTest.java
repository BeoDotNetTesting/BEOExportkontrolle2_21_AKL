package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.UserMasterLoginPage;

public class UserMasterLoginPageTest extends BaseClass {
	UserMasterLoginPage umLp;
	LoginPage lp;	
	SoftAssert softAssert;

	@Test
	public void userMasterLoginPageBasicTest() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		umLp = new UserMasterLoginPage(driver);
		softAssert = new SoftAssert();
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		boolean expected = true;
		umLp.bitteAuswahlenSelectIsEnable();
		softAssert.assertEquals(umLp.bitteAuswahlenSelectIsDisplayed(), expected,
				":: bitte Auswahlen Select is not Displayed");
		softAssert.assertEquals(umLp.bitteAuswahlenSelectIsEnable(), expected,
				":: bitte Auswahlen Select is not Enable");
		softAssert.assertEquals(umLp.benutzerRadioButtonIsDisplayed(), expected,
				":: bbenutzer Radio Button is not Displayed");
		softAssert.assertEquals(umLp.benutzerRadioButtonIsEnable(), expected,
				":: bbenutzer Radio Button is not Enable");
		softAssert.assertEquals(umLp.benutzerRadioButtonIsSelected(), expected,
				":: bbenutzer Radio Button is not Selectable");
		softAssert.assertEquals(umLp.firmaRadioButtonIsEnable(), expected, ":: firma Radio Button is not Enable");
		//softAssert.assertEquals(umLp.firmaRadioButtonIsSelected(), "false", ":: firma Radio Button is not Selectable");
		softAssert.assertEquals(umLp.anmeldenButtonIsEnable(), expected, ":: anmelden Button is not Enable");
		softAssert.assertAll();
	}
}
