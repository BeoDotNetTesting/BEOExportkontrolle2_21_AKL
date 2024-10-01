package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "pass123" }, { "admin123", "b30s0fTw@r3" }, { "admi2n", "pass123" } };
	}

	@Test//(enabled=false)
	public void verifyLogin() throws IOException, InvalidFormatException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName(logIndata(1));
		lp.sendPassword(logIndata(4));
		lp.clickLoginButton();
		String actual = hp.getHomePageText();
		String expected = "Firmenverwaltung";
		Assert.assertEquals(actual, expected, "::signIn text not as expected");
	}

	@Test(dataProvider = "data-provider")
	public void verifyLogInWithIncorrectDetails(String userNameData, String passwordData)
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName(userNameData);
		lp.sendPassword(passwordData);
		lp.clickLoginButton();
		Thread.sleep(1000);
		String actual = lp.getLogInErrorMassage();
		String expected = "Login fehlgeschlagen, bitte versuchen Sie es erneut.";
		Assert.assertEquals(actual, expected, "::Error message of login not as Expected");
	}

	@Test//(enabled=false)
	public void verifyLoginWithExcel() throws IOException, InterruptedException, InvalidFormatException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName(logIndata(1));
		lp.sendPassword(logIndata(4));
		lp.clickLoginButton();
		String actual = hp.getHomePageText();
		String expected = "Firmenverwaltung";
		Assert.assertEquals(actual, expected, "::signIn text not as expected");
	}

}
