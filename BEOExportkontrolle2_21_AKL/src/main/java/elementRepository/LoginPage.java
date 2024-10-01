package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUserName")
	WebElement userName;
	@FindBy(id = "txtPassword")
	WebElement password;
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	@FindBy(id = "lblErrMessage")
	WebElement logInErrorMessage;
	@FindBy(xpath = "//h2[text()='Anmelden']")
	WebElement registerText;	

	public void sendUserName(String userNAmeValue) {
		userName.sendKeys(userNAmeValue);
	}

	public void sendPassword(String passwordValue) {
		password.sendKeys(passwordValue);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getLogInErrorMassage() {
		return gu.getElementText(logInErrorMessage);
	}

	public String getRegisterText() {
		return gu.getElementText(registerText);
	}

}
